package com.deloitte.hashcart.userservice.service;

import com.deloitte.hashcart.userservice.exception.UserNotFoundException;
import com.deloitte.hashcart.userservice.model.User;
import com.deloitte.hashcart.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User u) throws UserNotFoundException {
        User t = repository.save(u);
        if (t != null) {
            return t;
        } else {
            throw new UserNotFoundException("User Not Found");
        }
    }


    public User getUserById(Integer id) throws UserNotFoundException {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User not found with given Id");
        }
    }

    public List<User> getAllUser() {
        return repository.findAll();
    }

    public User deleteUserById(Integer id) throws UserNotFoundException {
        Optional<User> user = repository.findById(id);
        if (user .isPresent()) {
            repository.delete(user.get());
            return user.get();
        } else {
            throw new UserNotFoundException("User not found with given Id");
        }

    }

    public User updateUserById(Integer id, User user) throws UserNotFoundException {
        Optional<User> u = repository.findById(id);
        if (u.isPresent()) {
            u.get().setFirstname(user.getFirstname());
            u.get().setLastname(user.getLastname());
            u.get().setMiddlename(user.getMiddlename());
            u.get().setUsername(user.getUsername());
            u.get().setPassword(user.getPassword());
            u.get().setMobileno(user.getMobileno());
            u.get().setEmail(user.getEmail());
            u.get().setDob(user.getDob());
            u.get().setRole(user.getRole());
            u.get().setAddress(user.getAddress());
            u.get().setPincode(user.getPincode());
            repository.save(u.get());
            return u.get();
        } else {
            throw new UserNotFoundException("User not found with given Id");
        }
    }
}
