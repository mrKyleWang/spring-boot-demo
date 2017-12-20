package com.itcast.example.service;

import com.itcast.example.repository.StudentRepository;
import com.itcast.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public void insertTwo(){
        Student student1 = new Student();
        student1.setSname("Jack");
        student1.setSex("male");
        student1.setAge(18);
        studentRepository.save(student1);

        Student student2 = new Student();
        student2.setSname("Rose");
        student2.setSex("female");
        student2.setAge(20);
        studentRepository.save(student2);


    }

}
