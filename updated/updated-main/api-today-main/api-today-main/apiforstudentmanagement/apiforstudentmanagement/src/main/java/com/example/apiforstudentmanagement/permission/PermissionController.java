package com.example.apiforstudentmanagement.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping("permission")
    public ResponseEntity<Object> create(@Valid @RequestBody Permission permission) {
        permission = permissionService.adduser(permission);
        return ResponseEntity.status(201).body(permission);
    }

    @GetMapping("{id}")
    public ResponseEntity<Permission> getpermissionById(@PathVariable Long id) {
        Permission retriever = permissionService.getpermissionById(id);
        return new ResponseEntity<Permission>(retriever, HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    public void UpdateStudent(
            @PathVariable Long id, @RequestParam(required = false) String code,
            @RequestParam(required = false) String description) {
        permissionService.updatePermission(id, code, description);
    }

    @GetMapping("allpermission")
    public ResponseEntity<List<Permission>> getallpermission() {
        List<Permission> permissionList = permissionService.getallpermission();
        if (permissionList.isEmpty()) {
            return new ResponseEntity<List<Permission>>(permissionList, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Permission>>(permissionList, HttpStatus.OK);
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletepermissionById(@PathVariable Long id)
    {
        permissionService.deletePermissionById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
