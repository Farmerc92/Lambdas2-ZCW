package com.zipcodewilmington.lambdas2;

public class CheckFemale implements CheckPerson {
    @Override
    public boolean test(Person p) {
        return p.getGender().equals(Person.Sex.FEMALE);
    }
}
