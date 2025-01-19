package ng.samuel.demo.microservicetemplate.userservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/{id}")
    public Map<String, String> getUser(@PathVariable String id) {
        return Map.of("id", id, "name", "Samuel", "email", "samuel@example.com");
    }
}

