package org.AssigmentExceptionsAndLogging;

public class Student {

    private String firstName;
    private String lastName;
    private int dateOfBirth;
    private String gender;
    private String id;

    private final int currentYear = 2018;

    public Student(String firstName, String lastName, int dateOfBirth, String gender, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
    }


    public int calculateAge() {

        return currentYear - this.dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public int getDateOfBirth() {
        return dateOfBirth;
    }


    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "[ " + firstName + ", " +
                lastName + ", dateOfBirth: " +
                dateOfBirth + ",Gender: " +
                gender + ",ID: "
                + id +
                ']';
    }
}
