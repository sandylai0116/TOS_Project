package com.project.tos_project;

import com.project.tos_project.model.Battle;
import com.project.tos_project.model.Card;

/**
 * Created by LAI on 2015/6/18.
 */
public class PassiveSkill {
    public static void processPassiveSkill(Battle battle,Card[] card) {
        //Protagonists (1)
        protagonists1(card);

        //Protagonists (2)
        protagonists2(card);

        //Defensive Dragons
        defensiveDragons(card);

        //Elves
        elves(card);

        //Little Witches
        littleWitches(card);

        //Slimes
        slimes(card);

        //The Norns (1)
        theNorns1(card);

        //The Norns (2)
        theNorns2(card);

        //Ethereal Dragons1
        etherealDragons1(battle,card);

        //Ethereal Dragons2
        etherealDragons2(battle,card);

        //Saruman + Gnomes
        sarumanGnomes(card);

        //妲己
        if(card[0].getId() == 595 && card[5].getId() == 595) battle.setEachComboFactor(battle.getEachComboFactor()+0.25);

    }

    public static void protagonists1(Card[] card){
        int count =0;
        for (Card c:card) {
            if(c.getId() >= 1 && c.getId() <= 20) count++;
        }
        double factor=1.0;
        if(count==3)factor=1.3;
        else if(count==4)factor=1.4;
        else if(count==5)factor=1.5;

        for (Card c:card) {
            if(c.getId() >= 1 && c.getId() <= 20)
                c.setCalculatedRecovery(c.getCalculatedRecovery() * factor);
        }
    }

    public static void protagonists2(Card[] card){
        int count =0;
        for (Card c:card) {
            if(c.getId() >= 408 && c.getId() <= 412) count++;
        }
        double factor=1.0;
        if(count==3)factor=1.3;
        else if(count==4)factor=1.4;
        else if(count==5)factor=1.5;

        for (Card c:card) {
            if(c.getId() >= 408 && c.getId() <= 412)
                c.setCalculatedRecovery(c.getCalculatedRecovery() * factor);
        }
    }

    public static void defensiveDragons(Card[] card){
        int count =0;
        for (Card c:card) {
            if(c.getId() >= 41 && c.getId() <= 55) count++;
        }
        double factor=1.0;
        if(count==3)factor=1.3;
        else if(count==4)factor=1.4;
        else if(count==5)factor=1.5;

        for (Card c:card) {
            if(c.getId() >= 41 && c.getId() <= 55)
                c.setCalculatedAttack(c.getCalculatedAttack() * factor);
        }
    }

    public static void elves(Card[] card){
        int count =0;
        for (Card c:card) {
            if((c.getId() >= 66 && c.getId() <= 75) || (c.getId() >= 334 && c.getId() <= 338)) count++;
        }
        double factor=1.0;
        if(count==3)factor=1.3;
        else if(count==4)factor=1.4;
        else if(count==5)factor=1.5;

        for (Card c:card) {
            if((c.getId() >= 66 && c.getId() <= 75) || (c.getId() >= 334 && c.getId() <= 338))
                c.setCalculatedHP(c.getCalculatedHP() * factor);
        }
    }

    public static void littleWitches(Card[] card){
        int count =0;
        for (Card c:card) {
            if((c.getId() >= 86 && c.getId() <= 95) || (c.getId() >= 456 && c.getId() <= 460)) count++;
        }
        double factor=1.0;
        if(count==3)factor=1.3;
        else if(count==4)factor=1.4;
        else if(count==5)factor=1.5;

        for (Card c:card) {
            if((c.getId() >= 86 && c.getId() <= 95) || (c.getId() >= 456 && c.getId() <= 460))
                c.setCalculatedRecovery(c.getCalculatedRecovery() * factor);
        }
    }

