package com.project.tos_project.model;

/**
 * Created by LAI on 2015/5/26.
 */
public class Card {
    long id;
    String color;
    String race;
    int maxLevel;
    int level1HP;
    int level1Attack;
    int level1Recovery;
    int levelMaxHP;
    int levelMaxAttack;
    int levelMaxRecovery;
    String skill;
    String leaderSkill;
    int currentLevel;
    int currentHP;
    int currentAttack;
    int currentRecovery;
    Boolean enableSkill;
    Boolean enableLeaderSkill;
    int calculatedHP;
    int calculatedAttack;
    int calculatedRecovery;

    public Card(){}

    public Card(long id, String color, String race, int maxLevel, int level1HP, int level1Attack, int level1Recovery, int levelMaxHP, int levelMaxAttack, int levelMaxRecovery, String skill, String leaderSkill) {
        this.id = id;
        this.color = color;
        this.race = race;
        this.maxLevel = maxLevel;
        this.level1HP = level1HP;
        this.level1Attack = level1Attack;
        this.level1Recovery = level1Recovery;
        this.levelMaxHP = levelMaxHP;
        this.levelMaxAttack = levelMaxAttack;
        this.levelMaxRecovery = levelMaxRecovery;
        this.skill = skill;
        this.leaderSkill = leaderSkill;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
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

    public int getLevelMaxHP() {
        return levelMaxHP;
    }

    public void setLevelMaxHP(int levelMaxHP) {
        this.levelMaxHP = levelMaxHP;
    }

    public int getLevelMaxAttack() {
        return levelMaxAttack;
    }

    public void setLevelMaxAttack(int levelMaxAttack) {
        this.levelMaxAttack = levelMaxAttack;
    }

    public int getLevelMaxRecovery() {
        return levelMaxRecovery;
    }

    public void setLevelMaxRecovery(int levelMaxRecovery) {
        this.levelMaxRecovery = levelMaxRecovery;
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

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
        setCurrentHP(level1HP + (levelMaxHP - level1HP) / maxLevel * currentLevel);
        setCurrentAttack(level1Attack + (levelMaxAttack - level1Attack) / maxLevel * currentLevel);
        setCurrentRecovery(level1Recovery + (levelMaxRecovery - level1Recovery) / maxLevel * currentLevel);
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getCurrentAttack() {
        return currentAttack;
    }

    public int getCurrentRecovery() {
        return currentRecovery;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public void setCurrentAttack(int currentAttack) {
        this.currentAttack = currentAttack;
    }

    public void setCurrentRecovery(int currentRecovery) {
        this.currentRecovery = currentRecovery;
    }

    public Boolean getEnableSkill() {
        return enableSkill;
    }

    public void setEnableSkill(Boolean enableSkill) {
        this.enableSkill = enableSkill;
    }

    public Boolean getEnableLeaderSkill() {
        return enableLeaderSkill;
    }

    public void setEnableLeaderSkill(Boolean enableLeaderSkill) {
        this.enableLeaderSkill = enableLeaderSkill;
    }

    public int getCalculatedHP() {
        return calculatedHP;
    }

    public void setCalculatedHP(int calculatedHP) {
        this.calculatedHP = calculatedHP;
    }

    public int getCalculatedAttack() {
        return calculatedAttack;
    }

    public void setCalculatedAttack(int calculatedAttack) {
        this.calculatedAttack = calculatedAttack;
    }

    public int getCalculatedRecovery() {
        return calculatedRecovery;
    }

    public void setCalculatedRecovery(int calculatedRecovery) {
        this.calculatedRecovery = calculatedRecovery;
    }
}
