package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    //Spring boot rest API that handles HTTP POST request - creating new resource
    // @postmapping annotation and @requestbody annotation
    // requestbody annotation will convert json in java object
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getFname());
        System.out.println(student.getLname());
        System.out.println(student.getId());
        return student;
    }

    //Spring boot REST API that handles HTTP PUT Request - updating existing resource
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id)
    {
        System.out.println(student.getFname());
        System.out.println(student.getLname());
        System.out.println("ID Value is");
        System.out.println(id);
        return student;
    }


    //Spring boot REST API that handles HTTP DELETE Request - delete existing resource
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable int id)
    {
        return "User with id " + id + " is deleted";
    }
}
