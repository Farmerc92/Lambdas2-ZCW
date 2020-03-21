package com.zipcodewilmington.lambdas2;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person implements CheckPerson{

    @Override
    public boolean test(Person p) {
        return false;
    }

    public enum Sex {
        MALE, FEMALE
    }

    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;

    public Person(String name, LocalDate birthday, Sex gender, String email){
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = email;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        Period diff = Period.between(birthday, now);
        return diff.getYears();
    }

    public void printPerson() {
        String output = "Name: "+this.name+" Birthdate: "+this.birthday+" Gender: "+this.gender+" Email: "+emailAddress;
        System.out.println(output);
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
    public static void main(String... args){
        Person giles = new Person("Giles", LocalDate.of(1995, 5, 15),
                Person.Sex.MALE, "Giles@email.com");
        Person chris = new Person("Chris", LocalDate.of(1992, 2, 6),
                Person.Sex.MALE, "Chris@email.com");
        Person jimmy = new Person("Jimmy", LocalDate.of(1999, 3, 2),
                Person.Sex.MALE, "Jimmy@email.com");
        Person nicole = new Person("Nicole", LocalDate.of(1990, 2, 18),
                Person.Sex.FEMALE, "Nicole@gmail.com");
        List<Person> persons = new ArrayList<>(Arrays.asList(giles, chris, jimmy, nicole));
        printPersons(persons, person -> person.getGender().equals(Sex.FEMALE));
    }
}
