package com.softdesign.school.data.storage.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Users")
public class User extends Model {
    @Column(name = "firstName")
    public String firstName;

    @Column(name = "lastName")
    public String lastName;
    @Column (name = "team")
    public String team;
}
