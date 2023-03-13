package com.LayShare.LayShare.user;

import com.LayShare.LayShare.error.ApiError;
import com.LayShare.LayShare.shared.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(path = "/api/1.0/users")
    public ResponseEntity<?> createUser(@RequestBody Users users)
    {
        String username = users.getUsername();
        if (username==null || username.isEmpty()){
            ApiError error =new ApiError(400, "vallidation error", "/api/1.0/users");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        userService.save(users);
        GenericResponse response=new GenericResponse();
        response.setMessage("User created");
        return ResponseEntity.ok(response) ;

    }
}
