package org.AssigmentExceptionsAndLogging;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void givenDateOfBirthAndCurrentYearCalculateAge() {

        int currentYear = 2018;
        Student student = new Student("John", "Wick", 1986, "male", "185011333");

        int age = currentYear - student.getDateOfBirth();


        assertEquals(32,age);
    }
}