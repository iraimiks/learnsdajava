package com.sda.teams;

import com.sda.superheroes.AbstractHero;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;

public enum Side {
    EVIL,
    GOOD,
    UNKNOWN;

    public boolean belongsTo(AbstractHero hero) {

        if ((this == GOOD && hero instanceof SuperHero) || (this == EVIL && hero instanceof Villain)) {
            return true;
        } else {
            return false;
        }
    }
}