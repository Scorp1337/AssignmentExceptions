package org.AssigmentExceptionsAndLogging;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void givenDateOfBirthAndCurrentYearCalculateAge() {


        Student student = new Student("John", "Wick", LocalDate.of(1986,11,2), "male", "185011333");

        int age = student.calculateAge();


        assertEquals(32,age);
    }
}