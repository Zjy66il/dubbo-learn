package org.zjy.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserModel implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private String password;
}
