package models;

import interfaces.IPerson;

public class Man extends BasePerson implements IPerson {
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
