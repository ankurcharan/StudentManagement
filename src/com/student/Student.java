package com.student;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses;
    private int tutionBalance;

    private static int costOfCourse = 600;
    private static int id = 1001;

    public Student () {

        Scanner scn = new Scanner(System.in);

        System.out.print("First Name: ");
        this.firstName = scn.nextLine();

        System.out.print("Last Name: ");
        this.lastName = scn.nextLine();

        System.out.print("1-Freshman\n2-Sophomore\n3-Junior\n4-Senior\nClass Level: ");
        this.gradeYear = scn.nextInt();

        setStudentID();
        this.tutionBalance = 0;
        this.courses = null;

//        System.out.println();
//        System.out.println("Student: " + this.firstName + " " + this.lastName);
//        System.out.println("Year: " + this.gradeYear);
//        System.out.println("ID: " + this.studentID);
//        System.out.println();
        // System.out.println("Courses Enrolled: \n" + this.courses);
    }

    // generate ID
    private void setStudentID() {
        // grade + id
        this.studentID = gradeYear + "" + id;
        id++;
    }

    // enroll in courses
    public void enroll() {

        System.out.println("Enter course to enroll (Q: exit): ");

        Scanner scn = new Scanner(System.in);
        while(true) {

            String course = scn.nextLine();

            if(course.equals("Q")) {
                break;
            }
            else {
                if(this.courses == null) {
                    this.courses = course;
                }
                else {
                    this.courses += "\n" + course;
                }
                this.tutionBalance += costOfCourse;
            }
        }

//        System.out.println("Enrolled: " + this.courses);
//        System.out.println("Tution Balance: " + this.tutionBalance);
    }

    // view balance
    public void viewBalance() {
        System.out.println("Your Balance: " + this.tutionBalance);
    }

    // pay tution
    public void payTution() {

        viewBalance();

        Scanner scn = new Scanner(System.in);
        System.out.print("Amount to pay: ");
        int payment = scn.nextInt();

        if(payment > this.tutionBalance) {
            System.out.println("Payment Unsuccessful. You are paying more amount that required.");
            return;
        }
        this.tutionBalance = this.tutionBalance - payment;
        System.out.println("Thank you for payemt of: " + payment);
        viewBalance();
    }

    // show info
    @Override
    public String toString () {
        return ("Name: " + this.firstName + " " + this.lastName +
                "\nGrade: " + this.gradeYear +
                "\nStudentID: " + this.studentID +
                "\nCourses Enrolled: "  + courses +
                "\nBalance: " + this.tutionBalance);
    }
}
