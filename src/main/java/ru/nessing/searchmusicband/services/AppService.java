package ru.nessing.searchmusicband.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nessing.searchmusicband.entities.User;
import ru.nessing.searchmusicband.repositories.AppRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppService {
    private final AppRepository appRepository;
    private Map<String, User> listUsers = new HashMap<>();

    public Optional<User> findUserById(Long id) {
        return appRepository.findById(id);
    }

    public User findUserByEmail(String email) {
        if (listUsers.containsKey(email)) {
            return listUsers.get(email);
        } else {
            User user = appRepository.findUserByEmail(email);
            listUsers.put(email, user);
            return user;
        }
    }

    public String saveOrUpdateUser(User user) {
        if (appRepository.findUserByEmail(user.getEmail()) != null) {
            return "Указанная почта уже существует";
        } else {
            appRepository.save(user);
            listUsers.put(user.getEmail(), user);
            return "Пользователь " + user.getName() + " создан";
        }
    }

    public User updateState(String email, String password, String state) {
        User user = appRepository.findUserByEmail(email);
        if (user.getPassword().equals(password)) {
            if (state.equals("public")) {
                user.statePrivate();
                appRepository.save(user);
            } else {
                user.statePublic();
                appRepository.save(user);
            }
        }
        return user;
    }
}
