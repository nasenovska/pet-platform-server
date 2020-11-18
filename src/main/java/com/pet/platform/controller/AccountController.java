package com.pet.platform.controller;

import com.pet.platform.entity.User;
import com.pet.platform.service.UserService;
import com.pet.platform.util.CustomErrorType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import static com.pet.platform.entity.Role.USER;

@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody User userRequestModel) {

        if (userService.find(userRequestModel.getUsername()) != null) {
            log.error("Account with username {} already exist", userRequestModel.getUsername());
            // noinspection unchecked
            return new ResponseEntity(
                    new CustomErrorType("User with username " + userRequestModel.getUsername() + " already exist"),
                    HttpStatus.CONFLICT);
        }

        userRequestModel.setRole(USER.name());

        return new ResponseEntity<>(userService.save(userRequestModel), HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public Principal user(Principal principal) {
        log.info("user logged " + principal);
        return principal;
    }
}
