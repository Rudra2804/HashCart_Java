package com.deloitte.hashcart.cartservice.feign;

import com.deloitte.hashcart.cartservice.exception.UserNotFoundException;
import com.deloitte.hashcart.cartservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="USER-SERVICE",url="localhost:9090")
public interface UserFeign {

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) throws UserNotFoundException;

}
