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
    public int age() {
        return 22;
    }

    @Override
    // Yeah woman can't drive
    public void Drive() {
        throw new NotImplementedException();
    }


}
