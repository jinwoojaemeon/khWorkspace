package com.project.lifegame.service;
import static com.project.lifegame.common.LifegameTemplate.close;
import static com.project.lifegame.common.LifegameTemplate.commit;
import static com.project.lifegame.common.LifegameTemplate.getConnection;
import static com.project.lifegame.common.LifegameTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.project.lifegame.model.dao.StockDao;
import com.project.lifegame.model.vo.Stock;

public class StockService {
    private StockDao sd;

    public StockService() {
        super();
        sd = new StockDao();
    }
    
    // 모든 주식 가격 업데이트 (모든 주식 가격 변동)
    public int updateAllStockPrices(int characterId) {
        Connection conn = getConnection();
        int result = 0;
        
        try {
            // 5개 주식 모두 가격 변동
            for(int stockId = 1; stockId <= 5; stockId++) {
                int currentPrice = sd.getStockPrice(characterId, stockId, conn);
                
                // 변동 알고리즘 적용 (-10% ~ +11%)
                double changeRate = -0.10 + (Math.random() * 0.21);
                int newPrice = Math.max(1, (int)(currentPrice * (1 + changeRate)));
                
                result += sd.updateStockPrice(characterId, stockId, newPrice, conn);
            }
            
            if(result > 0) {
                commit(conn);
            } else {
                rollback(conn);
            }
        } finally {
            close(conn);
        }
        return result;
    }
    
    // 특정 주식 현재 가격 조회
    public int getCurrentStockPrice(int characterId, int stockId) {
        Connection conn = getConnection();
        int stockPrice = sd.getStockPrice(characterId, stockId, conn);
        close(conn);
        return stockPrice;
    }
    
    // 모든 주식 목록 조회
    public ArrayList<Stock> getAllStocks(int characterId) {
        Connection conn = getConnection();
        ArrayList<Stock> stockList = sd.getAllStocks(conn);
        
        // 각 주식의 현재 가격 정보 추가
        for(Stock stock : stockList) {
            int currentPrice = sd.getStockPrice(characterId, stock.getStockId(), conn);
            stock.setPrice(currentPrice);
        }
        
        close(conn);
        return stockList;
    }
    
    // 주식 구매
    public int buyStock(int characterId, int stockId, int count, int price) {
        Connection conn = getConnection();
        int result = sd.buyStock(characterId, stockId, count, price, conn);
        
        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        close(conn);
        return result;
    }
    
    // 주식 판매
    public int sellStock(int characterId, int stockId, int count) {
        Connection conn = getConnection();
        int result = sd.sellStock(characterId, stockId, count, conn);
        
        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        close(conn);
        return result;
    }
    
    // 캐릭터 주식 초기화
    public int initializeCharacterStocks(int characterId) {
        Connection conn = getConnection();
        int result = sd.initializeCharacterStocks(characterId, conn);
        
        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        close(conn);
        return result;
    }
    
    // 캐릭터의 주식 보유 현황 조회
    public ArrayList<Stock> getCharacterStocks(int characterId) {
        Connection conn = getConnection();
        ArrayList<Stock> stockList = sd.getCharacterStocks(characterId, conn);
        close(conn);
        return stockList;
    }
    
    // 총 주식 가치 조회
    public int getTotalStockValue(int characterId) {
        Connection conn = getConnection();
        int totalValue = sd.getTotalStockValue(characterId, conn);
        close(conn);
        return totalValue;
    }
}