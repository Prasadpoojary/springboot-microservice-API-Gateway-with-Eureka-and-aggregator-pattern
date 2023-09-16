package com.tcs.ecommerce.userservice.controller;


import com.tcs.ecommerce.userservice.model.Users;
import com.tcs.ecommerce.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Users> addUser(@RequestBody Users user)
    {
        Users response=this.userService.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/")
    public ResponseEntity<List<Users>> allUser()
    {
        List<Users> response=this.userService.all();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Long id)
    {
        Users response=this.userService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id)
    {
        this.userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id,@RequestBody Users user)
    {
        Users response=this.userService.update(id,user);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
