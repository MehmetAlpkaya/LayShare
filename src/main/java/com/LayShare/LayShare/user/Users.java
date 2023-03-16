package com.LayShare.LayShare.user;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
public class Users
{
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min=4, max = 255)
    @UniqueUsername
    private String username;
    @NotNull
    @Size(min=4, max = 255)
    private String displayName;
    @NotNull
    @Size(min = 8, max = 10000)
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")// şefreye bir büyük bir küçük harf eklenmesi için kullanıldı
    private String password;


}
