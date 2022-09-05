
package com.example.apiforstudentmanagement.Usergroup;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tbl_user_group")
public class UserGroup {
    @Id
    private Long userId;
    private Long groupId;

    public UserGroup() {
    }

    public UserGroup(Long userId, Long groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "userId=" + userId +
                ", groupId=" + groupId +
                '}';
    }
}

