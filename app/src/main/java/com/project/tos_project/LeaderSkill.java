package com.project.tos_project;

import com.project.tos_project.model.Card;

/**
 * Created by LAI on 2015/5/29.
 */
public class LeaderSkill {

    public static void processLeaderSkill(Card[] card){
        for(int i=0;i<6;i=i+5) {
            switch(card[i].getLeaderSkill()) {
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
                default:
                    System.out.println("No leader skill found"); //for testing only
            }
        }
    }

    public static void attackBonus(Card[] card, Double factor){
        for(int i=0;i<6;i++) {
            int temp = (int) (card[i].getCalculatedAttack() * factor);
            card[i].setCalculatedAttack(temp);
        }
    }

    public static void hpBonus(Card[] card, Double factor){
        for(int i=0;i<6;i++) {
            int temp = (int) (card[i].getCalculatedHP() * factor);
            card[i].setCalculatedHP(temp);
        }
    }

    public static void recoveryBonus(Card[] card, Double factor){
        for(int i=0;i<6;i++) {
            int temp = (int) (card[i].getCalculatedRecovery() * factor);
            card[i].setCalculatedRecovery(temp);
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

    public static void colorHPBonus(Card[] card,String color,Double factor){
        for(int i=0;i<6;i++) {
            if (card[i].getColor().equals(color)) {
                int temp = (int) (card[i].getCalculatedHP() * factor);
                card[i].setCalculatedHP(temp);
            }
        }
    }

    public static void colorRecoveryBonus(Card[] card,String color,Double factor){
        for(int i=0;i<6;i++) {
            if (card[i].getColor().equals(color)) {
                int temp = (int) (card[i].getCalculatedRecovery() * factor);
                card[i].setCalculatedRecovery(temp);
            }
        }
    }

    public static void raceAttackBonus(Card[] card,String race,Double factor){
        for(int i=0;i<6;i++) {
            if (card[i].getRace().equals(race)) {
                int temp = (int) (card[i].getCalculatedAttack() * factor);
                card[i].setCalculatedAttack(temp);
            }
        }
    }

    public static void raceHPBonus(Card[] card,String race,Double factor){
        for(int i=0;i<6;i++) {
            if (card[i].getRace().equals(race)) {
                int temp = (int) (card[i].getCalculatedHP() * factor);
                card[i].setCalculatedHP(temp);
            }
        }
    }

    public static void raceRecoveryBonus(Card[] card,String race,Double factor){
        for(int i=0;i<6;i++) {
            if (card[i].getRace().equals(race)) {
                int temp = (int) (card[i].getCalculatedRecovery() * factor);
                card[i].setCalculatedRecovery(temp);
            }
        }
    }
}
