package service;

import java.io.*;
import java.util.*;
import model.Student;

public class FileHandler {

    private static final String FILE_NAME = "students.txt";

    public static void saveStudents(List<Student> students) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));

            for(Student s : students){
                writer.write(s.id + "," + s.name + "," + s.age + "," + s.course);
                writer.newLine();
            }

            writer.close();

        } catch(Exception e){
            System.out.println("Error saving data");
        }
    }
    public static List<Student> loadStudents(){

        List<Student> students = new ArrayList<>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while((line = reader.readLine()) != null){

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];

                students.add(new Student(id, name, age, course));
            }

            reader.close();

        } catch(Exception e){
            System.out.println("No previous data found");
        }

        return students;
    }
	public static Collection<? extends Student> loadStudents1() {
		// TODO Auto-generated method stub
		return null;
	}
}