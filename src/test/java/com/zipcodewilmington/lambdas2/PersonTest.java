package com.zipcodewilmington.lambdas2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonTest {

    private Person giles;
    private Person chris;
    private Person jimmy;
    private Person nicole;
    List<Person> persons;

    @Before
    public void setUp(){
        giles = new Person("Giles", LocalDate.of(1995, 5, 15),
                Person.Sex.MALE, "Giles@email.com");
        chris = new Person("Chris", LocalDate.of(1992, 2, 6),
                Person.Sex.MALE, "Chris@email.com");
        jimmy = new Person("Jimmy", LocalDate.of(1999, 3, 2),
                Person.Sex.MALE, "Jimmy@email.com");
        nicole = new Person("Nicole", LocalDate.of(1990, 2, 18),
                Person.Sex.FEMALE, "Nicole@gmail.com");
        persons = new ArrayList<>(Arrays.asList(giles, chris, jimmy, nicole));
    }

    @Test
    public void testAgeChris(){
        int expected = 28;
        int actual = chris.getAge();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAgeGiles(){
        int expected = 24;
        int actual = giles.getAge();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAgeJimmy(){
        int expected = 21;
        int actual = jimmy.getAge();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAgeNicole(){
        int expeted = 30;
        int actual = nicole.getAge();
        Assert.assertEquals(expeted, actual);
    }

    @Test
    public void testPrintPerson(){
        chris.printPerson();
    }

    @Test
    public void testPrintPersonOlderThan(){
        //Should only print Chris and Nicole
        Person.printPersonsOlderThan(persons, 25);
    }

    @Test
    public void testPrintPersonsWithinAgeRange(){
        //Should only print Giles
        Person.printPersonsWithinAgeRange(persons, 24, 28);
    }

}
