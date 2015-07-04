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
        //calculate passive skill
        PassiveSkill.processPassiveSkill(battle,card);

        //calculate leader skill
        LeaderSkill.processLeaderSkill(battle, card);

        //other calculation
        for(int i=0;i<6;i++) {
            List<Integer> stoneList;
            List<Integer> extraStoneList;
            List<Double> extraStonesFactorList;
            int numOfEnchantedStone = 0;

            double colorSuppressionFactor = battle.getSpecialSuppressionFactor();

            switch (card[i].getColor()) {
                case "red":
                    stoneList = battle.getNumOfRed();
                    numOfEnchantedStone = battle.getNumOfEnchantedRed();
                    //Possession
                    extraStoneList = battle.getRedForPossession();
                    extraStonesFactorList = battle.getRedForPossessFactor();
                    //Suppression
                    if(battle.getBossColor().equals("red")) colorSuppressionFactor = battle.getRedSuppressRedFactor();
                    else if(battle.getBossColor().equals("green")) colorSuppressionFactor = battle.getRedSuppressGreenFactor();
                    break;
                case "blue":
                    stoneList = battle.getNumOfBlue();
                    numOfEnchantedStone = battle.getNumOfEnchantedBlue();
                    //Possession
                    extraStoneList = battle.getBlueForPossession();
                    extraStonesFactorList = battle.getBlueForPossessFactor();
                    //Suppression
                    if(battle.getBossColor().equals("purple")) colorSuppressionFactor = battle.getBlueSuppressPurpleFactor();
                    else if(battle.getBossColor().equals("red")) colorSuppressionFactor = battle.getBlueSuppressRedFactor();
                    break;
                case "green":
                    stoneList = battle.getNumOfGreen();
                    numOfEnchantedStone = battle.getNumOfEnchantedGreen();
                    //Possession
                    extraStoneList = battle.getGreenForPossession();
                    extraStonesFactorList = battle.getGreenForPossessFactor();
                    //Suppression
                    if(battle.getBossColor().equals("yellow")) colorSuppressionFactor = battle.getGreenSuppressYellowFactor();
                    else if(battle.getBossColor().equals("blue")) colorSuppressionFactor = battle.getGreenSuppressBlueFactor();
                    break;
                case "yellow":
                    stoneList = battle.getNumOfYellow();
                    numOfEnchantedStone = battle.getNumOfEnchantedYellow();
                    //Possession
                    extraStoneList = battle.getYellowForPossession();
                    extraStonesFactorList = battle.getYellowForPossessFactor();
                    //Suppression
                    if(battle.getBossColor().equals("red")) colorSuppressionFactor = battle.getYellowSuppressRedFactor();
                    else if(battle.getBossColor().equals("purple")) colorSuppressionFactor = battle.getYellowSuppressPurpleFactor();
                    break;
                case "purple":
                    stoneList = battle.getNumOfPurple();
                    numOfEnchantedStone = battle.getNumOfEnchantedPurple();
                    //Possession
                    extraStoneList = battle.getPurpleForPossession();
                    extraStonesFactorList = battle.getPurpleForPossessFactor();
                    //Suppression
                    if(battle.getBossColor().equals("green")) colorSuppressionFactor = battle.getPurpleSuppressGreenFactor();
                    else if(battle.getBossColor().equals("yellow")) colorSuppressionFactor = battle.getPurpleSuppressYellowFactor();
                    break;
                default:
                    stoneList = new ArrayList<>();
                    extraStoneList = new ArrayList<>();
                    extraStonesFactorList = new ArrayList<>();
                    break;
            }
            int totalStone = 0;
            for (Integer s : stoneList) {
                totalStone += s;
            }
            
            //for possession
            double possessionFactor = 0.0;
            for (int j=0;j<extraStoneList.size();j++) {
                //(同屬消除次數＋符石總數)*extraStonesFactor
                possessionFactor += (1+extraStoneList.get(j))*extraStonesFactorList.get(j);
            }


            //傷害 = {基數〔(同屬消除次數＋符石總數+possessionFactor＋ 0.6強化）ｘ25％　ｘ（１＋Ｃombo加成）〕ｘ 主動／隊長技能｝
            //get the base attack
            double output = card[i].getCalculatedAttack();

            //calculate the same color of stones
            output *= (stoneList.size() + totalStone + possessionFactor + 0.6 * numOfEnchantedStone) * 0.25;

            //calculate combo bonus
            output *= 1 + (battle.getNumOfCombo() - 1) * battle.getEachComboFactor();

            //calculate color suppression
            if(battle.isEnableSuppression())output *= colorSuppressionFactor;

            //minus boss defence
            if(output>battle.getBossDefence() ) output-=battle.getBossDefence();
            else if(output > 1) output = 1.0;

            //save
            card[i].setCalculatedAttack(output);
        }

        //get card
        // the line should be deleted after some works are done
        System.out.println(card[0].getCalculatedAttack() + "," + card[1].getCalculatedAttack() + "," + card[2].getCalculatedAttack() + ","
                + card[3].getCalculatedAttack() + "," + card[4].getCalculatedAttack() + "," + card[5].getCalculatedAttack());
    }

    public static void testPreSetBattle(Battle battle){
        //test only
        List<Integer> stoneList = new ArrayList<>();
        stoneList.add(3); //set dissolve stone
        battle.setNumOfBlue(stoneList);
        stoneList.clear();
        stoneList.add(3); //set dissolve stone
        battle.setNumOfRed(stoneList);
        stoneList.clear();
        stoneList.add(3); //set dissolve stone
        battle.setNumOfGreen(stoneList);
        stoneList.clear();
        stoneList.add(3); //set dissolve stone
        battle.setNumOfYellow(stoneList);
        stoneList.clear();
        stoneList.add(3); //set dissolve stone
        battle.setNumOfPurple(stoneList);
        battle.setNumOfEnchantedBlue(0); //set enchanted stone
        battle.setNumOfEnchantedRed(0); //set enchanted stone
        battle.setNumOfEnchantedGreen(0); //set enchanted stone
        battle.setNumOfEnchantedYellow(0); //set enchanted stone
        battle.setNumOfEnchantedPurple(0); //set enchanted stone
        battle.setNumOfCombo(5);
    }
    
    public static void testFinalAttack(DBHelper db){
        Battle battle = new Battle();
        List<Integer> stoneList = new ArrayList<>();
        stoneList.add(4); //set dissolve stone
        battle.setNumOfBlue(stoneList);
        stoneList.clear();
        battle.setNumOfRed(stoneList);
        stoneList.clear();
        stoneList.add(3); //set dissolve stone
        battle.setNumOfGreen(stoneList);
        stoneList.clear();
        stoneList.add(4); //set dissolve stone
        battle.setNumOfYellow(stoneList);
        stoneList.clear();
        stoneList.add(3); //set dissolve stone
        battle.setNumOfPurple(stoneList);
        battle.setNumOfEnchantedBlue(1); //set enchanted stone
        battle.setNumOfEnchantedRed(0); //set enchanted stone
        battle.setNumOfEnchantedGreen(0); //set enchanted stone
        battle.setNumOfEnchantedYellow(0); //set enchanted stone
        battle.setNumOfEnchantedPurple(0); //set enchanted stone
        battle.setNumOfCombo(6);

        Card card[] = new Card[6];
        card[0] = db.getCard(595);  //set card ID
        card[0].setCurrentLevel(99); //set card level
        card[1] = db.getCard(0);  //set card ID
        card[1].setCurrentLevel(99); //set card level
        card[2] = db.getCard(0);  //set card ID
        card[2].setCurrentLevel(99); //set card level
        card[3] = db.getCard(0);  //set card ID
        card[3].setCurrentLevel(99); //set card level
        card[4] = db.getCard(0);  //set card ID
        card[4].setCurrentLevel(99); //set card level
        card[5] = db.getCard(595);  //set card ID
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

    public static int calculateCurrentLevelAbility(String race, int maxLevel, int currentLevel,int lv1Ability, int lvMaxAbility){
        if(race == null || maxLevel <= 1)return -1;
        if(currentLevel == maxLevel) return lvMaxAbility;
        if(currentLevel == 1) return lv1Ability;
        //compute
        double raceFactor=0.0;
        switch(race){
            case "human":
                raceFactor = 1;
                break;
            case "dragon":
                raceFactor = 1;
                break;
            case "demon":
                raceFactor = 1;
                break;
            case "god":
                raceFactor = 3/2.0;
                break;
            case "elf":
                raceFactor = 3/2.0;
                break;
            case "beast":
                raceFactor = 2/3.0;
                break;
        }
        int lv0Ability = (int)((lv1Ability - lvMaxAbility / Math.pow(maxLevel,raceFactor))/(1-1/ Math.pow(maxLevel,raceFactor))+1);

        return (int)(lv0Ability +(lvMaxAbility - lv0Ability)*Math.pow((double)currentLevel/maxLevel,raceFactor));
    }
}
