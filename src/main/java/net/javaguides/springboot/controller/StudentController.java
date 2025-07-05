package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getstudent(){
        Student student = new Student(
                "Gohil","Revin",1
        );
        return student;
    }

    @GetMapping("students")
    public  List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Gohil","Revin",1));
        students.add(new Student("Gohil1","Revin1",2));
        students.add(new Student("Gohil2","Revin2",3));
        students.add(new Student("Gohil3","Revin3",4));
        return students;
    }

    //spring boot rest api with path variable
    //{id} - URI Template variable
    @GetMapping("students/{id}/{fname}")
    public Student studentPathVariable(@PathVariable("id") int stid, @PathVariable String fname)
    {
        return new Student("gohil",fname,stid);
    }

    //Rest api with request param
    //localhost:8080/students/query?id=1&fname=revin
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id, @RequestParam String fname)
    {
        return new Student("gohil",fname,id);
    }
}
