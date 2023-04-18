package org.AssigmentExceptionsAndLogging;

import java.time.LocalDate;

public class Student {

    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final String gender;
    private final String id;

    LocalDate currentYear = LocalDate.now();


    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
    }


    public int calculateAge() {

        return currentYear.getYear() - this.dateOfBirth.getYear();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public int getDateOfBirth() {
        return dateOfBirth.getYear();
    }


    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "[" + firstName + ", " +
                lastName + ", dateOfBirth: " +
                dateOfBirth + ",Gender: " +
                gender + ",ID: "
                + id +
                ']';
    }

}
