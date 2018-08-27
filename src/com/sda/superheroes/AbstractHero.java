package com.sda.superheroes;

import com.sda.teams.TeamType;

public abstract class AbstractHero {

    private String name;
    private HeroStatistics stats;
    private TeamType team;

    public void setStats(HeroStatistics stats) {
        this.stats = stats;
    }

    public AbstractHero(String name, HeroStatistics stats, TeamType team) {
        this.name = name;
        this.stats = stats;
        this.team = team;
        switch (team) {
            case RED:
                this.stats.addToHealth(50);
                break;
            case BLUE:
                this.stats.addToAttack(50);
                break;
            case GREEN:
                this.stats.addToDefense(50);
                break;
        }
    }
    public boolean isAlive(){
        return this.getStats().getHealth() > 0;
    }
    //- create a method takeDamage() with a parameter double damage. This method will subtract this
    // damage from the hero's health. If after that, the health of the hero is bigger than zero, it returns true.
    // If hero's health goes to zero or less, it's set to zero, and the method returns false.
    public boolean takeDamage(double damage){
        this.getStats().addToHealth(-(int) damage);
        return isAlive();
    }
    public void kill(){
        this.getStats().addToHealth(-(this.getStats().getHealth()));
    }

    public String getName() {
        return name;
    }

    public HeroStatistics getStats() {
        return stats;
    }

    public TeamType getTeam() {
        return team;
    }

    public abstract double getPower();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractHero) {
            AbstractHero otherHero = (AbstractHero) obj;
            String otherHeroName = otherHero.getName();
            TeamType otherHeroTeam = otherHero.getTeam();
            HeroStatistics otherHeroStats = otherHero.getStats();
            return this.getName().equals(otherHeroName) && this.getTeam().equals(otherHeroTeam) && this.getStats().equals(otherHeroStats);
        }
        return false;
    }
}
