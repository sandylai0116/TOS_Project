package com.project.tos_project;

import com.project.tos_project.model.Battle;
import com.project.tos_project.model.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by LAI on 2015/5/29.
 */
public class LeaderSkill {

    public static void processLeaderSkill(Battle battle,Card[] card){
        //priority1
        for(int i=0;i<6;i=i+5){
            if(card[i].getLeaderSkill() == null) continue;
            String leaderSkills[] = card[i].getLeaderSkill().split(",");
            for(String s : leaderSkills) {
                switch(s) {
                    case "dragonRecovery120Point":
                        raceRecoveryPoint(card,"dragon",120);
                        break;
                    case "dragonRecovery150Point":
                        raceRecoveryPoint(card,"dragon",150);
                        break;
                    case "dragonRecovery200Point":
                        raceRecoveryPoint(card,"dragon",200);
                        break;
                    case "dragonAttack200Point":
                        raceAttackPoint(card, "dragon", 200);
                        break;
                }
            }
        }

        //priority2
        for(int i=0;i<6;i=i+5){
            if(card[i].getLeaderSkill() == null) continue;
            String leaderSkills[] = card[i].getLeaderSkill().split(",");
            for(String s : leaderSkills) {
                switch(s) {
                    case "blueHP1.5":
                        colorHPBonus(card, "blue", 1.5);
                        break;
                    case "blueHP2":
                        colorHPBonus(card, "blue", 2.0);
                        break;
                    case "blueHP2.5":
                        colorHPBonus(card, "blue", 2.5);
                        break;
                    case "blueHP3":
                        colorHPBonus(card, "blue", 3.0);
                        break;
                    case "blueRecovery1.5":
                        colorRecoveryBonus(card, "blue", 1.5);
                        break;
                    case "blueRecovery2":
                        colorRecoveryBonus(card, "blue", 2.0);
                        break;
                    case "blueRecovery2.5":
                        colorRecoveryBonus(card, "blue", 2.5);
                        break;
                    case "blueRecovery3":
                        colorRecoveryBonus(card, "blue", 3.0);
                        break;
                    case "redHP1.5":
                        colorHPBonus(card, "red", 1.5);
                        break;
                    case "redHP2":
                        colorHPBonus(card, "red", 2.0);
                        break;
                    case "redHP2.5":
                        colorHPBonus(card, "red", 2.5);
                        break;
                    case "redHP3":
                        colorHPBonus(card, "red", 3.0);
                        break;
                    case "redRecovery1.5":
                        colorRecoveryBonus(card, "red", 1.5);
                        break;
                    case "redRecovery2":
                        colorRecoveryBonus(card, "red", 2.0);
                        break;
                    case "redRecovery2.5":
                        colorRecoveryBonus(card, "red", 2.5);
                        break;
                    case "redRecovery3":
                        colorRecoveryBonus(card, "red", 3.0);
                        break;
                    case "greenHP1.5":
                        colorHPBonus(card, "green", 1.5);
                        break;
                    case "greenHP2":
                        colorHPBonus(card, "green", 2.0);
                        break;
                    case "greenHP2.5":
                        colorHPBonus(card, "green", 2.5);
                        break;
                    case "greenHP3":
                        colorHPBonus(card, "green", 3.0);
                        break;
                    case "greenRecovery1.5":
                        colorRecoveryBonus(card, "green", 1.5);
                        break;
                    case "greenRecovery2":
                        colorRecoveryBonus(card, "green", 2.0);
                        break;
                    case "greenRecovery2.5":
                        colorRecoveryBonus(card, "green", 2.5);
                        break;
                    case "greenRecovery3":
                        colorRecoveryBonus(card, "green", 3.0);
                        break;
                    case "yellowHP1.5":
                        colorHPBonus(card, "yellow", 1.5);
                        break;
                    case "yellowHP2":
                        colorHPBonus(card, "yellow", 2.0);
                        break;
                    case "yellowHP2.5":
                        colorHPBonus(card, "yellow", 2.5);
                        break;
                    case "yellowHP3":
                        colorHPBonus(card, "yellow", 3.0);
                        break;
                    case "yellowRecovery1.5":
                        colorRecoveryBonus(card, "yellow", 1.5);
                        break;
                    case "yellowRecovery2":
                        colorRecoveryBonus(card, "yellow", 2.0);
                        break;
                    case "yellowRecovery2.5":
                        colorRecoveryBonus(card, "yellow", 2.5);
                        break;
                    case "yellowRecovery3":
                        colorRecoveryBonus(card, "yellow", 3.0);
                        break;
                    case "purpleHP1.5":
                        colorHPBonus(card, "purple", 1.5);
                        break;
                    case "purpleHP2":
                        colorHPBonus(card, "purple", 2.0);
                        break;
                    case "purpleHP2.5":
                        colorHPBonus(card, "purple", 2.5);
                        break;
                    case "purpleHP3":
                        colorHPBonus(card, "purple", 3.0);
                        break;
                    case "purpleRecovery1.5":
                        colorRecoveryBonus(card, "purple", 1.5);
                        break;
                    case "purpleRecovery2":
                        colorRecoveryBonus(card, "purple", 2.0);
                        break;
                    case "purpleRecovery2.5":
                        colorRecoveryBonus(card, "purple", 2.5);
                        break;
                    case "purpleRecovery3":
                        colorRecoveryBonus(card, "purple", 3.0);
                        break;
                    case "hp1.5":
                        hpBonus(card, 1.5);
                        break;
                    case "hp2":
                        hpBonus(card, 2.0);
                        break;
                    case "hp2.5":
                        hpBonus(card, 2.5);
                        break;
                    case "hp3":
                        hpBonus(card, 3.0);
                        break;
                    case "recovery1.5":
                        recoveryBonus(card, 1.5);
                        break;
                    case "recovery2":
                        recoveryBonus(card, 2.0);
                        break;
                    case "recovery2.5":
                        recoveryBonus(card, 2.5);
                        break;
                    case "recovery3":
                        recoveryBonus(card, 3.0);
                        break;
                    case "humanHP1.5":
                        raceHPBonus(card, "human", 1.5);
                        break;
                    case "humanHP2":
                        raceHPBonus(card, "human", 2.0);
                        break;
                    case "humanHP2.5":
                        raceHPBonus(card, "human", 2.5);
                        break;
                    case "humanHP3":
                        raceHPBonus(card, "human", 3.0);
                        break;
                    case "beastHP1.5":
                        raceHPBonus(card, "beast", 1.5);
                        break;
                    case "beastHP2":
                        raceHPBonus(card, "beast", 2.0);
                        break;
                    case "beastHP2.5":
                        raceHPBonus(card, "beast", 2.5);
                        break;
                    case "beastHP3":
                        raceHPBonus(card, "beast", 3.0);
                        break;
                    case "dragonHP1.5":
                        raceHPBonus(card, "dragon", 1.5);
                        break;
                    case "dragonHP2":
                        raceHPBonus(card, "dragon", 2.0);
                        break;
                    case "dragonHP2.5":
                        raceHPBonus(card, "dragon", 2.5);
                        break;
                    case "dragonHP3":
                        raceHPBonus(card, "dragon", 3.0);
                        break;
                    case "elfHP1.5":
                        raceHPBonus(card, "elf", 1.5);
                        break;
                    case "elfHP2":
                        raceHPBonus(card, "elf", 2.0);
                        break;
                    case "elfHP2.5":
                        raceHPBonus(card, "elf", 2.5);
                        break;
                    case "elfHP3":
                        raceHPBonus(card, "elf", 3.0);
                        break;
                    case "godHP1.5":
                        raceHPBonus(card, "god", 1.5);
                        break;
                    case "godHP2":
                        raceHPBonus(card, "god", 2.0);
                        break;
                    case "godHP2.5":
                        raceHPBonus(card, "god", 2.5);
                        break;
                    case "godHP3":
                        raceHPBonus(card, "god", 3.0);
                        break;
                    case "demonHP1.5":
                        raceHPBonus(card, "demon", 1.5);
                        break;
                    case "demonHP2":
                        raceHPBonus(card, "demon", 2.0);
                        break;
                    case "demonHP2.5":
                        raceHPBonus(card, "demon", 2.5);
                        break;
                    case "demonHP3":
                        raceHPBonus(card, "demon", 3.0);
                        break;
                    case "humanRecovery1.5":
                        raceRecoveryBonus(card, "human", 1.5);
                        break;
                    case "humanRecovery2":
                        raceRecoveryBonus(card, "human", 2.0);
                        break;
                    case "humanRecovery2.5":
                        raceRecoveryBonus(card, "human", 2.5);
                        break;
                    case "humanRecovery3":
                        raceRecoveryBonus(card, "human", 3.0);
                        break;
                    case "beastRecovery1.5":
                        raceRecoveryBonus(card, "beast", 1.5);
                        break;
                    case "beastRecovery2":
                        raceRecoveryBonus(card, "beast", 2.0);
                        break;
                    case "beastRecovery2.5":
                        raceRecoveryBonus(card, "beast", 2.5);
                        break;
                    case "beastRecovery3":
                        raceRecoveryBonus(card, "beast", 3.0);
                        break;
                    case "dragonRecovery1.5":
                        raceRecoveryBonus(card, "dragon", 1.5);
                        break;
                    case "dragonRecovery2":
                        raceRecoveryBonus(card, "dragon", 2.0);
                        break;
                    case "dragonRecovery2.5":
                        raceRecoveryBonus(card, "dragon", 2.5);
                        break;
                    case "dragonRecovery3":
                        raceRecoveryBonus(card, "dragon", 3.0);
                        break;
                    case "elfRecovery1.5":
                        raceRecoveryBonus(card, "elf", 1.5);
                        break;
                    case "elfRecovery2":
                        raceRecoveryBonus(card, "elf", 2.0);
                        break;
                    case "elfRecovery2.5":
                        raceRecoveryBonus(card, "elf", 2.5);
                        break;
                    case "elfRecovery3":
                        raceRecoveryBonus(card, "elf", 3.0);
                        break;
                    case "godRecovery1.5":
                        raceRecoveryBonus(card, "god", 1.5);
                        break;
                    case "godRecovery2":
                        raceRecoveryBonus(card, "god", 2.0);
                        break;
                    case "godRecovery2.5":
                        raceRecoveryBonus(card, "god", 2.5);
                        break;
                    case "godRecovery3":
                        raceRecoveryBonus(card, "god", 3.0);
                        break;
                    case "demonRecovery1.5":
                        raceRecoveryBonus(card, "demon", 1.5);
                        break;
                    case "demonRecovery2":
                        raceRecoveryBonus(card, "demon", 2.0);
                        break;
                    case "demonRecovery2.5":
                        raceRecoveryBonus(card, "demon", 2.5);
                        break;
                    case "demonRecovery3":
                        raceRecoveryBonus(card, "demon", 3.0);
                        break;
                }
            }
        }

        //priority3
        for(int i=0;i<6;i=i+5){
            if(card[i].getLeaderSkill() == null) continue;
            String leaderSkills[] = card[i].getLeaderSkill().split(",");
            for(String s : leaderSkills) {
                switch(s) {
                    case "dragonRecoveryAddToAttack":
                        raceAddRecoveryToAttack(card,"dragon",i);
                        break;
                }
            }
        }

        //priority4
        for(int i=0;i<6;i=i+5) {
            if(card[i].getLeaderSkill() == null) continue;
            String leaderSkills[] = card[i].getLeaderSkill().split(",");
            for(String s : leaderSkills) {
                switch(s) {
                    case "blueAttack1.5":
                        colorAttackBonus(card, "blue", 1.5);
                        break;
                    case "blueAttack2":
                        colorAttackBonus(card, "blue", 2.0);
                        break;
                    case "blueAttack2.5":
                        colorAttackBonus(card, "blue", 2.5);
                        break;
                    case "blueAttack3":
                        colorAttackBonus(card, "blue", 3.0);
                        break;
                    case "redAttack1.5":
                        colorAttackBonus(card, "red", 1.5);
                        break;
                    case "redAttack2":
                        colorAttackBonus(card, "red", 2.0);
                        break;
                    case "redAttack2.5":
                        colorAttackBonus(card, "red", 2.5);
                        break;
                    case "redAttack3":
                        colorAttackBonus(card, "red", 3.0);
                        break;
                    case "greenAttack1.5":
                        colorAttackBonus(card, "green", 1.5);
                        break;
                    case "greenAttack2":
                        colorAttackBonus(card, "green", 2.0);
                        break;
                    case "greenAttack2.5":
                        colorAttackBonus(card, "green", 2.5);
                        break;
                    case "greenAttack3":
                        colorAttackBonus(card, "green", 3.0);
                        break;
                    case "yellowAttack1.5":
                        colorAttackBonus(card, "yellow", 1.5);
                        break;
                    case "yellowAttack2":
                        colorAttackBonus(card, "yellow", 2.0);
                        break;
                    case "yellowAttack2.5":
                        colorAttackBonus(card, "yellow", 2.5);
                        break;
                    case "yellowAttack3":
                        colorAttackBonus(card, "yellow", 3.0);
                        break;
                    case "purpleAttack1.5":
                        colorAttackBonus(card, "purple", 1.5);
                        break;
                    case "purpleAttack2":
                        colorAttackBonus(card, "purple", 2.0);
                        break;
                    case "purpleAttack2.5":
                        colorAttackBonus(card, "purple", 2.5);
                        break;
                    case "purpleAttack3":
                        colorAttackBonus(card, "purple", 3.0);
                        break;
                    case "attack1.5":
                        attackBonus(card, 1.5);
                        break;
                    case "attack2":
                        attackBonus(card, 2.0);
                        break;
                    case "attack2.5":
                        attackBonus(card, 2.5);
                        break;
                    case "attack3":
                        attackBonus(card, 3.0);
                        break;
                    case "humanAttack1.5":
                        raceAttackBonus(card, "human", 1.5);
                        break;
                    case "humanAttack2":
                        raceAttackBonus(card, "human", 2.0);
                        break;
                    case "humanAttack2.5":
                        raceAttackBonus(card, "human", 2.5);
                        break;
                    case "humanAttack3":
                        raceAttackBonus(card, "human", 3.0);
                        break;
                    case "beastAttack1.5":
                        raceAttackBonus(card, "beast", 1.5);
                        break;
                    case "beastAttack2":
                        raceAttackBonus(card, "beast", 2.0);
                        break;
                    case "beastAttack2.5":
                        raceAttackBonus(card, "beast", 2.5);
                        break;
                    case "beastAttack3":
                        raceAttackBonus(card, "beast", 3.0);
                        break;
                    case "dragonAttack1.5":
                        raceAttackBonus(card, "dragon", 1.5);
                        break;
                    case "dragonAttack2":
                        raceAttackBonus(card, "dragon", 2.0);
                        break;
                    case "dragonAttack2.5":
                        raceAttackBonus(card, "dragon", 2.5);
                        break;
                    case "dragonAttack3":
                        raceAttackBonus(card, "dragon", 3.0);
                        break;
                    case "elfAttack1.5":
                        raceAttackBonus(card, "elf", 1.5);
                        break;
                    case "elfAttack2":
                        raceAttackBonus(card, "elf", 2.0);
                        break;
                    case "elfAttack2.5":
                        raceAttackBonus(card, "elf", 2.5);
                        break;
                    case "elfAttack3":
                        raceAttackBonus(card, "elf", 3.0);
                        break;
                    case "godAttack1.5":
                        raceAttackBonus(card, "god", 1.5);
                        break;
                    case "godAttack2":
                        raceAttackBonus(card, "god", 2.0);
                        break;
                    case "godAttack2.5":
                        raceAttackBonus(card, "god", 2.5);
                        break;
                    case "godAttack3":
                        raceAttackBonus(card, "god", 3.0);
                        break;
                    case "demonAttack1.5":
                        raceAttackBonus(card, "demon", 1.5);
                        break;
                    case "demonAttack2":
                        raceAttackBonus(card, "demon", 2.0);
                        break;
                    case "demonAttack2.5":
                        raceAttackBonus(card, "demon", 2.5);
                        break;
                    case "demonAttack3":
                        raceAttackBonus(card, "demon", 3.0);
                        break;
                    case "blueAttack2BlueBeastAttack3.5":
                        colorAndRaceAttackBonus(card, "blue", "beast", 2.0, 3.5);
                        break;
                    case "redAttack2RedBeastAttack3.5":
                        colorAndRaceAttackBonus(card, "red", "beast", 2.0, 3.5);
                        break;
                    case "greenAttack2GreenBeastAttack3.5":
                        colorAndRaceAttackBonus(card, "green", "beast", 2.0, 3.5);
                        break;
                    case "yellowAttack2YellowBeastAttack3.5":
                        colorAndRaceAttackBonus(card, "yellow", "beast", 2.0, 3.5);
                        break;
                    case "purpleAttack2PurpleBeastAttack3.5":
                        colorAndRaceAttackBonus(card, "purple", "beast", 2.0, 3.5);
                        break;
                    case "increaseBlueAttackRed":
                        blueSuppressRedFactor(battle, 2.5);
                        break;
                    case "increaseRedAttackGreen":
                        redSuppressGreenFactor(battle, 2.5);
                        break;
                    case "increaseGreenAttackBlue":
                        greenSuppressBlueFactor(battle, 2.5);
                        break;
                    case "increaseYellowAttackPurple":
                        yellowSuppressPurpleFactor(battle, 2.5);
                        break;
                    case "increasePurpleAttackYellow":
                        purpleSuppressYellowFactor(battle, 2.5);
                        break;
                    case "greatlyIncreaseBlueAttackBlue":
                        blueSuppressRedFactor(battle, 3.0);
                        break;
                    case "greatlyIncreaseRedAttackRed":
                        redSuppressGreenFactor(battle, 3.0);
                        break;
                    case "greatlyIncreaseGreenAttackGreen":
                        greenSuppressBlueFactor(battle, 3.0);
                        break;
                    case "greatlyIncreaseYellowAttackYellow":
                        yellowSuppressPurpleFactor(battle, 3.0);
                        break;
                    case "greatlyIncreasePurpleAttackPurple":
                        purpleSuppressYellowFactor(battle, 3.0);
                        break;
                    case "greatlyIncreaseBlueAttackRedAndPurpleAndIncreaseOthers":
                        blueSuppressRedFactor(battle, 3.5);
                        blueSuppressPurpleFactor(battle, 3.5);
                        battle.setSpecialSuppressionFactor(1.5);
                        break;
                    case "greatlyIncreaseRedAttackRedAndGreenAndIncreaseOthers":
                        redSuppressGreenFactor(battle, 3.5);
                        redSuppressRedFactor(battle, 3.5);
                        battle.setSpecialSuppressionFactor(1.5);
                        break;
                    case "greatlyIncreaseGreenAttackBlueAndYellowAndIncreaseOthers":
                        greenSuppressBlueFactor(battle, 3.5);
                        greenSuppressYellowFactor(battle, 3.5);
                        battle.setSpecialSuppressionFactor(1.5);
                        break;
                    case "greatlyIncreaseYellowAttackRedAndPurpleAndIncreaseOthers":
                        yellowSuppressPurpleFactor(battle, 3.5);
                        yellowSuppressRedFactor(battle, 3.5);
                        battle.setSpecialSuppressionFactor(1.5);
                        break;
                    case "greatlyIncreasePurpleAttackGreenAndYellowAndIncreaseOthers":
                        purpleSuppressYellowFactor(battle, 3.5);
                        purpleSuppressGreenFactor(battle, 3.5);
                        battle.setSpecialSuppressionFactor(1.5);
                        break;
                    case "combo25%":
                        battle.setEachComboFactor(battle.getEachComboFactor()+0.25);
                        break;
                    case "combo75%":
                        battle.setEachComboFactor(battle.getEachComboFactor()+0.75);
                        break;
                    case "combo125%":
                        battle.setEachComboFactor(battle.getEachComboFactor()+1.25);
                        break;
                    case "combo125%WhenOnlyDragon":
                        for(Card c: card) if( !(c.getRace().equals("dragon") || c.getRace().equals("")) ) break;
                        battle.setEachComboFactor(battle.getEachComboFactor()+1.25);
                        break;
                    case "attack2.5WhenHPBelow20%":
                        if((double)battle.getCurrentHP()/battle.getMaxHP()<0.2) attackBonus(card,2.5);
                        break;
                    case "attack3WhenHPBelow20%":
                        if((double)battle.getCurrentHP()/battle.getMaxHP()<0.2) attackBonus(card,3.0);
                        break;
                    case "attack2.5WhenLowHP":
                        attack2p5WhenLowHP(battle, card);
                        break;
                    case "attack3WhenLowHP":
                        attack3WhenLowHP(battle, card);
                        break;
                    case "attack3.5WhenLowHP":
                        attack3p5WhenLowHP(battle, card);
                        break;
                    case "attack3WhenBelow10Round":
                        break;
                    case "highAttackWhenMoreAttribute":
                        highAttackWhenMoreAttribute(card, null);
                        break;
                    case "highAttackWhenMoreBeastAttribute":
                        highAttackWhenMoreAttribute(card,"beast");
                        break;
                    case "attack2.5WhenOnlyGod":
                        for(Card c: card) if( !(c.getRace().equals("god") || c.getRace().equals("")) ) break;
                        attackBonus(card,2.5);
                        break;
                    case "attack3WhenOnlyDemonDragon":
                        attackBonusWhenOnly2Race(card,"demon","dragon",3.0);
                        break;
                    case "attack2.5WhenOnlyGodDragon":
                        attackBonusWhenOnly2Race(card,"god","dragon",2.5);
                        break;
                    case "attack3Recovery2WhenOnly2Red":
                        attackBonusRecoveryBonusWhenOnlyNumbersOfColor(card,"red",2,3.0,2.0);
                        break;
                    case "attack5WhenComboIsEven":
                        if(battle.getNumOfCombo()%2 == 0) attackBonus(card,5.0);
                        break;
                    case "humanAttack3DragonAttack1.5WhenExistHumanAnd2Dragon":
                        threeRaceAttackWhenExistRaceAndNumberOfRaceOrOtherRace(card, "human", 2, "dragon", null, 3.0, 1.5, null);
                        break;
                    case "humanAttack3beastAttack2ElfAttack2WhenExistHumanAnd2BeastOrElf":
                        threeRaceAttackWhenExistRaceAndNumberOfRaceOrOtherRace(card, "human", 2, "beast", "elf", 3.0, 2.0, 2.0);
                        break;
                    case "humanAttack3DemonAttack2ElfAttack2WhenExistHumanAnd2DemonOrElf":
                        threeRaceAttackWhenExistRaceAndNumberOfRaceOrOtherRace(card, "human",2 , "demon", "elf", 3.0, 2.0, 2.0);
                        break;
                    case "humanAttack3GodAttack1.5WhenExistHumanAnd2God":
                        threeRaceAttackWhenExistRaceAndNumberOfRaceOrOtherRace(card, "human",2 , "god", null, 3.0, 1.5, null);
                        break;
                    case "humanAttack3.5GodAttack2WhenExistHumanAnd2God":
                        threeRaceAttackWhenExistRaceAndNumberOfRaceOrOtherRace(card, "human",2 , "god", null, 3.5, 2.0, null);
                        break;
                    case "humanAttack3.5DragonAttack2WhenExistHumanAnd2Dragon":
                        threeRaceAttackWhenExistRaceAndNumberOfRaceOrOtherRace(card, "human",2 , "dragon", null, 3.5, 2.0, null);
                        break;
                    case "humanAttack3.5BeastAttack2.5ElfAttack2.5WhenExistHumanAnd2BeastOrElf":
                        threeRaceAttackWhenExistRaceAndNumberOfRaceOrOtherRace(card, "human",2 , "beast", "elf", 3.5, 2.5, 2.5);
                        break;
                    case "humanAttack3.5DemonAttack2.5ElfAttack2.5WhenExistHumanAnd2DemonOrElf":
                        threeRaceAttackWhenExistRaceAndNumberOfRaceOrOtherRace(card, "human",2 , "demon", "elf", 3.5, 2.5, 2.5);
                        break;
                    case "humanAttack3.5DragonAttack2WhenExistHumanAnd1Dragon":
                        threeRaceAttackWhenExistRaceAndNumberOfRaceOrOtherRace(card, "human",1 , "dragon", null, 3.5, 2.0, null);
                        break;
                    case "humanAttack3.5beastAttack2.5ElfAttack2.5WhenExistHumanAnd1BeastOrElf":
                        threeRaceAttackWhenExistRaceAndNumberOfRaceOrOtherRace(card, "human",1 , "beast", "elf", 3.5, 2.5, 2.5);
                        break;
                    case "humanAttack3.5DemonAttack2.5ElfAttack2.5WhenExistHumanAnd1DemonOrElf":
                        threeRaceAttackWhenExistRaceAndNumberOfRaceOrOtherRace(card, "human",1 , "demon", "elf", 3.5, 2.5, 2.5);
                        break;
                    case "attack3WhenOnlyBlueRedGreenAndDissolve3AttributeStone":
                        attack3WhenOnlyBlueRedGreenAndDissolve3AttributeStone(card);
                        break;
                    case "greenAttack3WhenOnlyGreenElfBeastDemon":
                        greenAttack3WhenOnlyGreenElfBeastDemon(card);
                        break;
                    case "yellowAttack2MaxYellowAttack3.5WhenMoreHuman":
                        yellowAttack2MaxYellowAttack3p5WhenMoreHuman(card);
                        break;
                    case "redGreenPurpleAttack3WhenExistRedGreenPurpleAndDissolve3AttributeStone":
                        redGreenPurpleAttack3WhenExistRedGreenPurpleAndDissolve3AttributeStone(card);
                        break;
                    case "attack2.5WhenFullHP":
                        if(battle.getCurrentHP() == battle.getMaxHP()) attackBonus(card,2.5);
                        break;
                    case "attack4WhenMoreTime":
                        break;
                    case "yellowPossessPurple":
                        if(!battle.isEnableYellowPossessPurple()) possessionFunction(battle,"yellow","purple",1.0);
                        battle.setEnableYellowPossessPurple(true);
                        break;
                    case "purplePossessYellow":
                        if(!battle.isEnablePurplePossessYellow()) possessionFunction(battle, "purple", "yellow", 1.0);
                        battle.setEnablePurplePossessYellow(true);
                        break;
                    case "pinkPossess50%Blue":
                        if(!battle.isEnablePinkPossessBlue()) possessionFunction(battle, "pink", "blue", 0.5);
                        battle.setEnablePinkPossessBlue(true);
                        break;
                    case "pinkPossess50%Red":
                        if(!battle.isEnablePinkPossessRed()) possessionFunction(battle, "pink", "red", 0.5);
                        battle.setEnablePinkPossessRed(true);
                        break;
                    case "pinkPossess50%Green":
                        if(!battle.isEnablePinkPossessGreen()) possessionFunction(battle, "pink", "green", 0.5);
                        battle.setEnablePinkPossessGreen(true);
                        break;
                    case "pinkPossess50%Yellow":
                        if(!battle.isEnablePinkPossessYellow()) possessionFunction(battle, "pink", "yellow", 0.5);
                        battle.setEnablePinkPossessYellow(true);
                        break;
                    case "pinkPossess50%Purple":
                        if (!battle.isEnablePinkPossessPurple()) possessionFunction(battle,"pink","purple",0.5);
                        battle.setEnablePinkPossessPurple(true);
                        break;
                    case "bluePossessAllBasedOnBeast":
                        colorPossessAllBasedOnBeast(battle, card, "blue");
                        break;
                    case "redPossessAllBasedOnBeast":
                        colorPossessAllBasedOnBeast(battle,card,"red");
                        break;
                    case "greenPossessAllBasedOnBeast":
                        colorPossessAllBasedOnBeast(battle,card,"green");
                        break;
                    case "yellowPossessAllBasedOnBeast":
                        colorPossessAllBasedOnBeast(battle,card,"yellow");
                        break;
                    case "purplePossessAllBasedOnBeast":
                        colorPossessAllBasedOnBeast(battle,card,"purple");
                        break;
                    case "singleAttack2":
                        singleAttack(battle,card,2.0);
                        break;
                    case "singleAttack2.5":
                        singleAttack(battle,card,2.5);
                        break;
                    case "blueAttack3.5WhenKeepDissolveStone":
                        break;
                    case "redAttack3.5WhenKeepDissolveStone":
                        break;
                    case "greenAttack3.5WhenKeepDissolveStone":
                        break;
                    case "blueAttack3WhenKeepDissolveStone":
                        break;
                    case "redAttack3WhenKeepDissolveStone":
                        break;
                    case "greenAttack3WhenKeepDissolveStone":
                        break;
                    case "yellowAttack2.5WhenDissolve4Yellow":
                        break;
                    case "dissolve2Red":
                        break;
                    case "dissolve2Green":
                        break;
                    case "dissolve2Pink":
                        break;
                    case "noAttributeRelation":
                        break;
                    case "no415":
                        break;
                    case "no419":
                        break;
                    case "no450":
                        break;
                    case "no531":
                        break;
                    case "no688":
                        break;
                    case "no754":
                        break;
                    case "no762":
                        break;
                    case "no764":
                        break;
                    case "no768":
                        break;
                    case "no790":
                        break;
                    case "no791":
                        break;
                    case "no818":
                        break;
                    case "no824":
                        break;
                }
            }
        }
    }

