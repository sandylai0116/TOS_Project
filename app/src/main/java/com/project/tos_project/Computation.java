package com.project.tos_project;

import com.project.tos_project.model.Battle;
import com.project.tos_project.model.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAI on 2015/6/9.
 */
public class Computation {
    public static void finalAttack(Battle battle, Card card[]){
        //calculate leader skill
        LeaderSkill.processLeaderSkill(card);

        //other calculation
        for(int i=0;i<6;i++) {
            List<Integer> numOfStones;
            int numOfEnchantedStone = 0;
            String suppressedColor = "";
            if(card[i].getColor() == null) continue;
            switch (card[i].getColor()) {
                case "red":
                    numOfStones = battle.getNumOfRed();
                    numOfEnchantedStone = battle.getNumOfEnchantedRed();
                    suppressedColor = "green";
                    break;
                case "blue":
                    numOfStones = battle.getNumOfBlue();
                    numOfEnchantedStone = battle.getNumOfEnchantedBlue();
                    suppressedColor = "red";
                    break;
                case "green":
                    numOfStones = battle.getNumOfGreen();
                    numOfEnchantedStone = battle.getNumOfEnchantedGreen();
                    suppressedColor = "blue";
                    break;
                case "yellow":
                    numOfStones = battle.getNumOfYellow();
                    numOfEnchantedStone = battle.getNumOfEnchantedYellow();
                    suppressedColor = "purple";
                    break;
                case "purple":
                    numOfStones = battle.getNumOfPurple();
                    numOfEnchantedStone = battle.getNumOfEnchantedPurple();
                    suppressedColor = "yellow";
                    break;
                default:
                    numOfStones = new ArrayList<>();
                    break;
            }
            int totalStone = 0;
            for (Integer s : numOfStones) {
                totalStone += s;
            }
            //get the base attack
            double output = card[i].getCalculatedAttack();

            //calculate the same color of stones
            output *= (numOfStones.size() + totalStone + 0.6 * numOfEnchantedStone) * 0.25;

            //calculate combo bonus
            output *= 1 + (battle.getNumOfCombo() - 1) * battle.getEachComboFactor();

            //calculate color suppression
            if (battle.getBossColor()!= null && battle.getBossColor().equals(suppressedColor))
                output *= battle.getColorSuppressionFactor();

            //save
            card[i].setCalculatedAttack((int) output);
        }
    }
    
    public static void testFinalAttack(DBHelper db){
        Battle battle = new Battle();
        List<Integer> numOfStones = new ArrayList<>();
        numOfStones.add(3); //set dissolve stone
        battle.setNumOfBlue(numOfStones);
        numOfStones.clear();
        numOfStones.add(3); //set dissolve stone
        battle.setNumOfRed(numOfStones);
        numOfStones.clear();
        numOfStones.add(4); //set dissolve stone
        battle.setNumOfGreen(numOfStones);
        numOfStones.clear();
        battle.setNumOfYellow(numOfStones);
        numOfStones.clear();
        numOfStones.add(4); //set dissolve stone
        battle.setNumOfPurple(numOfStones);
        battle.setNumOfEnchantedBlue(0); //set enchanted stone
        battle.setNumOfEnchantedRed(0); //set enchanted stone
        battle.setNumOfEnchantedGreen(0); //set enchanted stone
        battle.setNumOfEnchantedYellow(0); //set enchanted stone
        battle.setNumOfEnchantedPurple(0); //set enchanted stone
        battle.setNumOfCombo(5);

        Card card[] = new Card[6];
        card[0] = db.getCard(515);  //set card ID
        card[0].setCurrentLevel(99); //set card level
        card[1] = db.getCard(190);  //set card ID
        card[1].setCurrentLevel(99); //set card level
        card[2] = db.getCard(289);  //set card ID
        card[2].setCurrentLevel(99); //set card level
        card[3] = db.getCard(349);  //set card ID
        card[3].setCurrentLevel(99); //set card level
        card[4] = db.getCard(412);  //set card ID
        card[4].setCurrentLevel(99); //set card level
        card[5] = db.getCard(515);  //set card ID
        card[5].setCurrentLevel(99); //set card level

        //calculate attack
        finalAttack(battle,card);

        //calculate final attack
        int finalAttack = 0;
        for(int i=0;i<6;i++) {
            finalAttack += card[i].getCalculatedAttack();
        }

        //get card
        System.out.println(card[0].getCalculatedAttack() + "," + card[1].getCalculatedAttack() + "," + card[2].getCalculatedAttack() + ","
                + card[3].getCalculatedAttack() + "," + card[4].getCalculatedAttack() + "," + card[5].getCalculatedAttack());
        System.out.println(finalAttack);
        
    }
}
