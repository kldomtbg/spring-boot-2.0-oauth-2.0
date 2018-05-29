package com.ywsoftware.oa.authServer.entity;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * Created by userFly on 2018/5/25.
 */
@Entity
public class User {
    @Id
    @Column(nullable = false, length = 36)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String passWord;

    @Column(nullable = false)
    // @Email
    private String email;

    // @Transient
    // 改注解可以控制字段不被持久化
    private String test;

    public User() {

    }

    public User(String _id, String _name, String _passWord, String _email) {
        this.id = _id;
        this.name = _name;
        this.passWord = _passWord;
        this.email = _email;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
