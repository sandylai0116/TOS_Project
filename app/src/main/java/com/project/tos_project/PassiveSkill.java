package com.project.tos_project;

import com.project.tos_project.model.Battle;
import com.project.tos_project.model.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        //Norse Gods + Odin + Norse Gods
        norseGodsAndOdinNorseGods(battle, card);

        //Michael Lucifer + Luna
        michaelLuciferLuna(card);

        //The Stunning Power
        if(card[0].getId() == 595 || card[5].getId() == 595) battle.setEachComboFactor(battle.getEachComboFactor()+0.25);

        //Moonlight Immortal Changxi + The Norns
        moonlightImmortalChangxiTheNorns(battle, card);

        //Regulator - Deus Ex Machina + BIGBANG
        regulatorDeusExMachinaBIGBANG(card);

        //Xuan-Yuan Sword (1)
        xuanYuanSword1(card);

        //Xuan-Yuan Sword (2)
        xuanYuanSword2(card);

        //Xuan-Yuan Sword (3)
        if(card[0].getId()==763) {
            for(Card c:card) if(c.getId()==780)c.setColor("yellow");
        }

        //Xuan-Yuan Sword (4)
        for(int i=0;i<5;i++){
            if((card[i].getId()==755 && card[i+1].getId()==781) || (card[i].getId()==781 && card[i+1].getId()==755)) {
                card[i].setCurrentAttack(card[i].getCurrentAttack()*1.5);
                card[i+1].setCurrentAttack(card[i+1].getCurrentAttack()*1.5);
            }
        }

        //Dragon from Sepulchre (WFE)
        dragonFromSepulchreWFE(battle,card);

        //Giemsa + Diva of the Stars (WFE)
        goddessOfOrderGiemsa(battle,card);
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
        map.put(422, 318);

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
        List<Integer> idList = new ArrayList<>();
        idList.add(192);
        idList.add(194);
        idList.add(196);
        idList.add(198);
        idList.add(200);

        if(card[0].getId() == card[5].getId() && idList.contains(card[0].getId())){
            for(Card c:card)
                if(c.getId() == 579) c.setColor(card[0].getColor());
        }
    }

    public static void norseGodsAndOdinNorseGods(Battle battle,Card[] card){
        boolean star6Leader = false;
        boolean star6Ally = false;
        boolean star7Leader = false;
        boolean star7Ally = false;
        List<Integer> star6List = new ArrayList<>();
        star6List.add(202);
        star6List.add(204);
        star6List.add(206);
        star6List.add(208);
        star6List.add(210);
        List<Integer> star7List = new ArrayList<>();
        star6List.add(506);
        star6List.add(507);
        star6List.add(508);
        star6List.add(509);
        star6List.add(510);
        //check 6 star
        if( star6List.contains(card[0].getId()) ) star6Leader = true;
        if( star6List.contains(card[5].getId()) ) star6Ally = true;
        if(star6Leader && star6Ally) {
            battle.setEnchantedStoneFactor(0.25);
        }
        //check 7 star
        if( star7List.contains(card[0].getId()) ) star7Leader = true;
        if( star7List.contains(card[5].getId()) ) star7Ally = true;
        if(star7Leader && star7Ally) {
            battle.setEnchantedStoneFactor(0.25);
        }
        //Odin + Norse Gods Part
        if(star6Leader && star6Ally && card[0].getId() == card[5].getId()) {
            for(Card c:card){
                if(c.getId() == 287 || c.getId() == 739) c.setColor(card[0].getColor());
            }
        }
        if(star7Leader) {
            for(Card c:card){
                if(c.getId() == 287 || c.getId() == 739) c.setColor(card[0].getColor());
            }
        }
    }

    public static void michaelLuciferLuna(Card[] card){
        double attack = -1.0;
        for(Card c:card){
            if(c.getId() == 293) {
                attack = c.getCurrentAttack();
                break;
            }
        }
        if(attack > 0) {
            for(Card c:card){
                if(c.getId() == 368 || c.getId() == 822) {
                    c.setCurrentAttack(attack);
                    break;
                }
            }
        }
    }

    public static void moonlightImmortalChangxiTheNorns(Battle battle, Card[] card){
        if(card[0].getId() == 618){
            int star5Count = 0;
            int star6Count = 0;
            double bonus = 0;

            List<Integer> star5List = new ArrayList<>();
            star5List.add(118);
            star5List.add(121);
            star5List.add(124);
            star5List.add(127);
            star5List.add(130);
            List<Integer> star6List = new ArrayList<>();
            star6List.add(481);
            star6List.add(482);
            star6List.add(483);
            star6List.add(484);
            star6List.add(485);

            for(int i=1;i<6;i++){
                if(star5List.contains(card[i].getId()))star5Count++;
                if(star6List.contains(card[i].getId()))star6Count++;
            }

            if(star5Count>1 || star6Count>1){
                bonus = (star5Count+star6Count)*0.1;
                LeaderSkill.possessionFunction(battle, "pink", "blue", bonus);
                LeaderSkill.possessionFunction(battle, "pink", "red", bonus);
                LeaderSkill.possessionFunction(battle, "pink", "green", bonus);
                LeaderSkill.possessionFunction(battle, "pink", "yellow", bonus);
                LeaderSkill.possessionFunction(battle, "pink", "purple", bonus);
            }
        }
    }

    public static void regulatorDeusExMachinaBIGBANG(Card[] card){
        List<Integer> star7List = new ArrayList<>();
        star7List.add(677);
        star7List.add(679);
        star7List.add(681);
        star7List.add(683);
        star7List.add(685);

        if(card[0].getId() == 616) {
            for(int i=1;i<6;i++){
                if (star7List.contains(card[i].getId()))card[i].setCurrentAttack(card[i].getCurrentAttack()*2.0);
            }
        }
    }

    public static void xuanYuanSword1(Card[] card){
        int star6Count = 0;
        for(Card c:card) if(c.getId()==747 || c.getId()==749 || c.getId()==751) star6Count++;
        if(star6Count>1){
            for(Card c:card) if(c.getId()==747 || c.getId()==749 || c.getId()==751) {
                c.setCurrentAttack(c.getCurrentAttack()*1.3);
                c.setCurrentHP(c.getCurrentHP() *1.3);
                c.setCurrentRecovery(c.getCurrentRecovery()*1.3);
            }
        }
    }

    public static void xuanYuanSword2(Card[] card){
        boolean has759card = false;
        boolean has761card = false;
        if(card[0].getId()==759 || card[5].getId()==759 ) has759card = true;
        if(card[0].getId()==761 || card[5].getId()==761 ) has761card = true;

        if(has759card && has761card){
            for(Card c:card) {
                c.setCurrentAttack(c.getCurrentAttack()*6.0);
                if(c.getId()==759 || c.getId()==761 )
                    c.setCurrentAttack(c.getCurrentAttack()*2.0);
            }
        }
    }

    public static void dragonFromSepulchreWFE(Battle battle,Card[] card){
        if(card[0].getId()==card[5].getId()){
            if(card[0].getId()==791) LeaderSkill.possessionFunction(battle, "pink", "blue", 0.5);
            if(card[0].getId()==793) LeaderSkill.possessionFunction(battle, "pink", "red", 0.5);
            if(card[0].getId()==795) LeaderSkill.possessionFunction(battle, "pink", "green", 0.5);
        }
    }

    public static void goddessOfOrderGiemsa(Battle battle,Card[] card){
        if(card[0].getId()==450){
            if(card[5].getId()==785) {
                card[0].setColor(card[5].getColor());
                LeaderSkill.possessionFunction(battle, "red", "blue", 1.0);
                LeaderSkill.possessionFunction(battle, "green", "blue", 1.0);
            }
            else if(card[5].getId()==787) {
                card[0].setColor(card[5].getColor());
                LeaderSkill.possessionFunction(battle, "blue", "red", 1.0);
                LeaderSkill.possessionFunction(battle, "green", "red", 1.0);
            }
            else if(card[5].getId()==789) {
                card[0].setColor(card[5].getColor());
                LeaderSkill.possessionFunction(battle, "blue", "green", 1.0);
                LeaderSkill.possessionFunction(battle, "red", "green", 1.0);
            }
        }
    }
}
