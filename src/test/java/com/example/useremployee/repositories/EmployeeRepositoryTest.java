package com.example.useremployee.repositories;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.User;
import org.hibernate.JDBCException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void testAtLeastOneEmpByName() {
        List<Employee> list = employeeRepository.findEmployeeByName("Jensine");
        assertTrue(list.size() > 0);
    }

    @Test
    void testDeleteUser() {
        Optional<User> opt1 = userRepository.findByEmail("nicl2995@stud.kea.dk");
        User us1 = new User();
        if (opt1.isPresent()) {
            us1 = opt1.get();
        }
        User us2 = us1;
        assertThrows(org.springframework.dao.DataIntegrityViolationException.class, () -> userRepository.delete(us2));

    }

    @Test
    void testDeleteEmployee() {
        List<Employee> list = employeeRepository.findEmployeeByName("Jensine");
        Employee emp = list.get(0);
        assertEquals("Jensine", emp.getName());
        assertThrows(org.springframework.dao.DataIntegrityViolationException.class, () -> userRepository.delete(emp.getUser()));
    }

}