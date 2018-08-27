package com.sda.teams;

import com.sda.superheroes.AbstractHero;

import org.junit.Test;

public class InvalidHeroTeamException extends Exception {
    public InvalidHeroTeamException(String message){
        super(message);
    }
    public InvalidHeroTeamException(AbstractHero hero){
        super("there was an exception with hero called"+hero.getTeam());
    }
    public InvalidHeroTeamException(Team teamtype){
        super("there was an exception with team color ..." +teamtype.getTeam());
    }

}