    public static void slimes(Card[] card){
        int count =0;
        for (Card c:card) {
            if((c.getId() >= 96 && c.getId() <= 105) || (c.getId() >= 329 && c.getId() <= 333)) count++;
        }
        double factor=1.0;
        if(count==3)factor=1.3;
        else if(count==4)factor=1.4;
        else if(count==5)factor=1.5;

        for (Card c:card) {
            if((c.getId() >= 96 && c.getId() <= 105) || (c.getId() >= 329 && c.getId() <= 333))
                c.setCalculatedAttack(c.getCalculatedAttack() * factor);
        }
    }

    public static void theNorns1(Card[] card){
        int count =0;
        for (Card c:card) {
            if(c.getId() >= 116 && c.getId() <= 130) count++;
        }
        double factor=1.0;
        if(count==3)factor=1.3;
        else if(count==4)factor=1.4;
        else if(count==5)factor=1.5;

        for (Card c:card) {
            if(c.getId() >= 116 && c.getId() <= 130)
                c.setCalculatedAttack(c.getCalculatedAttack() * factor);
        }
    }

    public static void theNorns2(Card[] card){
        int count =0;
        for (Card c:card) {
            if(c.getId() >= 481 && c.getId() <= 485) count++;
        }
        double factor=1.0;
        if(count==3)factor=1.3;
        else if(count==4)factor=1.4;
        else if(count==5)factor=1.5;

        for (Card c:card) {
            if(c.getId() >= 481 && c.getId() <= 485)
                c.setCalculatedAttack(c.getCalculatedAttack() * factor);
        }
    }

    public static void etherealDragons1(Battle battle, Card[] card){
        //not accurate formula
        //0.07/x+0.88 = factor
        //x = battle.getCurrentHP()/battle.getMaxHP()

        int count =0;
        for (Card c:card) {
            if(c.getId() >= 309 && c.getId() <= 318) count++;
        }
        double factor=1.0;
        if(count==3)factor=1.5;
        else if(count==4)factor=1.75;
        else if(count==5)factor=2.0;

        double currentFactor = 0.07/(battle.getCurrentHP()/(double)battle.getMaxHP())+0.88;
        if(currentFactor>factor)currentFactor = factor;

        for (Card c:card) {
            if(c.getId() >= 309 && c.getId() <= 318)
                c.setCalculatedAttack(c.getCalculatedAttack() * currentFactor);
        }
    }

    public static void etherealDragons2(Battle battle, Card[] card){
        //not accurate formula
        //0.07/x+0.88 = factor
        //x = battle.getCurrentHP()/battle.getMaxHP()

        int count =0;
        for (Card c:card) {
            if(c.getId() >= 571 && c.getId() <= 575) count++;
        }
        double factor=1.0;
        if(count==3)factor=1.5;
        else if(count==4)factor=1.75;
        else if(count==5)factor=2.0;

        double currentFactor = 0.07/(battle.getCurrentHP()/(double)battle.getMaxHP())+0.88;
        if(currentFactor>factor)currentFactor = factor;

        for (Card c:card) {
            if(c.getId() >= 571 && c.getId() <= 575)
                c.setCalculatedAttack(c.getCalculatedAttack() * currentFactor);
        }
    }

    public static void sarumanGnomes(Card[] card){
        int count = 0;
        if(card[0].getId() == 286 || card[0].getId() == 674){
            for(int i=1;i<5;i++){
                if(card[i].getId() == 57 || card[i].getId() == 59 || card[i].getId() == 61 || card[i].getId() == 63 || card[i].getId() == 65)
                    count++;
            }
            if(count == 4) {
                for(int i=1;i<5;i++){
                    card[i].setCalculatedAttack(card[i].getCalculatedAttack() * 5);
                }
            }
            count = 0;
            for(int i=1;i<5;i++){
                if(card[i].getId() >= 451 && card[i].getId() <= 455)
                    count++;
            }
            if(count == 4) {
                for(int i=1;i<5;i++){
                    card[i].setCalculatedAttack(card[i].getCalculatedAttack() * 5);
                }
            }
        }
    }
}
