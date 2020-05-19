package com.student;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.print("Number of students to enroll: ");
        int num = scn.nextInt();

        Student[] students = new Student[num];
        for(int i = 0 ; i < num ; i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].payTution();

            System.out.println(students[i].toString());
        }
    }
}
