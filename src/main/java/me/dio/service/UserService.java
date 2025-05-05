package me.dio.service;

import me.dio.domain.model.UserModel;

public interface UserService {
    
    UserModel findById(Long id);

    UserModel create(UserModel userToCreate);
}