    public static void attackBonus(Card[] card, Double factor){
        for(int i=0;i<6;i++) {
            card[i].setCalculatedAttack(card[i].getCalculatedAttack() * factor);
        }
    }

    public static void hpBonus(Card[] card, Double factor){
        for(int i=0;i<6;i++) {
            card[i].setCalculatedHP(card[i].getCalculatedHP() * factor);
        }
    }

    public static void recoveryBonus(Card[] card, Double factor){
        for(int i=0;i<6;i++) {
            card[i].setCalculatedRecovery(card[i].getCalculatedRecovery() * factor);
        }
    }

    public static void colorAttackBonus(Card[] card,String color,Double factor){
        for(int i=0;i<6;i++) {
            if (card[i].getColor().equals(color)) {
                card[i].setCalculatedAttack(card[i].getCalculatedAttack() * factor);
            }
        }
    }

    public static void colorHPBonus(Card[] card,String color,Double factor){
        for(int i=0;i<6;i++) {
            if (card[i].getColor().equals(color)) {
                card[i].setCalculatedHP(card[i].getCalculatedHP() * factor);
            }
        }
    }

    public static void colorRecoveryBonus(Card[] card,String color,Double factor){
        for(int i=0;i<6;i++) {
            if (card[i].getColor().equals(color)) {
                card[i].setCalculatedRecovery(card[i].getCalculatedRecovery() * factor);
            }
        }
    }

