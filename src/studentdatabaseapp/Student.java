package studentdatabaseapp;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String firstName, lastName, studentID;
    private List<String> courses = new LinkedList<>();
    private int balance = 0, gradeYear;
    private static final int costPerCourse = 600;
    private static int id = 1000;

    public Student(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        firstName = in.nextLine();
        System.out.print("Enter student last name: ");
        lastName = in.nextLine();
        System.out.print("Enter student grade year: ");
        gradeYear = in.nextInt();
        setStudentID();
    }

    private void setStudentID(){
        studentID = gradeYear + "" + id++;
    }

    public void enroll(){
        while(true) {
            System.out.println("Enter course to enroll (enter Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses.add(course);
                balance += costPerCourse;
            } else break;
        }
    }

    public void viewBalance(){
        System.out.println("Current Balance: " + balance);
    }

    public void payTuition(){
        System.out.println("Enter the amount to pay: ");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        balance -= payment;
        System.out.println("Payment of " + payment + " received.");
        viewBalance();
    }

    public String toString(){
        return "DISPLAY name: " + firstName + " " + lastName
                + "\nStudnet ID: " + studentID
                + "\nGrade Level: " + gradeYear
                + "\nCourses Enrolled: \n" + courses.toString()
                + "\nBalance: " + balance;
    }
}
