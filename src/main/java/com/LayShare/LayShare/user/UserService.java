package com.LayShare.LayShare.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {



    UserRepository userRepository;

    PasswordEncoder passwordEncoder; //

    public UserService(UserRepository userRepository)
    {
        this.userRepository =userRepository;
        this.passwordEncoder= new BCryptPasswordEncoder();//
    }
    public void save(Users users) {

        String encryptedPassword =this.passwordEncoder.encode(users.getPassword());
        users.setPassword(encryptedPassword);
        userRepository.save(users);
    }
}
