package org.AssigmentExceptionsAndLogging;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws ValidationException {


        StudentRepository myRepository = new StudentRepository();

        Student student1 = new Student("John", "Wick", 1986, "male", "185011333");
        Student student2 = new Student("Alisa", "Finley", 1980, "female", "185011444");
        Student student3 = new Student("Jenna", "Rock", 2000, "female", "185011555");
        Student student4 = new Student("Marshall", "Matters", 1994, "Male", "185011777");
        Student student5 = new Student("Steven", "Seagate", 1995, "Male", "185011888");
        Student student6 = new Student("Arnold", "Bing", 1995, "Male", "185011999");

        myRepository.addStudent(student1);
        myRepository.addStudent(student2);
        myRepository.addStudent(student3);
        myRepository.addStudent(student4);
        myRepository.addStudent(student5);
        myRepository.addStudent(student6);


        myRepository.listStudent();
        myRepository.retrieveAllStudents(23);
        myRepository.deleteStudent("185011444");
        myRepository.listStudent();

        try {
            myRepository.addStudent(new Student(null, "Wick", 1986, "male", "185011333"));
        } catch (ValidationException validationException) {
            System.out.println("Please input a valid student. " + validationException.getMessage());
            System.out.println("=====================================================================================");
        }
        try {
            myRepository.addStudent(new Student("John", "Wick", 1800, "male", "185011333"));
        } catch (ValidationException validationException) {
            System.out.println("Please input a valid date of birth. " + validationException.getMessage());
            System.out.println("=====================================================================================");
        }
        try {
            myRepository.addStudent(new Student("", "Wick", 1986, "male", "185011333"));
        } catch (ValidationException validationException) {
            System.out.println("Please enter a valid name " + validationException.getMessage());
            System.out.println("=====================================================================================");
        }
        try {
            myRepository.addStudent(new Student("John", "", 1986, "male", "185011333"));
        } catch (ValidationException validationException) {
            System.out.println("Please enter a valid name " + validationException.getMessage());
            System.out.println("=====================================================================================");
        }
        try {
            myRepository.addStudent(new Student("John", "Wick", 1986,
                    "notFemale", "185011333"));
        } catch (ValidationException validationException) {
            System.out.println("Please enter a valid gender " + validationException.getMessage());
            System.out.println("=====================================================================================");
        }
        try {
            myRepository.deleteStudent("");

        } catch (ValidationException validationException) {
            System.out.println("Please enter a valid ID. " + validationException.getMessage());
            System.out.println("=====================================================================================");
        }
        try {
            myRepository.retrieveAllStudents(-2);
        } catch (ValidationException validationException) {
            System.out.println("You have entered an invalid age. " + validationException.getMessage());
        }
        try {
            myRepository.retrieveAllStudents(123);
        } catch (ValidationException validationException) {
            System.out.println("You have entered an invalid age. " + validationException.getMessage());


        }
    }
}
