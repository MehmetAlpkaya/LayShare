package com.LayShare.LayShare.auth;

import com.LayShare.LayShare.error.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController
{
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    @PostMapping("/api/1.0/auth")
    ResponseEntity<?> handleAuothentication(@RequestHeader(name="Authorization", required = false) String authorization )
    {
        if(authorization==null)
        {
            ApiError error = new ApiError(400,"Unauthorized request", "/api/1.0/auth" );
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }
        log.info(authorization);
        return ResponseEntity.ok().build();
    }
}
