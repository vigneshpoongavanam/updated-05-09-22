
package com.example.apiforstudentmanagement.GroupPermission;

import javax.persistence.*;

@Entity
@Table(name="tbl_group_permission")
public class GroupPermission {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long groupId;
private Long permissionId;

    public GroupPermission() {
    }

    public GroupPermission(Long groupId, Long permissionId) {
        this.groupId = groupId;
        this.permissionId = permissionId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "GroupPermission{" +
                "groupId=" + groupId +
                ", permissionId=" + permissionId +
                '}';
    }
}

