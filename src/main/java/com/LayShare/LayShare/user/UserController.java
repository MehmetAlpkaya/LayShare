package com.LayShare.LayShare.user;
import com.LayShare.LayShare.error.ApiError;
import com.LayShare.LayShare.shared.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(path = "/api/1.0/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody Users users)
    {

        userService.save(users);
        GenericResponse response=new GenericResponse("User created");
        
        return ResponseEntity.ok(response) ;

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)// MethodArgumentNotValidException.class atılırsa metodu çalıştır
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(MethodArgumentNotValidException exception)
    {
        ApiError error =new ApiError(400, "vallidation error", "/api/1.0/users");
        Map<String, String> validationErrors = new HashMap();
        for (FieldError fieldError: exception.getBindingResult().getFieldErrors())
        {validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());}
        error.setValidationErrors(validationErrors);
        return error;
    }
}
