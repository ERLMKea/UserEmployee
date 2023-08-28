package com.example.useremployee.controller;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.User;
import com.example.useremployee.repository.EmployeeRepository;
import com.example.useremployee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpoyeeRestController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    List<User> findAllUsers() {
        return userRepository.findAll();
    }


    @GetMapping("/employees")
    List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee postEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        return employeeRepository.save(employee);
    }

    @PostMapping("/useremp")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUserEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        return userRepository.save(employee.getUser());
    }


    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user) {
        System.out.println(user);
        return userRepository.save(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        Optional<User> orgUser = userRepository.findById(id);
        if (orgUser.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted");
        } else {
            //return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

}

