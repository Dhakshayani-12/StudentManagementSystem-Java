package service;

import java.util.*;
import model.Student;

public class StudentService {

    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s){
        students.add(s);
        FileHandler.saveStudents(students);
    }

    public void viewStudents(){

        for(Student s : students){
            s.display();
        }
    }

    public void searchStudent(int id){

        boolean found = false;

        for(Student s : students){

            if(s.id == id){
                s.display();
                found = true;
            }
        }

        if(!found){
            System.out.println("Student not found");
        }
    }

    public void deleteStudent(int id){

        Iterator<Student> it = students.iterator();
        boolean found = false;

        while(it.hasNext()){

            Student s = it.next();

            if(s.id == id){
                it.remove();
                found = true;
                System.out.println("Student deleted successfully");
            }
        }

        if(found){
            FileHandler.saveStudents(students);
        }
        else{
            System.out.println("Student not found");
        }
    }

    public void updateStudent(int id, String name, int age, String course){

        boolean found = false;

        for(Student s : students){

            if(s.id == id){

                s.name = name;
                s.age = age;
                s.course = course;

                found = true;
                System.out.println("Student updated successfully");
            }
        }

        if(found){
            FileHandler.saveStudents(students);
        }
        else{
            System.out.println("Student not found");
        }
    }
}