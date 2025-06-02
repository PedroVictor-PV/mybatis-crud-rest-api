package br.com.pedro.crud_mybatis.controller;

import br.com.pedro.crud_mybatis.model.User;
import br.com.pedro.crud_mybatis.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public void insert(@RequestBody User user){
        userService.insert(user);
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
