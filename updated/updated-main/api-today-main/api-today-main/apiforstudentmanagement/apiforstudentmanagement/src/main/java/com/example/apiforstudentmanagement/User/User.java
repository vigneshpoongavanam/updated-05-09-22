package com.example.apiforstudentmanagement.User;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name  = "tbl_user")
public class User {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(nullable = false,unique = true)
    @NotEmpty(message = "email should not be empty")
    @Email(message = "It is not a valid user id")
    private String email;
    @NotEmpty(message = "password should not be empty")
    @Size(min=6,message = "The size of the password should be min of 6 in length")
    private String password;
    @NotEmpty(message = "first name should not be empty")
    @Size(min = 4 , message = "firstname should be min of 4 in length")
    private String firstName;
    @NotEmpty(message="last name should not be empty")
    @Size(min=3 , message ="last name size should be min of 3 in length")
    private String lastName;

    private boolean isActive= true;
    private boolean isDeleted= false;



    public User() {
    }

    public User(Long id, String email, String password, String firstName, String lastName, boolean isActive, boolean isDeleted) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
