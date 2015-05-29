package com.project.tos_project;

import com.project.tos_project.model.Card;

/**
 * Created by LAI on 2015/5/29.
 */
public class LeaderSkill {

    public static void processLeaderSkill(Card[] card){
        for(int i=0;i<6;i=i+5) {
            switch(card[i].getLeaderSkill()) {
                case "b1.5":
                    colorAttackBonus(card, "blue", 1.5);
                    break;
                case "b2":
                    colorAttackBonus(card, "blue", 2.0);
                    break;
                case "b2.5":
                    colorAttackBonus(card, "blue", 2.5);
                    break;
                case "b3":
                    colorAttackBonus(card, "blue", 3.0);
                    break;
                case "r1.5":
                    colorAttackBonus(card, "red", 1.5);
                    break;
                case "r2":
                    colorAttackBonus(card, "red", 2.0);
                    break;
                case "r2.5":
                    colorAttackBonus(card, "red", 2.5);
                    break;
                case "r3":
                    colorAttackBonus(card, "red", 3.0);
                    break;
                case "g1.5":
                    colorAttackBonus(card, "green", 1.5);
                    break;
                case "g2":
                    colorAttackBonus(card, "green", 2.0);
                    break;
                case "g2.5":
                    colorAttackBonus(card, "green", 2.5);
                    break;
                case "g3":
                    colorAttackBonus(card, "green", 3.0);
                    break;
                case "y1.5":
                    colorAttackBonus(card, "yellow", 1.5);
                    break;
                case "y2":
                    colorAttackBonus(card, "yellow", 2.0);
                    break;
                case "y2.5":
                    colorAttackBonus(card, "yellow", 2.5);
                    break;
                case "y3":
                    colorAttackBonus(card, "yellow", 3.0);
                    break;
                case "p1.5":
                    colorAttackBonus(card, "purple", 1.5);
                    break;
                case "p2":
                    colorAttackBonus(card, "purple", 2.0);
                    break;
                case "p2.5":
                    colorAttackBonus(card, "purple", 2.5);
                    break;
                case "p3":
                    colorAttackBonus(card, "purple", 3.0);
                    break;
            }
        }
    }

    public static void colorAttackBonus(Card[] card,String color,Double factor){
        for(int i=0;i<6;i++) {
            if (card[i].getColor().equals(color)) {
                int temp = (int) (card[i].getCalculatedAttack() * factor);
                card[i].setCalculatedAttack(temp);
            }
        }
    }
}
