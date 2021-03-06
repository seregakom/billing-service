package com.example.billing.service.service;

import com.example.billing.service.entity.User;
import com.example.billing.service.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    /**Добавить пользователя
     * @param user Пользователь
     * @return
     */
    public User addUser(User user) {
        return userRepo.save(user);
    }

    /**Обновить пользователя
     * @param user Пользователь
     * @return
     */
    public User updateUser(User user){
        return userRepo.save(user);
    }

    /**Получить пользователя
     * @param id Идентификатор пользователя
     * @return
     */
    public User getUser(Long id) {
        return userRepo.findById(id).get();
    }

    /**Удалить пользователя
     * @param id Идентификатор пользователя
     * @return
     */
    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
