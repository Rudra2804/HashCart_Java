package com.deloitte.hashcart.userservice.service;

import com.deloitte.hashcart.userservice.exception.UserNotFoundException;
import com.deloitte.hashcart.userservice.model.User;
import com.deloitte.hashcart.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;


    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveUser() throws UserNotFoundException {
        User user=new User();
        User u=new User(1,"Rudra","abc","abc","ab","ab","jknkjnjk","12121212",null,"admin","guj","39008");
        given(repository.save(u)).willReturn(user);
        assertThat(service.saveUser(u)).isNotNull();
    }

    @Test
    void getUserById() throws UserNotFoundException {
        User u=new User(1,"Rudra","abc","abc","ab","ab","jknkjnjk","12121212",null,"admin","guj","39008");
        when(repository.findById(1)).thenReturn(Optional.of(u));
        assertThat(service.getUserById(1)).isNotNull();
    }

    @Test
    void getAllUser() {
        List<User> users=new ArrayList<>();
        User u=new User(1,"Rudra","abc","abc","ab","ab","jknkjnjk","12121212",null,"admin","guj","39008");
        users.add(u);
        when(repository.findAll()).thenReturn(users);
        assertThat(service.getAllUser()).isNotNull();
    }

    @Test
    void deleteUserById() throws UserNotFoundException {
        User u=new User(1,"Rudra","abc","abc","ab","ab","jknkjnjk","12121212",null,"admin","guj","39008");
        when(repository.findById(1)).thenReturn(Optional.of(u));
        repository.delete(u);
        assertThat(service.deleteUserById(1)).isNotNull();
    }

    @Test
    void updateUserById() throws UserNotFoundException {
        User u=new User(1,"Rudra","abc","abc","ab","ab","jknkjnjk","12121212",null,"admin","guj","39008");
        when(repository.findById(1)).thenReturn(Optional.of(u));
        repository.save(u);
        assertThat(service.updateUserById(1,u)).isNotNull();
    }
}