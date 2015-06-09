package com.project.tos_project;

import com.project.tos_project.model.Battle;
import com.project.tos_project.model.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAI on 2015/6/9.
 */
public class Computation {
    public static void finalAttack(Battle battle, Card card){
        double output = card.getCalculatedAttack();

        //calculate the same color of stones
        List<Integer> numOfStones;
        int numOfEnchantedStone=0;
        String suppressedColor ="";
        switch(card.getColor()){
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
        int totalStone=0;
        for(Integer s:numOfStones){
            totalStone+=s;
        }
        output *= (numOfStones.size() + totalStone + 0.6*numOfEnchantedStone)*0.25;

        //calculate combo bonus
        output *= 1+(battle.getNumOfCombo()-1)*battle.getEachComboFactor();

        //calculate color suppression
        if(battle.getBossColor().equals(suppressedColor))
            output *= battle.getColorSuppressionFactor();

        //save
        card.setCalculatedAttack((int) output);
    }
    
    public static void testFinalAttack(DBHelper db){
        Battle battle = new Battle();
        List<Integer> numOfStones = new ArrayList<>();
        numOfStones.add(3); //set stone(blue)
        battle.setNumOfBlue(numOfStones);
        battle.setNumOfEnchantedBlue(1); //set enchanted stone(blue)
        battle.setNumOfCombo(numOfStones.size());

        Card card[] = new Card[6];
        for(int i=0;i<6;i++) {
            card[i] = db.getCard(1);  //set card ID
            card[i].setCurrentLevel(5); //set card level
        }
        //calculate leader skill
        LeaderSkill.processLeaderSkill(card);

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
