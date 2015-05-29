package com.project.tos_project;

import com.project.tos_project.model.Card;

/**
 * Created by LAI on 2015/5/29.
 */
public class LeaderSkill {
    public static void colorAttackBonus(Card[] card,String color,Double factor){
        for(int i=0;i<6;i++) {
            if (card[i].getColor().equals(color)) {
                int temp = (int) (card[i].getCalculatedAttack() * factor);
                card[i].setCalculatedAttack(temp);
            }
        }
    }
}
