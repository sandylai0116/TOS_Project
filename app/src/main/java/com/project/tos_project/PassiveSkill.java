package com.project.tos_project;

import com.project.tos_project.model.Battle;
import com.project.tos_project.model.Card;

/**
 * Created by LAI on 2015/6/18.
 */
public class PassiveSkill {
    public static void processPassiveSkill(Battle battle,Card[] card) {
        //leader

        //妲己
        if(card[0].getId() == 595 && card[5].getId() == 595) battle.setEachComboFactor(battle.getEachComboFactor()+0.25);

        for (int i=0;i<6;i=i+5) {
            switch(card[i].getId()){
                }
        }
    }
}
