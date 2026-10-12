package com.iset.Tp2ApiRest.web;

import com.iset.Tp2ApiRest.DAO.UserRepository;
import com.iset.Tp2ApiRest.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class add {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> ajouterUser(@RequestBody User user) {
        User nouvelUser = userRepository.save(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(nouvelUser);
    }
}
