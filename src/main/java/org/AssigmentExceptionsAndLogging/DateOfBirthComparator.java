package org.AssigmentExceptionsAndLogging;

import java.util.Comparator;

public class DateOfBirthComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {

        if (o1.getDateOfBirth() < o2.getDateOfBirth()) {
            return -1;
        } else if (o1.getDateOfBirth() > o2.getDateOfBirth()) {
            return 1;

        } else {
            return 0;
        }
    }
}
