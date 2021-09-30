package ru.nessing.searchmusicband.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nessing.searchmusicband.entities.User;
import ru.nessing.searchmusicband.repositories.AppRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppService {
    private final AppRepository appRepository;

    public Optional<User> findUserById(Long id) {
        return appRepository.findById(id);
    }

    public String saveOrUpdateUser(User user) {
        if (appRepository.findUserByEmail(user.getEmail()) != null) {
            return "Указанная почта уже существует";
        } else {
            appRepository.save(user);
            return "Пользователь " + user.getName() + " создан";
        }
    }
}
