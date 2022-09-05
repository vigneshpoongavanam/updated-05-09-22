package com.example.apiforstudentmanagement.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value = "Select * from tbl_user where email=?1 and password=?2", nativeQuery = true)
    User AdminLogin(@PathVariable("email") String email, @PathVariable("password") String password);

    Optional<User> findByEmail(@PathVariable("email") String email);

    @Query(value = "Select  * from tbl_user u where " + "u.firstName LIKE CONCAT ('%', :query, '%')", nativeQuery = true)
    List<User> searchUsers(String query);

}
