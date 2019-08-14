package com.example.demo.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Users {

    @Getter
    @Setter
    private String name;


    @Getter
    @Setter
    private Long salary;

    @Getter
    @Setter
    private Integer id;

}