    public static void raceAttackBonus(Card[] card,String race,Double factor){
        for(int i=0;i<6;i++) {
            if (card[i].getRace().equals(race)) {
                card[i].setCalculatedAttack(card[i].getCalculatedAttack() * factor);
            }
        }
    }

    public static void raceHPBonus(Card[] card,String race,Double factor){
        for(int i=0;i<6;i++) {
            if (card[i].getRace().equals(race)) {
                card[i].setCalculatedHP(card[i].getCalculatedHP() * factor);
            }
        }
    }

    public static void raceRecoveryBonus(Card[] card,String race,Double factor){
        for(int i=0;i<6;i++) {
            if (card[i].getRace().equals(race)) {
                card[i].setCalculatedRecovery(card[i].getCalculatedRecovery() * factor);
            }
        }
    }

    public static void raceRecoveryPoint(Card[] card,String race,int point){
        for(int i=0;i<6;i++) {
            if (card[i].getRace().equals(race)) {
                card[i].setCalculatedRecovery(card[i].getCalculatedRecovery() + point);
            }
        }
    }

    public static void raceAttackPoint(Card[] card,String race,int point){
        for(int i=0;i<6;i++) {
            if (card[i].getRace().equals(race)) {
                card[i].setCalculatedAttack(card[i].getCalculatedAttack() + point);
            }
        }
    }
    public static void raceAddRecoveryToAttack(Card[] card,String race,int target){
        card[target].setCalculatedAttack(card[target].getCalculatedAttack() + card[target].getCalculatedRecovery());
        for(int i=0;i<6;i++) {
            if (card[i].getRace().equals(race)) {
                card[i].setCalculatedRecovery(0);
            }
        }
    }
    public static void colorAndRaceAttackBonus(Card[] card,String color,String race,Double colorFactor,Double colorRaceFactor){
        for(int i=0;i<6;i++) {
            if (card[i].getColor().equals(color) && card[i].getRace().equals(race)) {
                card[i].setCalculatedAttack(card[i].getCalculatedAttack() * colorRaceFactor);
            }
            else if(card[i].getColor().equals(color)){
                card[i].setCalculatedAttack(card[i].getCalculatedAttack() * colorFactor);
            }
        }
    }
    public static void blueSuppressRedFactor(Battle battle, Double factor){
        if(Double.compare(battle.getBlueSuppressRedFactor(),1.5) == 0)
            battle.setBlueSuppressRedFactor(factor);
        else battle.setBlueSuppressRedFactor(battle.getBlueSuppressRedFactor() * factor);
    }
    public static void redSuppressGreenFactor(Battle battle, Double factor){
        if(Double.compare(battle.getRedSuppressGreenFactor(),1.5) == 0)
            battle.setRedSuppressGreenFactor(factor);
        else battle.setRedSuppressGreenFactor(battle.getRedSuppressGreenFactor() * factor);
    }
    public static void greenSuppressBlueFactor(Battle battle, Double factor) {
        if(Double.compare(battle.getGreenSuppressBlueFactor(),1.5) == 0)
            battle.setGreenSuppressBlueFactor(factor);
        else battle.setGreenSuppressBlueFactor(battle.getGreenSuppressBlueFactor() * factor);
    }
    public static void yellowSuppressPurpleFactor(Battle battle, Double factor) {
        if (Double.compare(battle.getYellowSuppressPurpleFactor(),1.5) == 0)
            battle.setYellowSuppressPurpleFactor(factor);
        else battle.setYellowSuppressPurpleFactor(battle.getYellowSuppressPurpleFactor() * factor);
    }
    public static void purpleSuppressYellowFactor(Battle battle, Double factor) {
        if (Double.compare(battle.getPurpleSuppressYellowFactor(),1.5) == 0)
            battle.setPurpleSuppressYellowFactor(factor);
        else battle.setPurpleSuppressYellowFactor(battle.getPurpleSuppressYellowFactor() * factor);
    }

