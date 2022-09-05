package com.example.apiforstudentmanagement.Group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepo groupRepo;

    public Group addgroup(Group group) {
          return groupRepo.save(group);
    }


        public List showallgroup() {
            List<Group> list = groupRepo.findAll();
            List<String> st = new ArrayList<>();
            st.add("No groups Found");
            if (list.isEmpty()) {
                return st;
            } else {
                return list;
            }
        }
    @Transactional
    public void updateGroup(Long id, String name, String description)
    {
        Group group = groupRepo.findById(id).orElseThrow(() -> new IllegalStateException("Group with id" + id + "does not exist"));
            if (name != null && name.length() > 0)
            {
                group.setName(name);
            }
            if (description != null )
                group.setDescription(description);
            }

    public void deleteGroupById(Long id) {
        boolean exists = groupRepo.existsById(id);
        {
            if (!exists) {
                throw new IllegalStateException("student with id" + id + "does not exists");
            }
        }
        groupRepo.deleteById(id);
    }
    public List<Group> searchGroups(String query) {
        List<Group> groups = groupRepo.searchGroups(query);
        return groups;
    }
        }




