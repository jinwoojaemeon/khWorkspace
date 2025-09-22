package com.project.lifegame.controller;
import static com.project.lifegame.view.DisplayMsg.displayFail;
import static com.project.lifegame.view.DisplayMsg.displaySuccess;

import java.util.ArrayList;

import com.project.lifegame.model.vo.Stock;
import com.project.lifegame.service.StockService;

public class StockController {
    private StockService ss;
    
    public StockController() {
        super();
        this.ss = new StockService();
    }
    
    // 모든 주식 가격 업데이트 (매번 일하기/자기개발 후 호출)
    public void updateAllStockPrices(int characterId) {
        int result = ss.updateAllStockPrices(characterId);
        if(result <= 0) {
            displayFail("주식 변동에 실패했습니다.");
        } 
    }
    
    // 특정 주식의 현재 가격 조회
    public int getCurrentStockPrice(int characterId, int stockId) {
        return ss.getCurrentStockPrice(characterId, stockId);
    }
    
    // 모든 주식 목록 조회 (현재 가격 포함)
    public ArrayList<Stock> getAllStocks(int characterId) {
        return ss.getAllStocks(characterId);
    }
    
    // 주식 구매
    public void buyStock(int characterId, int stockId, int count, int price) {
        int result = ss.buyStock(characterId, stockId, count, price);
        if(result > 0) {
            displaySuccess("주식 구매가 완료되었습니다.");
        } else {
            displayFail("주식 구매에 실패했습니다.");
        }
    }
    
    // 주식 판매
    public void sellStock(int characterId, int stockId, int count) {
        int result = ss.sellStock(characterId, stockId, count);
        if(result > 0) {
            displaySuccess("주식 판매가 완료되었습니다.");
        } else {
            displayFail("주식 판매에 실패했습니다.");
        }
    }
    
    // 총 주식 가치 조회
    public int getTotalStockValue(int characterId) {
        return ss.getTotalStockValue(characterId);
    }
    
    // === 기존 메서드들 (호환성 유지) ===
    @Deprecated
    public void updateStockPrice(int characterId) {
        updateAllStockPrices(characterId);
    }
    
    @Deprecated
    public int getCurrentStockPrice(int characterId) {
        // 기본적으로 첫 번째 주식(삼선전자) 가격 반환
        return getCurrentStockPrice(characterId, 1);
    }
}