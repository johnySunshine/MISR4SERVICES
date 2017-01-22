package com.soecode.lyf.entity;

import java.util.List;

/**
 * Created by Fantasy on 2017/1/22.
 */
public class CastAndCrew {
    private int id;
    private List<Person> persons;
    private FictionalCharacter fictionalCharacter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public FictionalCharacter getFictionalCharacter() {
        return fictionalCharacter;
    }

    public void setFictionalCharacter(FictionalCharacter fictionalCharacter) {
        this.fictionalCharacter = fictionalCharacter;
    }
}