    public static void blueSuppressPurpleFactor(Battle battle, Double factor) {
        if(Double.compare(battle.getBlueSuppressPurpleFactor(),1.5) == 0)
            battle.setBlueSuppressPurpleFactor(factor);
        else battle.setBlueSuppressPurpleFactor(battle.getBlueSuppressPurpleFactor() * factor);
    }
    public static void redSuppressRedFactor(Battle battle, Double factor){
        if(Double.compare(battle.getRedSuppressRedFactor(),1.5) == 0)
            battle.setRedSuppressRedFactor(factor);
        else battle.setRedSuppressRedFactor(battle.getRedSuppressRedFactor() * factor);
    }
    public static void greenSuppressYellowFactor(Battle battle, Double factor) {
        if(Double.compare(battle.getGreenSuppressYellowFactor(),1.5) == 0)
            battle.setGreenSuppressYellowFactor(factor);
        else battle.setGreenSuppressYellowFactor(battle.getGreenSuppressYellowFactor() * factor);
    }
    public static void yellowSuppressRedFactor(Battle battle, Double factor) {
        if(Double.compare(battle.getYellowSuppressRedFactor(),1.5) == 0)
            battle.setYellowSuppressRedFactor(factor);
        else battle.setYellowSuppressRedFactor(battle.getYellowSuppressRedFactor() * factor);
    }

