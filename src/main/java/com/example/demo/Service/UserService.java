package com.example.demo.Service;

import com.example.demo.Entity.UserData;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Util.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final JsonMapper jsonMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    public void saveUser(UserData user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void saveToFile() {
        List<UserData> users = userRepository.findAll();
        try {
            jsonMapper.getObjectMapper().writerWithDefaultPrettyPrinter()
                    .writeValue(new File("src/main/resources/dbjson/loginData.json"), users);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public UserData getByLogin(String login) {
        Optional<UserData> user = userRepository.findAll().stream().filter((userData -> login.equals(userData.getLogin()))).findFirst();
        return unwrapUser(user);
    }

    public UserData unwrapUser(Optional<UserData> entity) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException();
    }

    public UserData getUser(UUID id) {
        return unwrapUser(userRepository.findById(id));
    }
}
