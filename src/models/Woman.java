package models;

import interfaces.Person;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Created by laj on 18-3-2016.
 */
public class Woman implements Person {
    @Override
    // Off course they always lie about this its just a constant
    //It's actually 23
    //And women are forever young
    public int age() {
        return 23;
    }

    @Override
    // Yeah woman can't drive
    // Men lie as well
    public String Drive() {
        //throw new NotImplementedException();
        return "Most amazing drivers are women";
    }


}
