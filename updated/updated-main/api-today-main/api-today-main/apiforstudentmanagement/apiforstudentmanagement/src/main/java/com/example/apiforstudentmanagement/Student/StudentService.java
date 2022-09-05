package com.example.apiforstudentmanagement.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student adduser(Student student) {

        student = studentRepository.save(student);
        return student;
    }
    public List<Student> getalluser() {

        return studentRepository.findAll();
    }
    public Student getuserById(Long id) {
        return studentRepository.findById(id).get();
    }
    public void deleteUserById(Long id) {
        boolean exists =studentRepository.existsById(id);
        {
            if(!exists)
            {
                throw  new IllegalStateException("student with id" + id + "does not exists");
            }
        }
        studentRepository.deleteById(id);
    }

    public Optional<Student> method(String email){
        Optional<Student> mail =studentRepository.findByEmail(email);
        return mail;
    }


    public Student createUser(Student student) {
        return  studentRepository.save(student);
    }


    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student= studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student with id" + id +"does not exist"));
        if(name!= null && name.length()>0 )
        {
            student.setFirstName(name);
        }
        if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email))
        {
            Optional<Student> userOptional = studentRepository.findByEmail(email);
            if(userOptional.isPresent())
            {
                throw new IllegalStateException("email is taken");
            }
            student.setEmail(email);
        }


    }
}




