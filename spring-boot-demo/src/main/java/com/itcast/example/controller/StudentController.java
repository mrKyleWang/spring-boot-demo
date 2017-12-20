package com.itcast.example.controller;

import com.itcast.example.entity.Student;
import com.itcast.example.repository.StudentRepository;
import com.itcast.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    protected StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    /**
     * 显示学生列表
     *
     * @return
     */
    @GetMapping("/student")
    public List<Student> studentList() {
        return studentRepository.findAll();
    }

    /**
     * 添加学生
     *
     * @return
     */
    @PostMapping("/student")
    public Student studentAdd(@Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return studentRepository.save(student);
    }

    /**
     * 通过id查找学生
     *
     * @param sid
     * @return
     */
    @GetMapping("/student/{sid}")
    public Student studentFindOne(@PathVariable("sid") Integer sid) {
        return studentRepository.findOne(sid);
    }


    /**
     * 更新学生
     *
     * @param sid
     * @param sname
     * @param sex
     * @param age
     * @return
     */
    @PutMapping("/student/{sid}")
    public Student studentUpdate(@PathVariable("sid") Integer sid,
                                 @RequestParam String sname,
                                 @RequestParam String sex,
                                 @RequestParam Integer age) {
        Student student = new Student();
        student.setSid(sid);
        student.setSname(sname);
        student.setAge(age);
        student.setSex(sex);
        return studentRepository.save(student);
    }

    /**
     * 删除学生
     *
     * @param sid
     */
    @DeleteMapping("/student/{sid}")
    public void studentDelete(@PathVariable("sid") Integer sid) {
        studentRepository.delete(sid);
    }


    @PostMapping("student/two")
    public void studentTwo() {
        studentService.insertTwo();
    }
}
