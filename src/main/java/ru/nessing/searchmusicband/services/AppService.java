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

    public User getUserByNickname(String nickname) {
        if (listUsers.containsKey(nickname)) {
            return listUsers.get(nickname);
        }
        User user = appRepository.getUserByNickname(nickname);
        listUsers.put(nickname, user);
        return user;
    }

    public String saveOrUpdateUser(User user) {
        if (appRepository.findUserByEmail(user.getEmail()) != null || appRepository.findUserByNickname(user.getNickname()) != null) {
            return "Указанная почта или ник уже существует";
        }
        appRepository.save(user);
        listUsers.put(user.getNickname(), user);
        return "Пользователь " + user.getNickname() + " создан";
    }

    public User updateState(String nickname, String password, String state) {
        User user = appRepository.getUserByNickname(nickname);
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
