package com.apap.tutorial6.service;

import com.apap.tutorial6.datamodel.NewPassword;
import com.apap.tutorial6.model.UserRoleModel;

public interface UserRoleService {
    UserRoleModel addUser(UserRoleModel user);
    public String encrypt(String password);
    UserRoleModel getUserByUsername(String username);
    boolean checkIfChangePasswordValid(UserRoleModel user, NewPassword newPassword);
    void changeUserPassword(UserRoleModel user, NewPassword newPassword);
}
