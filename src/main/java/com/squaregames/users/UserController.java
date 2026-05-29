package com.squaregames.users;

import com.squaregames.users.entity.UserEntity;
import com.squaregames.users.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public UserEntity createUser(@RequestBody Map<String, String> body) {
        return userService.createUser(body.get("username"), body.get("email"));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable String id) {
        return userService.getUser(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @GetMapping("/users/{id}/valid")
    public boolean isValid(@PathVariable String id) {
        return userService.isValid(id);
    }
}