    public static void purpleSuppressGreenFactor(Battle battle,Double factor){
        if(Double.compare(battle.getPurpleSuppressGreenFactor(),1.5) == 0)
            battle.setPurpleSuppressGreenFactor(factor);
        else battle.setPurpleSuppressGreenFactor(battle.getPurpleSuppressGreenFactor() * factor);
    }

    public static void attack3WhenLowHP(Battle battle, Card[] card){
        /*
        attack factor
        >50     1+detainedHP%*2
        20-50   detainedHP%*4
        <20     3
        */
        double currentHPPercent = (double)battle.getCurrentHP()/battle.getMaxHP();
        double detainedHPPercent = 1.0 - currentHPPercent;
        if(currentHPPercent > 50) attackBonus(card, 1 + detainedHPPercent * 2);
        else if(currentHPPercent <20) attackBonus(card,3.0);
        else attackBonus(card,detainedHPPercent*4);
    }

    public static void attack2p5WhenLowHP(Battle battle, Card[] card){
        /*
        attack factor
        >50     1+detainedHP%*2
        20-50   7/6+detainedHP%*(5/3)
        <20     2.5
        */
        double currentHPPercent = (double)battle.getCurrentHP()/battle.getMaxHP();
        double detainedHPPercent = 1.0 - currentHPPercent;
        if(currentHPPercent >50) attackBonus(card,1+detainedHPPercent*2);
        else if(currentHPPercent <20) attackBonus(card,2.5);
        else attackBonus(card,(7/6.0)+detainedHPPercent*(5/3.0));
    }

