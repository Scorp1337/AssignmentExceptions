package org.AssigmentExceptionsAndLogging;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentRepositoryTest {

    @Test
    void givenZeroStudentsAddStudent() {

        StudentRepository repository = new StudentRepository();
        Student student = new Student("John", "Wick", 1986, "male", "185011333");

        assertEquals(0, repository.studentList.size());

    }

    @Test
    void givenOneStudentAddStudent() throws ValidationException {

        StudentRepository repository = new StudentRepository();
        Student student = new Student("John", "Wick", 1986, "male", "185011333");

        repository.addStudent(student);

        assertEquals(1, repository.studentList.size());

    }

    @Test
    void givenTwoStudentAddStudent() throws ValidationException {

        StudentRepository repository = new StudentRepository();
        Student student = new Student("John", "Wick", 1986, "male", "185011333");
        Student student2 = new Student("Alisa", "Finley", 1980, "female", "185011444");
        repository.addStudent(student);
        repository.addStudent(student2);

        assertEquals(2, repository.studentList.size());
    }

    @Test
    void deleteStudent() throws ValidationException {
        StudentRepository repository = new StudentRepository();
        Student student = new Student("John", "Wick", 1986, "male", "185011333");
        Student student2 = new Student("Alisa", "Finley", 1980, "female", "185011444");

        repository.addStudent(student);
        repository.addStudent(student2);

        repository.deleteStudent(student.getId());

        assertEquals(1, repository.studentList.size());

    }

    @Test
    void givenAnAgeRetrieveAllStudentsWithThatAge() throws ValidationException {
        StudentRepository myRepository = new StudentRepository();

        Student student1 = new Student("John", "Wick", 1986, "male", "185011333");
        Student student2 = new Student("Steven", "Seagate", 1995, "Male", "185011888");
        Student student3 = new Student("Arnold", "Bing", 1995, "Male", "185011999");

        myRepository.addStudent(student1);
        myRepository.addStudent(student2);
        myRepository.addStudent(student3);

        int ageStudent2 = student2.calculateAge();
        int ageStudent3 = student3.calculateAge();

        assertEquals(23, ageStudent2);
        assertEquals(23, ageStudent3);

    }

    @Test
    void listStudent() throws ValidationException {

        StudentRepository myRepository = new StudentRepository();

        Student student1 = new Student("John", "Wick", 1986, "male", "185011333");
        Student student2 = new Student("Alisa", "Finley", 1980, "female", "185011444");
        Student student3 = new Student("Jenna", "Rock", 2000, "female", "185011555");
        Student student4 = new Student("Marshall", "Matters", 1994, "Male", "185011777");

        myRepository.addStudent(student1);
        myRepository.addStudent(student2);
        myRepository.addStudent(student3);
        myRepository.addStudent(student4);

        List<Student> myTestList = myRepository.studentList;
        myTestList.sort(new DateOfBirthComparator());

        assertEquals(myRepository.studentList,myTestList);

    }
}