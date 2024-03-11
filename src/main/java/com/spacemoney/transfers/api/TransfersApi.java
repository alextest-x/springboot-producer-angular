package com.spacemoney.transfers.api;

import com.spacemoney.transfers.broker.service.TransferService;
import com.spacemoney.transfers.domain.Transfer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/transfer")
@CrossOrigin(value= "http://localhost:4200")
public class TransfersApi {

    /*
      @RequestBody recibimos el parametro un objeto transfer
     */

    @Autowired
    private TransferService transferService;

    @PostMapping
    public ResponseEntity<?> createTransfer(@RequestBody Transfer transfer){
        log.info("Enviado transferencia desde la API {} Producer ", transfer);

        //enviado mensaje
        transferService.sendTransfer(transfer);

        return  new ResponseEntity<>("Transfer send Producer ", HttpStatus.OK);

    }


}
