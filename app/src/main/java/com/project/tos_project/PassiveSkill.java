package com.project.tos_project;

import com.project.tos_project.model.Battle;
import com.project.tos_project.model.Card;

import java.util.HashMap;
import java.util.Map;

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

        //Dragon Spiritors + Ethereal Dragons
        dragonSpiritorsEtherealDragons(card);

        //Dragon Spiritors + Ethereal Dragons (2)
        dragonSpiritorsEtherealDragons2(card);

        //Sirius Team (1)
        siriusTeam1(card);

        //Sirius Team (2)
        siriusTeam2(card);

        //Zeus + Greek Gods
        //TODO: need to modify if active skill is added
        zeusGreekGods(card);

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
                c.setCurrentRecovery(c.getCurrentRecovery() * factor);
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
                c.setCurrentRecovery(c.getCurrentRecovery() * factor);
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
                c.setCurrentAttack(c.getCurrentAttack() * factor);
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
                c.setCurrentHP(c.getCurrentHP() * factor);
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
                c.setCurrentRecovery(c.getCurrentRecovery() * factor);
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
                c.setCurrentAttack(c.getCurrentAttack() * factor);
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
                c.setCurrentAttack(c.getCurrentAttack() * factor);
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
                c.setCurrentAttack(c.getCurrentAttack() * factor);
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
                c.setCurrentAttack(c.getCurrentAttack() * currentFactor);
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
                c.setCurrentAttack(c.getCurrentAttack() * currentFactor);
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
                    card[i].setCurrentAttack(card[i].getCurrentAttack() * 5);
                }
            }
            count = 0;
            for(int i=1;i<5;i++){
                if(card[i].getId() >= 451 && card[i].getId() <= 455)
                    count++;
            }
            if(count == 4) {
                for(int i=1;i<5;i++){
                    card[i].setCurrentAttack(card[i].getCurrentAttack() * 5);
                }
            }
        }
    }

    public static void dragonSpiritorsEtherealDragons(Card[] card){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(414,310);
        map.put(416,312);
        map.put(418,314);
        map.put(420,316);
        map.put(422,318);

        boolean cardAttackBonus[] = new boolean[6];
        for(int i=0;i<6;i++) cardAttackBonus[i] = false;
        int dragonTargetID = -1;
        for(int i=0;i<6;i=i+5){
            if(map.containsKey(card[i].getId()))
                dragonTargetID = map.get(card[i].getId()).intValue();
            for(int j=1;j<5;j++){
                if(card[j].getId() == dragonTargetID){
                    cardAttackBonus[i] = true;
                    cardAttackBonus[j] = true;
                }
            }
        }
        for(int i=0;i<6;i++){
            if(cardAttackBonus[i]) card[i].setCurrentAttack(card[i].getCurrentAttack() * 1.3);
        }
    }

    public static void dragonSpiritorsEtherealDragons2(Card[] card){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(414,571);
        map.put(416,572);
        map.put(418,573);
        map.put(420,574);
        map.put(422,575);

        boolean cardAttackBonus[] = new boolean[6];
        for(int i=0;i<6;i++) cardAttackBonus[i] = false;
        int dragonTargetID = -1;
        for(int i=0;i<6;i++){
            if(map.containsKey(card[i].getId()))
                dragonTargetID = map.get(card[i].getId()).intValue();
            for(int j=0;j<6;j++){
                if(card[j].getId() == dragonTargetID){
                    cardAttackBonus[i] = true;
                    cardAttackBonus[j] = true;
                }
            }
        }
        for(int i=0;i<6;i++){
            if(cardAttackBonus[i]) card[i].setCurrentAttack(card[i].getCurrentAttack() * 1.3);
        }
    }

    public static void siriusTeam1(Card[] card){
        if(card[0].getId() == 288 && card[5].getId() == 289) LeaderSkill.attackBonus(card,1.5);
        else if(card[0].getId() == 289 && card[5].getId() == 288) LeaderSkill.attackBonus(card,1.5);
    }

    public static void siriusTeam2(Card[] card){
        if(card[0].getId() == 703 && card[5].getId() == 704) LeaderSkill.attackBonus(card,2.0);
        else if(card[0].getId() == 704 && card[5].getId() == 703) LeaderSkill.attackBonus(card,2.0);
    }

    public static void zeusGreekGods(Card[] card){
        Map<Integer, String> map = new HashMap<>();
        map.put(192,"blue");
        map.put(194,"red");
        map.put(196,"green");
        map.put(198,"yellow");
        map.put(200,"purple");
        if(card[0].getId() == card[5].getId()){
            String changeColor = map.get(card[0].getId());
            if(changeColor != null){
                for(Card c:card){
                    if(c.getId() == 579) c.setColor(changeColor);
                }
            }
        }
    }
}
