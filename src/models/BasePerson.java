package models;

import interfaces.IPerson;

/**
 * Created by laj on 21-3-2016.
 */
public class BasePerson {

    public static void Compare(IPerson p1, IPerson p2) {

        if ((p1 instanceof Man && p2 instanceof Man)){
            System.out.println("Objects are incomparable infinite awesomeness exception.");
        }

        if ((p1 instanceof Man && p2 instanceof Woman) || (p1 instanceof Man && p2 instanceof Woman) ){
            System.out.println("The woman is not an object. Cannot find means to compare, too good to understand.");
        }

        if ((p1 instanceof Woman && p2 instanceof Woman)){
            System.out.println("Both are equally annoyed by men.");
        }


    }
}
