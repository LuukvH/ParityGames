package models;

import interfaces.Person;

import java.util.List;

public class Man implements Person {
    @Override
    //No matter their age, their mental age is remains at 12
    public int age() {
        return 12;
    }

    @Override
    // They always think the best of themselbed
    public String Drive() {
        return "They think they drive better. They are wrong";
    }


}
