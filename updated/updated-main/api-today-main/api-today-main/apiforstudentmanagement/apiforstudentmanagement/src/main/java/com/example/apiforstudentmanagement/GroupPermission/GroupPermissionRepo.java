
package com.example.apiforstudentmanagement.GroupPermission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupPermissionRepo extends JpaRepository<GroupPermission,Long> {
}

