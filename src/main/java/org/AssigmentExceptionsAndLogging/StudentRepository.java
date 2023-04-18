package org.AssigmentExceptionsAndLogging;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    List<Student> studentList = new ArrayList<>();

    LocalDate currentYear = LocalDate.now();


    public void addStudent(Student student) throws ValidationException {

        if (student == null) {
            throw new ValidationException("Student can't be null.");
        }
        if (student.getDateOfBirth() < 1900 || student.getDateOfBirth() > currentYear.getYear()) {
            throw new ValidationException("Date of birth needs to be between 1900 and 2023.");
        }
        if (student.getFirstName() == null || student.getLastName() == null) {
            throw new ValidationException("First name or last name can't be null.");
        }
        if (student.getFirstName().equalsIgnoreCase("") ||
                student.getLastName().equalsIgnoreCase("")) {
            throw new ValidationException("First name or last name can't be empty.");
        }

        if ((!student.getGender().equalsIgnoreCase("male")) &&
                ((!student.getGender().equalsIgnoreCase("female")))) {
            throw new ValidationException("Gender can only be male of female.");
        }


        studentList.add(student);

    }

    public void deleteStudent(String id) throws ValidationException {

        if (id.equalsIgnoreCase("")) {
            throw new ValidationException("Student's ID is empty.");
        }


        for (int i = 0; i < studentList.size(); i++) {
            if (id.equalsIgnoreCase(studentList.get(i).getId())) {
                studentList.remove(studentList.get(i));
            }
        }
    }

    public List<Student> retrieveAllStudents(int age) throws ValidationException {

        List<Student> studentsWithSpecificAge = new ArrayList<>();

        if (age <= 0) {
            throw new ValidationException("Age must be greater than 0.");
        }

        for (Student student : studentList) {
            if (student.calculateAge() == age) {
                studentsWithSpecificAge.add(student);
            }

        }

        System.out.println("Students with the age " + age + ":");
        studentsWithSpecificAge.forEach(System.out::println);
        return studentsWithSpecificAge;

    }

    public List<Student> listStudent() throws ValidationException {

        studentList.sort(new DateOfBirthComparator());
        for (Student student : studentList) {
            if (student == null) {
                throw new ValidationException("Input is empty.");
            }

        }
        studentList.sort(new DateOfBirthComparator());
        studentList.forEach(System.out::println);

        return studentList;
    }


}