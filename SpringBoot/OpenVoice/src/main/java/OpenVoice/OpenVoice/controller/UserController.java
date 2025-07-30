package OpenVoice.OpenVoice.controller;

import OpenVoice.OpenVoice.entity.User;
import OpenVoice.OpenVoice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/openvoice")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/public/users")
    public List<User> getAllUsers() {
        System.out.println("Fetching users...");
        return userService.usersList();
    }

    @GetMapping("/test")
    public String hello() {
        return "Hello from OpenVoice";
    }

}
