package org.example.chua_bai_ss01.models.repositories;

import org.example.chua_bai_ss01.models.entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {
    public List<User> users = new ArrayList<>(Arrays.asList(
            new User(1,"username1","user1@gmail.com","ADMIN"),
            new User(2,"username2","user2@gmail.com","USER"),
            new User(3,"username3","user3@gmail.com","USER")
    ));
}
