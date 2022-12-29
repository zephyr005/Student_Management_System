package com.AccioJob.Student_Management_System;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository //Tell JAVA that this is the Repository(i.e. DataBase)
public class StudentRepository {
    HashMap<Integer,Student> studentDB = new HashMap<>();

    String addStudentToDB(Student student){
        int key = student.id;
        studentDB.put(key,student);
        return "Successfully Added";
    }

    Student getStudentByIDFromDB(int id){
        if(studentDB.containsKey(id)){
            return studentDB.get(id);
        }
        else{
            return null;
        }
    }

    Student getStudentByNameFromDB(String searchName){
        for(Student student : studentDB.values()){
            if(student.name.equals(searchName)){
                return student;
            }
        }
        return null;
    }

    Student updateStudentInDB(Student student){
        int key = student.id;
        studentDB.put(key,student);
        return student;
    }
}
