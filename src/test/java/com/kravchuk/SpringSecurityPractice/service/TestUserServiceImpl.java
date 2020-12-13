package com.kravchuk.SpringSecurityPractice.service;

import com.kravchuk.SpringSecurityPractice.domain.User;
import com.kravchuk.SpringSecurityPractice.domain.UserRole;
import com.kravchuk.SpringSecurityPractice.dto.UserRegistrationDTO;
import com.kravchuk.SpringSecurityPractice.repository.UserRepository;
import com.kravchuk.SpringSecurityPractice.repository.UserService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserServiceImpl {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @BeforeClass
    public static void setUpClass() { }

    @Test
    public void testGetAllUsers() {
        userService.getAllUsers();
        Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testFindByUsername() {
        User user = new User();
        user.setPassword("user");
        user.setId(2L);
        user.setUsername("user");
        user.setAge(20);
        user.setFirstName("pass");
        user.setLastName("pass");
        user.setEmail("pass");
        user.setUserRole(UserRole.ADMIN);
        userRepository.save(user);
        User expectoPatronum = userService.findByUsername("user");
        Assert.assertEquals("user", expectoPatronum.getUsername());
    }

    @Test
    public void register() {
        UserRegistrationDTO userDTO = new UserRegistrationDTO();
        userDTO.setPassword("pass");
        userDTO.setUsername("pass");
        userDTO.setAge(20);
        userDTO.setFirstName("pass");
        userDTO.setLastName("pass");
        userDTO.setEmail("pass");
        User expectoPatronum = userService.register(userDTO);
        User user = new User();
        user.setPassword("pass");
        user.setUsername("pass");
        user.setAge(20);
        user.setFirstName("pass");
        user.setLastName("pass");
        user.setEmail("pass");
        user.setUserRole(UserRole.USER);
        Assert.assertEquals(user, expectoPatronum);
    }


    @Test
    public void testFindById() {
        User user = new User();
        user.setPassword("user");
        user.setUsername("user");
        user.setAge(20);
        user.setFirstName("pass");
        user.setLastName("pass");
        user.setEmail("pass");
        user.setUserRole(UserRole.ADMIN);
        userRepository.save(user);
        User expectoPatronum= userService.findById(1L);
        Assert.assertEquals(1L,expectoPatronum.getId().longValue());

    }
}
