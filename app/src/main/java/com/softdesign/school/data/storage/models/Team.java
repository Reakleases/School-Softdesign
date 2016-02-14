package com.softdesign.school.data.storage.models;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Teams")
public class Team extends Model {

    @Column(name = "name")
    public String name;



}
