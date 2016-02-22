package com.softdesign.school.data.storage.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

@Table(name = "Teams")
public class Team extends Model {

    @Column(name = "name")
    public String name;

    public Team(String name) {
        this.name = name;
    }

    public  Team(){
        super();
    }

    public String getName() {
        return name;
    }
    public List<User> users() {
        return getMany(User.class, "team");
    }

    public static Team getTeamByName(String name) {
        return new Select()
                .from(Team.class)
                .where("name = ?", name)
                .executeSingle();
    }

    public static List<String> getAllNames() {
        List<Team> teams = getDataListTeams();
        List<String> names = new ArrayList<String>(teams.size());
        for (Team t : teams) {
            names.add(t.name);
        }
        return names;
    }


    public static List<Team> getDataListTeams() {
        return new Select()
                .from(Team.class)
                .orderBy("name ASC")
                .execute();
    }

}
