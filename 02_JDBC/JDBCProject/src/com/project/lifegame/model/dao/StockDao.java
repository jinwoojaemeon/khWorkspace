package com.project.lifegame.model.dao;
import static com.project.lifegame.common.LifegameTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.project.lifegame.model.vo.Stock;

public class StockDao {
    private Properties prop = new Properties();
    
    public StockDao() {
        super();
        try {
            prop.loadFromXML(new FileInputStream("resources/query.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // 모든 주식 목록 조회
    public ArrayList<Stock> getAllStocks(Connection conn) {
        ResultSet rset = null;
        ArrayList<Stock> stockList = new ArrayList<>();
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("getAllStocks");
        
        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                Stock stock = new Stock();
                stock.setStockId(rset.getInt("STOCK_ID"));
                stock.setStockName(rset.getString("STOCK_NAME"));
                stockList.add(stock);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return stockList;
    }
    
    // 특정 주식의 현재 가격 조회
    public int getStockPrice(int characterId, int stockId, Connection conn) {
        ResultSet rset = null;
        PreparedStatement pstmt = null;
        int stockPrice = getDefaultPrice(stockId); // 기본값 사용
        
        String sql = prop.getProperty("getStockPrice");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, characterId);
            pstmt.setInt(2, stockId);
            
            rset = pstmt.executeQuery();
            if(rset.next()) {
                stockPrice = rset.getInt("PRICE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return stockPrice;
    }
    
    // 주식 가격 업데이트
    public int updateStockPrice(int characterId, int stockId, int newPrice, Connection conn) {
        int result = 0;
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("updateStockPrice");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, newPrice);
            pstmt.setInt(2, characterId);
            pstmt.setInt(3, stockId);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
    
    // 주식 구매
    public int buyStock(int characterId, int stockId, int count, int price, Connection conn) {
        int result = 0;
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("buyStock");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, count);
            pstmt.setInt(2, characterId);
            pstmt.setInt(3, stockId);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
    
    // 주식 판매
    public int sellStock(int characterId, int stockId, int count, Connection conn) {
        int result = 0;
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("sellStock");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, count);
            pstmt.setInt(2, characterId);
            pstmt.setInt(3, stockId);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
    
    // 캐릭터 주식 초기화 (캐릭터 생성 시 호출)
    public int initializeCharacterStocks(int characterId, Connection conn) {
        int result = 0;
        PreparedStatement pstmt = null;
        
        String sql = prop.getProperty("initializeCharacterStocks");
        
        try {
            // 모든 주식에 대해 초기 데이터 생성
            for(int stockId = 1; stockId <= 5; stockId++) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, characterId);
                pstmt.setInt(2, stockId);
                pstmt.setInt(3, getDefaultPrice(stockId));
                result += pstmt.executeUpdate();
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
    
    // 총 주식 가치 계산
    public int getTotalStockValue(int characterId, Connection conn) {
        ResultSet rset = null;
        PreparedStatement pstmt = null;
        int totalValue = 0;
        
        String sql = prop.getProperty("getTotalStockValue");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, characterId);
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                totalValue = rset.getInt("TOTAL_VALUE");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return totalValue;
    }
    
    // 주식별 기본 가격 반환
    private int getDefaultPrice(int stockId) {
        switch(stockId) {
            case 1: return 9000;   // 삼선전자
            case 2: return 27000;  // KH로우닉스
            case 3: return 1300;   // 롯뚜기식품
            case 4: return 800;    // KIG넥스트
            case 5: return 400;    // 차이슬라
            default: return 500;
        }
    }
}