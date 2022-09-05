package com.example.apiforstudentmanagement.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepo permissionRepo;

    public Permission adduser(Permission permission) {
        return permissionRepo.save(permission);

    }

    public Permission getpermissionById(Long id) {
        return permissionRepo.findById(id).get();
    }


    @Transactional
    public void updatePermission(Long id, String code, String description) {
        Permission permission = permissionRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student with id"   + id +   "does not exist"));
        if (code != null) {
            permission.setCode(code);
        }
        if (description != null ) {

            permission.setDescription(description);
        }

    }
    public List<Permission> getallpermission() {

        return permissionRepo.findAll();
    }
    public void deletePermissionById(Long id) {
        boolean exists =permissionRepo.existsById(id);
        {
            if(!exists)
            {
                throw  new IllegalStateException("student with id" + id + "does not exists");
            }
        }
        permissionRepo.deleteById(id);
    }

    }

