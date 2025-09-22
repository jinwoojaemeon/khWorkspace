package com.project.lifegame.model.vo;

public class Stock {
    private int stockId;
    private String stockName;
    private int price;
    private int stockCount;
    
    public Stock() {
        super();
    }

    public Stock(int stockId, String stockName, int price, int stockCount) {
        super();
        this.stockId = stockId;
        this.stockName = stockName;
        this.price = price;
        this.stockCount = stockCount;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    @Override
    public String toString() {
        return String.format("%s - 가격: %,d만원 (보유: %d주)", 
                           stockName, price, stockCount);
    }
}