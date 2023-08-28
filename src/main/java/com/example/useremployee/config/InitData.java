package com.example.useremployee.config;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.Gender;
import com.example.useremployee.model.User;
import com.example.useremployee.repositories.EmployeeRepository;
import com.example.useremployee.repositories.UserRepository;
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

    @Override
    public void run(String... args) throws Exception {

        //first user
        User us1 = new User();
        us1.setEmail("nicl2995@stud.kea.dk");
        us1.setPassword("123");
        userRepository.save(us1);

        Employee emp1 = new Employee();
        emp1.setBorn(LocalDateTime.of(2002, 05, 17, 22, 05, 34));
        emp1.setName("Niclas Nielsen");
        emp1.setGender(Gender.MALE);
        emp1.setVegetarian(false);
        emp1.setUser(us1);
        employeeRepository.save(emp1);

        //second user
        us1.setUserID(0);
        us1.setEmail("faxxax@yahoo.dk");
        us1.setPassword("1234");
        userRepository.save(us1);

        emp1.setId(0);
        emp1.setBorn(LocalDateTime.of(2000, 9, 12, 20, 03, 31));
        emp1.setName("Jensine");
        emp1.setGender(Gender.FEMALE);
        emp1.setVegetarian(true);
        emp1.setUser(us1);
        employeeRepository.save(emp1);

        //third user
        us1.setUserID(0);
        us1.setEmail("MrBang@outlook.com");
        us1.setPassword("12345");
        userRepository.save(us1);

        emp1.setId(0);
        emp1.setBorn(LocalDateTime.of(1998, 10, 6, 10, 46, 1));
        emp1.setName("Jarl");
        emp1.setGender(Gender.OTHER);
        emp1.setVegetarian(true);
        emp1.setUser(us1);
        employeeRepository.save(emp1);

    }

}
