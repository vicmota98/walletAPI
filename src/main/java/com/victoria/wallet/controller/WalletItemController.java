package com.victoria.wallet.controller;

import com.victoria.wallet.dto.WalletItemDTO;
import com.victoria.wallet.entity.WalletItem;
import com.victoria.wallet.response.Response;
import com.victoria.wallet.service.UserWalletService;
import com.victoria.wallet.service.WalletItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("wallet-item")
public class WalletItemController {

    @Autowired
    WalletItemService service;

    @Autowired
    UserWalletService userWalletService;

    @PostMapping
    public ResponseEntity<Response<WalletItemDTO>> create(@Valid @RequestBody WalletItemDTO dto, BindingResult result) {
        Response<WalletItemDTO> response = new Response<WalletItemDTO>();

        if(result.hasErrors()) {
            result.getAllErrors().forEach(r -> response.getErrors().add( r.getDefaultMessage()));

            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