    public static void attack3p5WhenLowHP(Battle battle, Card[] card){
        /*
        attack factor
        >=15     1+detainedHP%*2.94
        <15     3.5
        */
        double currentHPPercent = (double)battle.getCurrentHP()/battle.getMaxHP();
        double detainedHPPercent = 1.0 - currentHPPercent;
        if(currentHPPercent <50) attackBonus(card,3.5);
        else attackBonus(card,1+detainedHPPercent*2.94);
    }

    public static void highAttackWhenMoreAttribute(Card[] card,String race) {
        /*
        傷害倍數 = 1 + 擁有屬性數量 × 0.5
        max 3.5
        */
        int blue=0;
        int red=0;
        int green=0;
        int yellow=0;
        int purple=0;
        for(Card c:card){
            if( race == null || c.getRace().equals(race) ) {
                switch (c.getColor()) {
                    case "blue":
                        blue = 1;
                        break;
                    case "red":
                        red = 1;
                        break;
                    case "green":
                        green = 1;
                        break;
                    case "yellow":
                        yellow = 1;
                        break;
                    case "purple":
                        purple = 1;
                        break;
                }
            }
        }
        double factor=1+(blue+red+green+yellow+purple)*0.5;
        if(factor>3.5)factor=3.5;
        attackBonus(card,factor);
    }

