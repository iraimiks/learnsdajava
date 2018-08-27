package com.sda.utils;

import com.sda.teams.Team;

public class TeamUnits  {
    static double compareTeams(Team team1, Team team2) {
        return team1.getTeamPower() - team2.getTeamPower();
    }

    static Team getStrongestTeam(Team team1, Team team2) {

        double result = compareTeams(team1,team2);

        if (result > 0){
            return team1;
        } else if (result < 0){
            return team2;
        } else {
            System.out.println("Both teams are equal power");
            return null;
        }
    }
}
