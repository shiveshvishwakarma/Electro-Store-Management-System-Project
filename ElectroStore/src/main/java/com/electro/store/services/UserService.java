package com.electro.store.services;

import com.electro.store.dtos.PageableResponce;
import com.electro.store.dtos.UserDto;

import java.util.List;

public interface UserService {

    //create

    UserDto createUser(UserDto userDto);

    //update

    UserDto updateUser(UserDto userDto, String userId);

    //delete
    void deleteUser(String userId);

    //get all user
    PageableResponce<UserDto> getAllUser(int pageNumber, int pageSize, String sortBy, String sortDir);

    //get single user by id
    UserDto getUserById(String userId);

    //get single user by email
    UserDto getUserByEmail(String email);

    //search user
    List<UserDto> serarchUser(String keyword);

    //other user specific features


}
