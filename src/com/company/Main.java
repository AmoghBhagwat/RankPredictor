package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        readStudents();
        readCSV("C:\\Users\\amogh\\IdeaProjects\\RankPredictor\\src\\com\\company\\percentage1.csv", 0);
        readCSV("C:\\Users\\amogh\\IdeaProjects\\RankPredictor\\src\\com\\company\\percentage2.csv", 1);
        readCSV("C:\\Users\\amogh\\IdeaProjects\\RankPredictor\\src\\com\\company\\percentage3.csv", 2);

        Collections.sort(students);

        for (Student student : students) {
            System.out.println(students.indexOf(student) + 1 + " " + student.getRollno());
        }
    }

    public static void readStudents() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("C:\\Users\\amogh\\IdeaProjects\\RankPredictor\\src\\com\\company\\students.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNext()) {
            Student student = new Student(scanner.next());
            students.add(student);
        }
    }

    public static void readCSV(String path, int i) {

        Scanner scanner = null;
        Scanner valueScanner;

        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            int index = 0;
            valueScanner = new Scanner(scanner.nextLine());
            valueScanner.useDelimiter(",");

            Student student = null;

            while (valueScanner.hasNext()) {
                if (index == 0) {
                    String data = valueScanner.next();
                    student = findStudent(data);
                    if (student == null) break;
                } else if (index == 1) {
                    String marks = valueScanner.next();
                    double marksDouble = Double.parseDouble(marks);

                    if (i == 0 || i == 2) {
                        student.setPercentage(i, marksDouble / 300);
                    } else {
                        student.setPercentage(i, marksDouble / 198);
                    }
                }
                index++;
            }
        }
    }

    public static Student findStudent(String name) {
        for (Student student : students) {
            if (student.getRollno().equals(name)) {
                return student;
            }
        }

        return null;
    }
}
