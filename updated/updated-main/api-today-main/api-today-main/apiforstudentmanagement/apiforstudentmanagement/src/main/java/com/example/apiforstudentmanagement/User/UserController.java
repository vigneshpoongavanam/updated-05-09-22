package com.example.apiforstudentmanagement.User;

import com.example.apiforstudentmanagement.jwtutil.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/Userinfo")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("save")
    public ResponseEntity<User> adduser(@RequestBody User user) {
        User userSaved = userService.adduser(user);
        return new ResponseEntity<User>(userSaved, HttpStatus.CREATED);
    }

    @GetMapping("alluser")
    public List getAllUser() {
        List<User> userList = userService.getAllUser();
        return userList;
    }


    @GetMapping("{id}")
    public ResponseEntity<User> getuserById(@PathVariable Long id) {
        User retriever = userService.getuserById(id);
        return new ResponseEntity<User>(retriever, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteuserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/token")
    public ResponseEntity<Object> JwtVerification(@RequestBody LoginRequest loginRequest, @RequestHeader(value = "Authorization") String auth, User user) throws Exception {
        User loginUser = (User) userService.Login(loginRequest);
        return ResponseEntity.status(200).body(loginUser);
    }


    @PostMapping(value = "create")
    public ResponseEntity<Object> create(@Valid @RequestBody User user) {
        try {
            Optional<User> log = userService.method(user.getEmail());
            if (log.isPresent()) {
                return ResponseEntity.status(403).body(new Login403Error("Email is already present"));
            } else {
                User userSaved = userService.adduser(user);
                return ResponseEntity.status(201).body(userSaved);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }


    }

    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginRequest loginRequest, User user) throws Exception {
        User loginUser = (User) userService.Login(loginRequest);
        JwtUtils jwtUtils = new JwtUtils();
        String token = jwtUtils.generateJwt(loginUser);
        try {
            Optional<User> log = userService.method(loginRequest.getEmail());
            if (log.isPresent() || userService.encoder().matches(loginRequest.getPassword(), user.getPassword())) {
                return ResponseEntity.status(200).body(new Login200Error("Bearer", token));

            } else {
                return ResponseEntity.status(404).body(new Login404Error("email or password does not exist"));
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @PutMapping(path = "{id}")
    public void UpdateStudent(
            @PathVariable Long id, @RequestParam(required = false) String name,
            @RequestParam(required = false) String email, @RequestParam(required = false) String password) {
        userService.updateStudent(id, name, email, password);
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUser(@RequestParam("query") String query) {
        return ResponseEntity.ok(userService.searchUsers(query));
    }
}







