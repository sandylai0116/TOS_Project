package com.project.tos_project;

import com.project.tos_project.model.Battle;
import com.project.tos_project.model.Card;

/**
 * Created by LAI on 2015/6/18.
 */
public class PassiveSkill {
    public static void processPassiveSkill(Battle battle,Card[] card) {
        //leader
        for (int i=0;i<6;i=i+5) {
            switch(card[i].getId()){
                case 595: //妲己
                    if(battle.isEnableCombo25() == false) {
                        battle.setEachComboFactor(battle.getEachComboFactor()+0.25);
                        battle.setEnableCombo25(true);
                    }
                    break;

            }
        }
    }
}
