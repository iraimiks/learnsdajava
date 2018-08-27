package com.sda.superheroes;

import com.sda.teams.TeamType;

public class Vilain extends AbstractHero {
    public Vilain(String name, HeroStatistics stats, TeamType team){
        super(name,stats,team);
    }

    @Override
    public double getPower() {
        HeroStatistics stats = this.getStats();
        double power = (stats.getAttack()+stats.getHealth())*stats.getDefense();
        return power;
    }
}
