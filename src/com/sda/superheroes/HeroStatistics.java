package com.sda.superheroes;

public class HeroStatistics {
    public void setHealth(int health) {
        this.health = health;
    }

    private int health;
    private int attack;
    private int defense;

    public void addToHealth(int toAdd){

        this.health += toAdd;
        if(this.health <0){
            this.health = 0;
        }
    }
    public void addToAttack(int toAdd){
        this.attack += toAdd;
    }
    public void addToDefense(int toAdd){
        this.defense += toAdd;
    }
    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public HeroStatistics(int health, int attack, int defense) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof HeroStatistics){
            HeroStatistics otherStats = (HeroStatistics) obj;
            return this.getHealth() == otherStats.getHealth() &&
                    this.getAttack() == otherStats.getAttack() &&
                    this.getDefense() == otherStats.getDefense();
        }
        return false;
    }
}
