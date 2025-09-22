package com.project.lifegame.view;

import static com.project.lifegame.common.UiTemplate.formatMoney;
import static com.project.lifegame.common.UiTemplate.line;
import static com.project.lifegame.common.UiTemplate.menuHeader;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.project.lifegame.controller.StockController;
import com.project.lifegame.model.vo.LifeCharacter;
import com.project.lifegame.model.vo.Stock;

public class StockMenu {
    private Scanner sc;
    private LifeCharacter life;
    private StockController stc;

    public StockMenu(Scanner sc, StockController stc, LifeCharacter life) {
        this.sc = sc;
        this.life = life;
        this.stc = stc;
    }

    public void showMenu() {
        while(true) {
            String menuName = "주식 투자";
            menuHeader(menuName, life);

            displayStockList();
            
            System.out.println("1. 주식 구매");
            System.out.println("2. 주식 판매");
            System.out.println("0. ← 돌아가기");
            line();
            
            boolean valid = false;
            int sel = -1;
            while (!valid) {
                System.out.print("메뉴 선택: ");
                try {
                    sel = sc.nextInt();
                    valid = true; 
                } catch (InputMismatchException e) {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    sc.nextLine(); 
                }
            }
            sc.nextLine();
            
            switch(sel) {
                case 1: 
                    buyStockMenu();
                    break;
                case 2: 
                    sellStockMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
            
            if(sel != 0) {
                System.out.println("Enter 키를 눌러 계속하세요...");
                sc.nextLine();
            }
        }
    }
    
    private void displayStockList() {
        System.out.println("=== 주식 시장 현황 ===");
        
        // 실제 보유 주식 정보 표시
        ArrayList<Stock> myStocks = stc.getCharacterStocks(life.getcharacterId());
        
        for(Stock stock : myStocks) {
            System.out.printf("%d. %-10s - 현재가: %s | 보유: %d주 (가치: %s)\n", 
                stock.getStockId(), 
                stock.getStockName(), 
                formatMoney(stock.getPrice()),
                stock.getStockCount(),
                formatMoney(stock.getPrice() * stock.getStockCount()));
        }
        
        int totalStockValue = stc.getTotalStockValue(life.getcharacterId());
        System.out.println("보유 주식 총 가치: " + formatMoney(totalStockValue));
        line();
    }
    
    private void buyStockMenu() {
        System.out.println("\n=== 주식 구매 ===");
        ArrayList<Stock> stocks = stc.getAllStocks(life.getcharacterId());
        
        System.out.println("구매할 주식을 선택하세요:");
        for(Stock stock : stocks) {
            int currentPrice = stc.getCurrentStockPrice(life.getcharacterId(), stock.getStockId());
            System.out.printf("%d. %-10s - %s\n", 
                stock.getStockId(), stock.getStockName(), formatMoney(currentPrice));
        }
        
        boolean valid = false;
        int stockId = -1;
        while (!valid) {
            System.out.print("주식 선택 (1-5): ");
            try {
                stockId = sc.nextInt();
                if(stockId >= 1 && stockId <= 5) {
                    valid = true;
                } else {
                    System.out.println("1-5 사이의 숫자를 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                sc.nextLine(); 
            }
        }
        sc.nextLine();
        
        int currentPrice = stc.getCurrentStockPrice(life.getcharacterId(), stockId);
        String stockName = getStockName(stockId);
        
        System.out.printf("\n선택한 주식: %s\n", stockName);
        System.out.printf("현재 가격: %s\n", formatMoney(currentPrice));
        System.out.printf("보유 자금: %s\n", formatMoney(life.getMoney()));
        System.out.printf("최대 구매 가능: %d주\n", life.getMoney() / currentPrice);
        
        valid = false;
        int quantity = -1;
        while (!valid) {
            System.out.print("구매할 주식 수: ");
            try {
                quantity = sc.nextInt();
                if(quantity <= 0) {
                    System.out.println("1주 이상 입력해주세요.");
                    continue;
                }
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                sc.nextLine(); 
            }
        }
        sc.nextLine();
        
        int totalCost = quantity * currentPrice;
        if(!life.canAfford(totalCost)) {
            System.out.printf("자금이 부족합니다. (필요: %s, 보유: %s)\n", 
                formatMoney(totalCost), formatMoney(life.getMoney()));
            return;
        }
        
        // 구매 실행
        life.spendMoney(totalCost);
        stc.buyStock(life.getcharacterId(), stockId, quantity, currentPrice);
        
        System.out.printf("%s %d주를 %s에 구매했습니다!\n", 
            stockName, quantity, formatMoney(totalCost));
        System.out.printf("남은 자금: %s\n", formatMoney(life.getMoney()));
    }
    
    private void sellStockMenu() {
        System.out.println("\n=== 주식 판매 ===");
        
        // 보유 주식 표시
        ArrayList<Stock> myStocks = stc.getCharacterStocks(life.getcharacterId());
        boolean hasStocks = false;
        
        System.out.println("보유 주식:");
        for(Stock stock : myStocks) {
            if(stock.getStockCount() > 0) {
                hasStocks = true;
                System.out.printf("%d. %-10s - 현재가: %s | 보유: %d주\n", 
                    stock.getStockId(), 
                    stock.getStockName(), 
                    formatMoney(stock.getPrice()),
                    stock.getStockCount());
            }
        }
        
        if(!hasStocks) {
            System.out.println("보유한 주식이 없습니다.");
            return;
        }
        
        boolean valid = false;
        int stockId = -1;
        while (!valid) {
            System.out.print("판매할 주식 선택 (1-5): ");
            try {
                stockId = sc.nextInt();
                if(stockId >= 1 && stockId <= 5) {
                    valid = true;
                } else {
                    System.out.println("1-5 사이의 숫자를 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                sc.nextLine(); 
            }
        }
        sc.nextLine();
        
        // 해당 주식 보유량 확인
        int ownedCount = 0;
        int currentPrice = 0;
        for(Stock stock : myStocks) {
            if(stock.getStockId() == stockId) {
                ownedCount = stock.getStockCount();
                currentPrice = stock.getPrice();
                break;
            }
        }
        
        if(ownedCount <= 0) {
            System.out.println("해당 주식을 보유하고 있지 않습니다.");
            return;
        }
        
        String stockName = getStockName(stockId);
        System.out.printf("\n선택한 주식: %s\n", stockName);
        System.out.printf("현재 가격: %s\n", formatMoney(currentPrice));
        System.out.printf("보유 수량: %d주\n", ownedCount);
        
        valid = false;
        int quantity = -1;
        while (!valid) {
            System.out.print("판매할 주식 수: ");
            try {
                quantity = sc.nextInt();
                if(quantity <= 0) {
                    System.out.println("1주 이상 입력해주세요.");
                    continue;
                } else if(quantity > ownedCount) {
                    System.out.printf("보유 수량(%d주)을 초과할 수 없습니다.\n", ownedCount);
                    continue;
                }
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                sc.nextLine(); 
            }
        }
        sc.nextLine();
        
        // 판매 실행
        int totalEarning = quantity * currentPrice;
        life.earnMoney(totalEarning);
        stc.sellStock(life.getcharacterId(), stockId, quantity);
        
        System.out.printf("%s %d주를 %s에 판매했습니다!\n", 
            stockName, quantity, formatMoney(totalEarning));
        System.out.printf("현재 자금: %s\n", formatMoney(life.getMoney()));
    }
    
    private String getStockName(int stockId) {
        switch(stockId) {
            case 1: return "삼선전자";
            case 2: return "KH로우닉스";
            case 3: return "롯뚜기식품";
            case 4: return "KIG넥스트";
            case 5: return "차이슬라";
            default: return "알 수 없음";
        }
    }
}