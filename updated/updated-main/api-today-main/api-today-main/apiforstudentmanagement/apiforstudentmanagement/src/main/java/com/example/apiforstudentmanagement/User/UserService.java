package com.example.apiforstudentmanagement.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    PasswordEncoder passwordEncoder;

    public UserService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    public User adduser(User user) {

        String encodedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user = userRepository.save(user);
        return user;
    }


    public List getAllUser() {
        List<User> list = userRepository.findAll();
        List<String> st = new ArrayList<>();
        st.add("No User Found");
        if (list.isEmpty()) {
            return st;
        } else {
            return list;
        }
    }

    public User getuserById(Long id) {
        return userRepository.findById(id).get();
    }

    public void deleteUserById(Long id) {
        boolean exists = userRepository.existsById(id);
        {
            if (!exists) {
                throw new IllegalStateException("student with id" + id + "does not exists");
            }
        }
        userRepository.deleteById(id);
    }


    public Optional<User> method(String email) {
        Optional<User> mail = userRepository.findByEmail(email);
        return mail;
    }

    public Object Login(LoginRequest loginRequest) {

        return userRepository.AdminLogin(loginRequest.getEmail(), loginRequest.getPassword());
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    @Transactional
    public void updateStudent(Long id, String name, String email, String password) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id" + id + "does not exist"));
        if (name != null && name.length() > 0) {
            user.setFirstName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)) {
            Optional<User> userOptional = userRepository.findByEmail(email);
            if (userOptional.isPresent()) {
                throw new IllegalStateException("email is taken");
            }
            user.setEmail(email);
        }
        if (password != null && password.length() > 5) {
            String encodedPassword = this.passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            user = userRepository.save(user);
        }
    }

    public List<User> searchUsers(String query) {
        List<User> users = userRepository.searchUsers(query);
        return users;
    }


}



   