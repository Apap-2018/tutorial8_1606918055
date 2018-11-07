package com.apap.tutorial6.datamodel;

import com.apap.tutorial6.model.UserRoleModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewPassword {

    public static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9]+.*)(?=.*[a-zA-Z]+.*)[0-9a-zA-Z]{8,}$");

    private String oldPassword;

    private String newPassword;

    private String confirmNewPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    public boolean isOldPasswordValid(UserRoleModel user) {
        return new BCryptPasswordEncoder().matches(this.oldPassword, user.getPassword());
    }

    public boolean isNewPasswordValid() {
        return getConfirmNewPassword().equals(this.newPassword) && PASSWORD_PATTERN.matcher(getNewPassword()).matches();
    }

    public String getEncryptedNewPassword() {
        return new BCryptPasswordEncoder().encode(getNewPassword());
    }
}
