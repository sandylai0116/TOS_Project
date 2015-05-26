package com.project.tos_project.model;

/**
 * Created by LAI on 2015/5/26.
 */
public class Card {
    long id;
    int level1HP;
    int level1Attack;
    int level1Recovery;
    int level99HP;
    int level99Attack;
    int level99Recovery;
    String skill;
    String leaderSkill;

    public Card(){}

    public Card(long id, int level1HP, int level1Attack, int level1Recovery, int level99HP, int level99Attack, int level99Recovery, String skill, String leaderSkill) {
        this.id = id;
        this.level1HP = level1HP;
        this.level1Attack = level1Attack;
        this.level1Recovery = level1Recovery;
        this.level99HP = level99HP;
        this.level99Attack = level99Attack;
        this.level99Recovery = level99Recovery;
        this.skill = skill;
        this.leaderSkill = leaderSkill;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLevel1HP() {
        return level1HP;
    }

    public void setLevel1HP(int level1HP) {
        this.level1HP = level1HP;
    }

    public int getLevel1Attack() {
        return level1Attack;
    }

    public void setLevel1Attack(int level1Attack) {
        this.level1Attack = level1Attack;
    }

    public int getLevel1Recovery() {
        return level1Recovery;
    }

    public void setLevel1Recovery(int level1Recovery) {
        this.level1Recovery = level1Recovery;
    }

    public int getLevel99HP() {
        return level99HP;
    }

    public void setLevel99HP(int level99HP) {
        this.level99HP = level99HP;
    }

    public int getLevel99Attack() {
        return level99Attack;
    }

    public void setLevel99Attack(int level99Attack) {
        this.level99Attack = level99Attack;
    }

    public int getLevel99Recovery() {
        return level99Recovery;
    }

    public void setLevel99Recovery(int level99Recovery) {
        this.level99Recovery = level99Recovery;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getLeaderSkill() {
        return leaderSkill;
    }

    public void setLeaderSkill(String leaderSkill) {
        this.leaderSkill = leaderSkill;
    }
}
