package com.sda.teams;

import com.sda.superheroes.AbstractHero;
import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;
import com.sda.utils.HeroCreator;

import java.util.*;
import java.util.stream.Collectors;

public class Team implements Comparable<Team> {
    public TeamType getTeam() {
        return team;
    }

    static String heroNames[] = {"Superman", "Batman", "Spiderman", "Thor", "Capitan America", "Wonder Woman", "The Thing", "Mr Fantastic", "Iron Man", "Wally West", "Barry Allen", "Invisible Woman", "Human Torch"};
    static String villainNames[] = {"Joker", "Lex Luthor", "Magneto", "Dr. Doom", "Galactus", "Darkseid", "Ra's al Ghul", "Loki", "Kingpin", "Catwoman", "Two-face", "Norman Osborn", "Red Skull", "Siniestro"};
    static String suffixes[] = {"", " the big", " the small", " the best", " the terrible", " the pain giver", " the amazing"};

    private TeamType team;
    private List<AbstractHero> heroeslist;
    private AbstractHero teamLeader;


    private Side side = Side.UNKNOWN;


    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public AbstractHero getTeamLeader() {

        return teamLeader;

    }

    public double getTeamPower() {
        return heroeslist.stream().mapToDouble(AbstractHero::getPower).sum();
    }

    public Team(TeamType team) {
        this.team = team;
        heroeslist = new ArrayList<AbstractHero>();
    }

    public void addHeroToTeam(AbstractHero hero) throws InvalidHeroTeamException {

        boolean sameTeam = this.team.equals(hero.getTeam());

        boolean isInTeam = this.heroeslist.contains(hero);

        if (sameTeam && !isInTeam) {
            this.heroeslist.add(hero);
            Optional<AbstractHero> teamLeader = findTeamLeader();
            if (teamLeader.isPresent()) {
                this.teamLeader = teamLeader.get();
            }
            this.updateTeamSide();

        } else if (sameTeam && isInTeam) {
            throw new InvalidHeroTeamException("This hero already in team");
        } else {
            throw new InvalidHeroTeamException("This hero can not be added to this team");

        }


    }


    public void listAllHeroes() {
        for (AbstractHero hero : this.heroeslist) {
            System.out.println(hero.getName());
        }
    }

    public Optional<AbstractHero> findTeamLeader() {
        Optional<AbstractHero> batman = heroeslist.stream().filter(h -> h.getName().equals("Batman")).findFirst();
        if (batman.isPresent()) {
            return batman;
        } else return heroeslist.stream().max(Comparator.comparing(AbstractHero::getPower));
    }
       /*- Create numberOfAliveMembers() in Team returning the number of members that are alive.
            - Create aliveMembers() in Team returning the members that are alive
- Create chooseAliveMember() in Team, getting a member that is alive (Optional). (edited)*/

    public int numberOfAliveMembers() {
        return (int) heroeslist.stream()   //(int) - cast from long to int
                .filter(hero -> hero.isAlive())
                .count();
    }

    public List<AbstractHero> aliveMembers() {
        return heroeslist.stream()
                .filter(hero -> hero.isAlive())
                .collect(Collectors.toList()); //Collect this stream again and collect to list of abstract hero ho are alive
    }

    public Optional<AbstractHero> chooseAliveMember() {
        return heroeslist.stream()
                .filter(hero -> hero.isAlive())
                .findAny();             //Finde any is find object
    }

    public static Team getTeamOf(int number, TeamType teamType) {
        Team newTeam = new Team(teamType);
        for (int i = 0; i < number; i++) {
            boolean isHero = new Random().nextBoolean();
            int health = new Random().nextInt(51) + 100;
            int attack = new Random().nextInt(51) + 100;
            int defence = new Random().nextInt(100) + 100;
            String name = "";
            if (isHero) {
                name = teamType + " " + heroNames[new Random().nextInt(heroNames.length)] + "" + suffixes[new Random().nextInt(suffixes.length)];
            } else {
                name = teamType + " " + villainNames[new Random().nextInt(villainNames.length)] + "" + suffixes[new Random().nextInt(suffixes.length)];
            }


            AbstractHero hero = HeroCreator.createHero(isHero, name, new HeroStatistics(health, attack, defence), teamType);
            try {
                newTeam.addHeroToTeam(hero);
            } catch (InvalidHeroTeamException e) {
                e.printStackTrace();
            }
        }
        return newTeam;
    }


    @Override
    public String toString() {

        String text = "Team: " + team + "\n";

        for (AbstractHero h : heroeslist) {
            if (h.equals(this.teamLeader)) {
                text += h.getName() + " [leader]" + "\n";
            } else {
                text += h.getName() + "\n";
            }
        }
        return text;
    }

    private int timesBuffed = 0;

    public void increaseTeamPowerWithAdditionalBuff() throws InvalidHeroTeamException {

        if (timesBuffed == 0) {
            for (AbstractHero character : heroeslist) {
                if (character instanceof SuperHero) {
                    character.getStats().addToDefense(10);

                }
                if (character instanceof Villain) {
                    character.getStats().addToHealth(10);
                }
            }
        } else {

            throw new InvalidHeroTeamException(this);
        }
        timesBuffed++;

    }

    @Override
    public int compareTo(Team otherTeam) {
        return (int) (this.getTeamPower() - otherTeam.getTeamPower());
    }

    private void updateTeamSide() {
        double vilainhero = 0;
        double superhero = 0;

        for (AbstractHero hero : heroeslist) {
            if (hero instanceof Villain) {
                vilainhero = vilainhero + hero.getPower();
            }
            if (hero instanceof SuperHero) {
                superhero = superhero + hero.getPower();
            }
        }
        if (vilainhero < superhero) {
            setSide(Side.GOOD);
        }
        if (vilainhero > superhero) {
            setSide(Side.EVIL);
        }
        if (vilainhero == superhero) {
            setSide(Side.UNKNOWN);
        }

    }
//    b Add a private AbstractHero teamLeader field to the Team class, the value of this field should be set to the findTeamLeader () (Form with the highest strength) method, which you will call when adding the hero to the team;
//Add getter to the teamLeader field.
}