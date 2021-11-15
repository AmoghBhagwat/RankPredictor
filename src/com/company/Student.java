package com.company;

import java.util.Arrays;

public class Student implements Comparable {
    private double[] percentages = new double[3];
    private String rollno;

    public Student(String rollno) {
        this.rollno = rollno;
    }

    public String getRollno() {
        return rollno;
    }

    public void setPercentage(int i, double marks) {
        percentages[i] = marks;
    }

    public double getPercentage() {
        return percentages[0] * 0.2 + percentages[1] * 0.4 + percentages[2] * 0.4;
    }

    @Override
    public String toString() {
        return "Student{" +
                "percentages=" + Arrays.toString(percentages) +
                ", rollno='" + rollno + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student) o;
        double difference = getPercentage() - s.getPercentage();

        if (difference < 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
