package com.softdesign.school.data.storage.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "Users")
public class User extends Model {
    @Column(name = "firstName")
    public String firstName;

    @Column(name = "lastName")
    public String lastName;
    @Column(name = "team")
    public Team team;

    public User() {
        super();
    }

    public User(String firstName, String lastName, Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Team getTeam() {
        return team;
    }

    public static List<User> getDataListUsers() {
        return new Select()
                .from(User.class)
                .execute();
    }
}