    public static void attackBonusWhenOnly2Race(Card[] card, String race1, String race2, Double factor){
        boolean isRace1 = false;
        boolean isRace2 = false;

        for(Card c:card){
            if(c.getRace().equals(race1)) isRace1=true;
            else if(c.getRace().equals(race2)) isRace2=true;
        }
        if(isRace1 == true && isRace2 == true) attackBonus(card,factor);
    }

    public static void attackBonusRecoveryBonusWhenOnlyNumbersOfColor(Card[] card,String color,int numColor,Double attackFactor, Double recoveryFactor) {
        int currentColorCount = 0;
        for (Card c:card){
            if(c.getColor().equals(color)) currentColorCount++;
        }
        if(currentColorCount == numColor){
            attackBonus(card, attackFactor);
            recoveryBonus(card, recoveryFactor);
        }
    }

    public static void threeRaceAttackWhenExistRaceAndNumberOfRaceOrOtherRace(Card[] card,String race1,int numOfRace,String race2a, String race2b,Double race1Ack,Double race2aAck,Double race2bAck){
        int currentNumOfRace=0;
        boolean otherRace = false;
        for(Card c:card){
            //check contain other race
            if( !(c.getRace().equals(race1) || c.getRace().equals(race2a) || c.getRace().equals(race2b)) ){
                otherRace=true;
                break;
            }
            //check race should equal or above num
            if(race2b!=null)
                if(c.getRace().equals(race2a) || c.getRace().equals(race2b))numOfRace++;
            else
                if(c.getRace().equals(race2a))currentNumOfRace++;
        }
        if( !(currentNumOfRace<numOfRace || otherRace == true) ){
            raceAttackBonus(card, race1, race1Ack);
            raceAttackBonus(card, race2a, race2aAck);
            if(race2b!=null && race2bAck!=null) raceAttackBonus(card,race2b,race2bAck);
        }
    }

    public static void attack3WhenOnlyBlueRedGreenAndDissolve3AttributeStone(Card[] card){
        //隊伍中只有水、火及木屬性的成員時
        boolean isBlue = false;
        boolean isRed = false;
        boolean isGreen = false;
        for(Card c:card){
            switch(c.getColor()){
                case "blue":
                    isBlue = true;
                    break;
                case "red":
                    isRed = true;
                    break;
                case "green":
                    isGreen = true;
                    break;
                case "yellow":
                    return; //return
                case "purple":
                    return; //return
            }
        }
        if(!isBlue || !isRed || !isGreen ) return;
        //消除任何三種或以上屬性符石
        int blue = 0;
        int red = 0;
        int green = 0;
        int yellow = 0;
        int purple = 0;
        int pink = 0;
        for(Card c:card){
            switch(c.getColor()){
                case "blue":
                    blue = 1;
                    break;
                case "red":
                    red = 1;
                    break;
                case "green":
                    green = 1;
                    break;
                case "yellow":
                    yellow = 1;
                    break;
                case "purple":
                    purple = 1;
                    break;
                case "pink":
                    pink = 1;
            }
        }
        int total = blue+red+green+yellow+purple+pink;
        if(total>=3) attackBonus(card,3.0);
    }

