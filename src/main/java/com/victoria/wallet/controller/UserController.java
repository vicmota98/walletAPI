package com.victoria.wallet.controller;

import com.victoria.wallet.dto.UserDTO;
import com.victoria.wallet.entity.User;
import com.victoria.wallet.response.Response;
import com.victoria.wallet.service.UserService;
import com.victoria.wallet.util.Bcrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody UserDTO dto, BindingResult result) {
        Response<UserDTO> response = new Response<UserDTO>();

        if(result.hasErrors()) {
            result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        User user =  service.save(this.convertDtoToEntity(dto));
        response.setData(this.convertEntityToDto(user));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

//    @DeleteMapping
//    public ResponseEntity<Object> remove(@Valid @RequestBody UserDTO dto, BindingResult result) {
//        Response<UserDTO> response = new Response<UserDTO>();
//
//        if(result.hasErrors()) {
//            result.getAllErrors().forEach(e -> response.getErrors().remove(e.getDefaultMessage()));
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//        }
//        User user =  service.save(this.convertDtoToEntity(dto));
//        response.setData(this.convertEntityToDto(user));
//        return ResponseEntity.status(HttpStatus.OK).body(response);
//    }

    private User convertDtoToEntity(UserDTO dto) {
        User u = new User();
        u.setId(dto.getId());
        u.setEmail(dto.getEmail());
        u.setName(dto.getName());
        u.setPassword(Bcrypt.getHash(dto.getPassword()));

        return u;
    }

    private UserDTO convertEntityToDto(User u) {
        UserDTO dto = new UserDTO();
        dto.setId(u.getId());
        dto.setEmail(u.getEmail());
        dto.setName(u.getName());
        return dto;
    }
}
