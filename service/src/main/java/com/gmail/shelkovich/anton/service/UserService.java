package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.service.model.dto.UserDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional(readOnly = true)
    UserDTO getById(Long id);

    @Transactional(readOnly = true)
    UserDTO getByEmail(String email);

    @Transactional(readOnly = true)
    UserDTO getCurrentUser();

    @Transactional(readOnly = true)
    String getCurrentUsername();

    @Transactional
    void addNewUser(UserDTO user);

    @Transactional
    UserDTO updateUser(UserDTO userDTO);

    @Transactional
    UserDTO updateUserProfile(UserDTO userDTO);

    @Transactional
    UserDTO updateUserPassword(UserDTO userDTO);

    @Transactional
    void deleteUser(Long id);

    @Transactional
    void blockUser(Long id);

    @Transactional
    void unblockUser(Long id);

    @Transactional(readOnly = true)
    List<UserDTO> getAll();
}