    public static void greenAttack3WhenOnlyGreenElfBeastDemon(Card[] card){
        boolean isElf = false;
        boolean isBeast = false;
        boolean isDemon = false;

        for(Card c:card){
            if(c.getColor().equals("green")) {
                switch (c.getRace()) {
                    case "elf":
                        isElf = true;
                        break;
                    case "beast":
                        isBeast = true;
                        break;
                    case "god":
                        return; //return
                    case "demon":
                        isDemon = true;
                        break;
                    case "dragon":
                        return; //return
                    case "human":
                        return; //return
                }
            }
            else if(!c.getColor().equals("")) return;
        }
        if(isElf && isBeast && isDemon ) colorAttackBonus(card,"green",3.0);
    }

    public static void yellowAttack2MaxYellowAttack3p5WhenMoreHuman(Card[] card){
       int numOfHuman = 0;
        for(Card c:card){
            if(c.getRace().equals("human")) numOfHuman++;
        }
        Double factor = 2+0.25*numOfHuman;
        if(factor>3.5)factor = 3.5;
        colorAttackBonus(card,"yellow",factor);
    }

    public static void redGreenPurpleAttack3WhenExistRedGreenPurpleAndDissolve3AttributeStone(Card[] card){
        //隊伍中須有火、木及暗屬性的成員
        boolean isRed = false;
        boolean isGreen = false;
        boolean isPurple = false;
        for(Card c:card){
            switch(c.getColor()){
                case "red":
                    isRed = true;
                    break;
                case "green":
                    isGreen = true;
                    break;
                case "purple":
                    isPurple = true;
                    break;
            }
        }
        if(!isRed || !isGreen || !isPurple) return;
        //消除任何三種或以上屬性符石
        int blue = 0;
        int red = 0;
        int green = 0;
        int yellow = 0;
        int purple = 0;
        int pink = 0;
        for(Card c:card){
            switch(c.getColor()){
                case "blue":
                    blue = 1;
                    break;
                case "red":
                    red = 1;
                    break;
                case "green":
                    green = 1;
                    break;
                case "yellow":
                    yellow = 1;
                    break;
                case "purple":
                    purple = 1;
                    break;
                case "pink":
                    pink = 1;
            }
        }
        int total = blue+red+green+yellow+purple+pink;
        if(total>=3) {
            colorAttackBonus(card,"red",3.0);
            colorAttackBonus(card,"green",3.0);
            colorAttackBonus(card,"purple",3.0);
        }
    }

    public static void possessionFunction(Battle battle, String color1, String color2, Double factor){
        //color1 part
        List<Integer> color1List = new ArrayList<>();
        switch(color1){
            case "blue":
                color1List.addAll(battle.getNumOfBlue());
                break;
            case "red":
                color1List.addAll(battle.getNumOfRed());
                break;
            case "green":
                color1List.addAll(battle.getNumOfGreen());
                break;
            case "yellow":
                color1List.addAll(battle.getNumOfYellow());
                break;
            case "purple":
                color1List.addAll(battle.getNumOfPurple());
                break;
        }
        //factor part
        List<Double> factorList = new ArrayList<>();
        int sizeofColor1List = color1List.size();
        for(int i=0;i<sizeofColor1List;i++) factorList.add(factor);
        //color2 and factor part
        switch(color2){
            case "blue":
                battle.setBlueForPossession(color1List);
                battle.setBlueForPossessFactor(factorList);
                break;
            case "red":
                battle.setRedForPossession(color1List);
                battle.setRedForPossessFactor(factorList);
                break;
            case "green":
                battle.setGreenForPossession(color1List);
                battle.setGreenForPossessFactor(factorList);
                break;
            case "yellow":
                battle.setYellowForPossession(color1List);
                battle.setYellowForPossessFactor(factorList);
                break;
            case "purple":
                battle.setPurpleForPossession(color1List);
                battle.setPurpleForPossessFactor(factorList);
                break;
        }
    }

    public static void colorPossessAllBasedOnBeast(Battle battle,Card[] card,String color){
        //每個獸類成員提升 10% 效果，最高 50%
        int counter = 0;
        for(Card c:card){
            if(c.getRace().equals("beast"))counter++;
        }
        if(counter>5)counter=5;
        if(!color.equals("blue")) possessionFunction(battle,color,"blue",0.1*counter);
        if(!color.equals("red")) possessionFunction(battle,color,"red",0.1*counter);
        if(!color.equals("green"))  possessionFunction(battle,color,"green",0.1*counter);
        if(!color.equals("yellow"))  possessionFunction(battle,color,"yellow",0.1*counter);
        if(!color.equals("purple"))  possessionFunction(battle,color,"purple",0.1*counter);
    }

    public static void singleAttack(Battle battle,Card[] card,Double factor){
        boolean isSingleStone = true;
        //blue
        for(int i:battle.getNumOfBlue())
            if(i>=5)isSingleStone = false;
        if(isSingleStone)colorAttackBonus(card,"blue",factor);
        //red
        isSingleStone = true;
        for(int i:battle.getNumOfRed())
            if(i>=5)isSingleStone = false;
        if(isSingleStone)colorAttackBonus(card,"red",factor);
        //green
        isSingleStone = true;
        for(int i:battle.getNumOfGreen())
            if(i>=5)isSingleStone = false;
        if(isSingleStone)colorAttackBonus(card,"green",factor);
        //yellow
        isSingleStone = true;
        for(int i:battle.getNumOfYellow())
            if(i>=5)isSingleStone = false;
        if(isSingleStone)colorAttackBonus(card,"yellow",factor);
        //purple
        isSingleStone = true;
        for(int i:battle.getNumOfPurple())
            if(i>=5)isSingleStone = false;
        if(isSingleStone)colorAttackBonus(card,"purple",factor);
    }

}
