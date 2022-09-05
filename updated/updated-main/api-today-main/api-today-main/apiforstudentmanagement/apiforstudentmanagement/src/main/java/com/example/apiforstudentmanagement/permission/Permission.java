
package com.example.apiforstudentmanagement.permission;

import javax.persistence.*;

@Entity
@Table(name = "tbl_permission")
public class Permission {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String code;
    private String description;
    private boolean isDeleted= false;

    public Permission() {
    }

    public Permission(Long id, String code, String description, boolean isDeleted) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.isDeleted = isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}

