package com.project.lifegame.controller;

import static com.project.lifegame.view.DisplayMsg.displayAchievement;
import static com.project.lifegame.view.DisplayMsg.displayNoData;

import java.util.List;

import static com.project.lifegame.common.AchievementChecker.*;

import com.project.lifegame.common.AchievementChecker;
import com.project.lifegame.model.vo.Achievement;
import com.project.lifegame.model.vo.LifeCharacter;
import com.project.lifegame.service.AchievementService;

public class AchievementController {
    private AchievementService as = new AchievementService();
    
    public AchievementController() {
        super();
    }
    
    public void showAchievedList(String accessId) {
        List<Achievement> achieveList = as.showAchievedList(accessId);
        if(achieveList.isEmpty()) {
            displayNoData("업적이 존재하지 않습니다.");
        } else {
            displayAchievement(achieveList, "업적 리스트");
        }
    }
    
    public void initUserAchievements(String userId) {
        int result = as.initUserAchievements(userId);
        if(result > 0) {
            System.out.println();
        } else {
            System.out.println("업적 초기화 실패");
        }
    }
    
    public void checkAchievements(LifeCharacter life, String endReason) {
        List<Integer> newAchievements = checkAllAchievements(life, endReason);
        
        int actualNewAchievements = 0;
        for(Integer achievementId : newAchievements) {
            if (!as.isAlreadyAchieved(life.getUserId(), achievementId)) {
                as.updateAchievement(life.getUserId(), achievementId);
                actualNewAchievements++;
            }
        }
        
        if(actualNewAchievements > 0) {
            System.out.println("✨✨✨✨  달성된 업적이 있습니다!");
        }
    }
}