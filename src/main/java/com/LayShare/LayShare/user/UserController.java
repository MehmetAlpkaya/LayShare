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

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(path = "/api/1.0/users")
    public ResponseEntity<?> createUser(@RequestBody Users users)
    {
        ApiError error =new ApiError(400, "vallidation error", "/api/1.0/users");
        Map<String, String> validationErrors = new HashMap();
        String username = users.getUsername();
        String displayName= users.getDisplayName();
        if (username==null || username.isEmpty()){

            validationErrors.put("username", "Username cannot be null");
        }

        if (displayName==null || displayName.isEmpty()){
            validationErrors.put("displayName", "Username cannot be null");

        }
        if(validationErrors.size()>0)
        {
            error.setValidationErrors(validationErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error); // error objesinin body sini response entity olarak dönüyoruz
        }
        userService.save(users);
        GenericResponse response=new GenericResponse();
        response.setMessage("User created");
        return ResponseEntity.ok(response) ;

    }
}
