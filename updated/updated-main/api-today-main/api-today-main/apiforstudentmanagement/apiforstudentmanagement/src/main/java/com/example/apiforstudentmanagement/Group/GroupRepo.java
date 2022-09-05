
package com.example.apiforstudentmanagement.Group;

import com.example.apiforstudentmanagement.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepo extends JpaRepository<Group,Long> {
    @Query( value="Select  * from tbl_group u where " + "u.name LIKE CONCAT ('%', :query, '%')" , nativeQuery = true)
    List<Group> searchGroups(String query);
}

