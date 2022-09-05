package com.example.apiforstudentmanagement.Student;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "email should not be empty")
    @Email(message = "It is not a valid user id")
    private String email;
    @NotEmpty(message = "first name should not be empty")
    @Size(min = 4 , message = "firstname should be min of 4 in length")
    private String  firstName;
    @NotEmpty(message = "last name should not be empty")
    @Size(min = 4 , message = "lastname should be min of 4 in length")
    private String lastName;

    private Long birthday;
    private boolean isActive=true;
    private boolean isDeleted=false;

    public Student() {
    }

    public Student(Long id, String email, String firstName, String lastName, Long birthday, boolean isActive, boolean isDeleted) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", isActive=" + isActive +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
