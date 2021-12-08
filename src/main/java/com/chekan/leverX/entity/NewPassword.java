package com.chekan.leverX.entity;

public class NewPassword {

    private String code;

    private String password;

    public NewPassword() {
    }

    public NewPassword(String code, String password) {
        this.code = code;
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "NewPassword{" +
                "code='" + code + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
