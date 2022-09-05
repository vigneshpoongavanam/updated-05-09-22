package com.example.apiforstudentmanagement.Group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/group")
public class GroupController {

    @Autowired
    private GroupService groupService;
    @PostMapping(value = "create")
    public ResponseEntity<Object> create(@Valid @RequestBody Group group )
    {
        Group groupSaved = groupService.addgroup(group);
        return ResponseEntity.status(201).body(groupSaved);

    }
    @GetMapping("showallgroup")
    public List showAllGroup() {
        List<Group> groupList = groupService.showallgroup();
        return groupList;
    }
    @PutMapping(path = "{id}")
    public void UpdateGroup(
            @PathVariable Long id, @RequestParam(required = false) String name,
            @RequestParam(required = false) String description) {
        groupService.updateGroup(id, name, description);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGroupById(@PathVariable Long id) {
        groupService.deleteGroupById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Group>> searchGroups(@RequestParam("query") String query) {
        return ResponseEntity.ok(groupService.searchGroups(query));
    }
}
