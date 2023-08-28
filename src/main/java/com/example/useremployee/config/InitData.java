package com.example.useremployee.config;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.Gender;
import com.example.useremployee.model.User;
import com.example.useremployee.repository.EmployeeRepository;
import com.example.useremployee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    public void saveWithCascadeAll() {
        User us1 = new User();
        us1.setEmail("jens@aol.com");
        us1.setPassword("adfadsfads");
        //userRepository.save(us1);

        Employee emp1 = new Employee();
        emp1.setBorn(LocalDateTime.of(1990, 5, 10, 16, 10, 12));
        emp1.setName("Jens");
        emp1.setGender(Gender.MALE);
        emp1.setVegetarian(true);
        emp1.setUser(us1);
        //employeeRepository.save(emp1);
        us1.setEmployee(emp1);
        userRepository.save(us1);
    }

    public void saveNoCascadeAll() {
        User us1 = new User();
        us1.setEmail("jens@aol.com");
        us1.setPassword("adfadsfads");
        userRepository.save(us1);

        Employee emp1 = new Employee();
        emp1.setBorn(LocalDateTime.of(1990, 5, 10, 16, 10, 12));
        emp1.setName("Jens");
        emp1.setGender(Gender.MALE);
        emp1.setVegetarian(true);
        emp1.setUser(us1);
        employeeRepository.save(emp1);
        us1.setEmployee(emp1);
        //userRepository.save(us1);

    }


    @Override
    public void run(String... args) throws Exception {
        saveWithCascadeAll();

    }
}
