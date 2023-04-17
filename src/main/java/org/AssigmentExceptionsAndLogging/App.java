package org.AssigmentExceptionsAndLogging;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws ValidationException {


        StudentRepository myRepository = new StudentRepository();

        Student student1 = new Student("John", "Wick", LocalDate.of(1986,11,2), "male", "185011333");
        Student student2 = new Student("Alisa", "Finley", LocalDate.of(1980,2,2), "female", "185011444");
        Student student3 = new Student("Jenna", "Rock", LocalDate.of(2000,5,5), "female", "185011555");
        Student student4 = new Student("Marshall", "Matters", LocalDate.of(1966,6,6), "Male", "185011777");
        Student student5 = new Student("Steven", "Seagate", LocalDate.of(1995,10,10), "Male", "185011888");
        Student student6 = new Student("Arnold", "Bing", LocalDate.of(2000,11,11), "Male", "185011999");

        myRepository.addStudent(student1);
        myRepository.addStudent(student2);
        myRepository.addStudent(student3);
        myRepository.addStudent(student4);
        myRepository.addStudent(student5);
        myRepository.addStudent(student6);


        myRepository.listStudent();
        System.out.println();
        myRepository.deleteStudent("185011444");
        myRepository.listStudent();

        myRepository.retrieveAllStudents(23);


        try {
            myRepository.addStudent(new Student(null, "Wick", LocalDate.of(1986,11,2), "male", "185011333"));
        } catch (ValidationException validationException) {
            System.out.println("Please input a valid student. " + validationException.getMessage());

        }
        try {
            myRepository.addStudent(new Student("John", "Wick", LocalDate.of(1800,11,2), "male", "185011333"));
        } catch (ValidationException validationException) {
            System.out.println("Please input a valid date of birth. " + validationException.getMessage());

        }
        try {
            myRepository.addStudent(new Student("", "Wick", LocalDate.of(1986,11,2), "male", "185011333"));
        } catch (ValidationException validationException) {
            System.out.println("Please enter a valid name. " + validationException.getMessage());

        }
        try {
            myRepository.addStudent(new Student("John", "", LocalDate.of(1986,11,2), "male", "185011333"));
        } catch (ValidationException validationException) {
            System.out.println("Please enter a valid name. " + validationException.getMessage());

        }
        try {
            myRepository.addStudent(new Student("John", "Wick", LocalDate.of(1986,11,2), "notFemale", "185011333"));
        } catch (ValidationException validationException) {
            System.out.println("Please enter a valid gender. " + validationException.getMessage());

        }
        try {
            myRepository.deleteStudent("");

        } catch (ValidationException validationException) {
            System.out.println("Please enter a valid ID. " + validationException.getMessage());

        }
        try {
            myRepository.retrieveAllStudents(-2);
        } catch (ValidationException validationException) {
            System.out.println("You have entered an invalid age. " + validationException.getMessage());
        }



    }
}
