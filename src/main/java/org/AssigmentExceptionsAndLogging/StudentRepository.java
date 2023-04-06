package org.AssigmentExceptionsAndLogging;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    List<Student> studentList = new ArrayList<>();

    private final int currentYear = 2018;

    public void addStudent(Student student) throws ValidationException {

        if (student.getDateOfBirth() < 1900 || student.getDateOfBirth() > currentYear) {
            throw new ValidationException("Date of birth needs to be between 1900 and 2018.");
        }
        if (student.getFirstName() == null || student.getLastName() == null) {
            throw new ValidationException("First name or last name can't null.");
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

    public void retrieveAllStudents(Integer age) throws ValidationException {

        if (age <= 0) {
            throw new ValidationException("Age must be greater than 0.");
        }

        for (Student student : studentList) {
            if (student.calculateAge() == age) {
                System.out.println(student.getFirstName() + " " + student.getLastName() + " - age "
                        + student.calculateAge());
            }
        }

    }

    public void listStudent() {

        studentList.sort(new DateOfBirthComparator());
        for (Student student : studentList) {
            System.out.println(student);
        }

    }

}