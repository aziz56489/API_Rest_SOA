package com.iset.Tp2ApiRest.web;

import java.util.List;
import java.util.Optional;

import com.iset.Tp2ApiRest.DAO.UserRepository;
import com.iset.Tp2ApiRest.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;

@Controller
public class UserGraphQLController {

    private final UserRepository userRepository;

    public UserGraphQLController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryMapping
    public List<User> users() {
        return userRepository.findAll();
    }

    @QueryMapping
    public Optional<User> userById(@Argument Long id) {
        return userRepository.findById(id);
    }

    @MutationMapping
    public User addUser(
            @Argument String name,
            @Argument String email) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);

        return userRepository.save(user);
    }
}