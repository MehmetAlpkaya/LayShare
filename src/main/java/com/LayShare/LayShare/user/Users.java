package com.LayShare.LayShare.user;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
public class Users
{
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String username;
    @NotNull
    private String displayName;

    private String password;


}
