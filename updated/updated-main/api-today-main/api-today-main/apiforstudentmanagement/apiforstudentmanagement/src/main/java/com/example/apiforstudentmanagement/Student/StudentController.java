package com.example.apiforstudentmanagement.Student;

import com.example.apiforstudentmanagement.User.Login403Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @PostMapping("save")
    public ResponseEntity<Student> adduser(@RequestBody Student student)
    {
        Student userSaved = studentService.adduser(student);
        return new ResponseEntity<Student>(userSaved, HttpStatus.CREATED);
    }

    @GetMapping("allstudent")
    public ResponseEntity<List<Student>> getalluser() {
        List<Student> userList = studentService.getalluser();
        if (userList.isEmpty()) {
            return new ResponseEntity<List<Student>>(userList, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Student>>(userList, HttpStatus.OK);
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<Student> getuserById(@PathVariable Long id)
    {
        Student retriever = studentService.getuserById(id);
        return new ResponseEntity<Student>(retriever,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteuserById(@PathVariable Long id)
    {
        studentService.deleteUserById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }


    @PostMapping(value ="create")
    public ResponseEntity<Object> create(@Valid @RequestBody Student student)
    {
        try
        {
            Optional<Student> log = studentService.method(student.getEmail());
            if(log.isPresent())
            {
                return ResponseEntity.status(403).body(new Login403Error("Email is already present"));
            }

            else {
                Student studentSaved = studentService.adduser(student);
                return ResponseEntity.status(201).body(studentSaved);
            }
        }
        catch(Exception e)
        {
            throw new IllegalStateException(e.getMessage());
        }


    }


    @PutMapping(path = "{id}")
    public void UpdateStudent(
            @PathVariable Long id, @RequestParam(required = false) String name,
            @RequestParam(required = false) String email )
    {
        studentService.updateStudent(id,name,email);
    }




}