package org.AssigmentExceptionsAndLogging;

import java.util.Comparator;

public class DateOfBirthComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {


        return Integer.compare(o1.getDateOfBirth(), o2.getDateOfBirth());
    }
}
