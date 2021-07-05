package com.example.firstproject;

public class Team {

    int image_team;
    String heroname;
    String heroteam;
    public Team()
    {

    }
    public Team(int image_team,String heroname,String heroteam)
    {
        this.image_team=image_team;
        this.heroname=heroname;
        this.heroteam=heroteam;
    }


    public int getImage_team() {
        return image_team;
    }

    public void setImage_team(int image_team) {
        this.image_team = image_team;
    }

    public String getHeroname() {
        return heroname;
    }

    public void setHeroname(String heroname) {
        this.heroname = heroname;
    }

    public String getHeroteam() {
        return heroteam;
    }

    public void setHeroteam(String heroteam) {
        this.heroteam = heroteam;
    }



}
