package com.spacemoney.transfers.broker.service.impl;

import com.spacemoney.transfers.broker.service.TransferService;
import com.spacemoney.transfers.domain.Transfer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private RabbitTemplate rabbitTempalte;


    @Override
    public void sendTransfer(Transfer transfer) {
        System.out.println("transfer : " + transfer);

        rabbitTempalte.convertAndSend("x.spacemoney.transfers", null, transfer);
        System.out.println("convertAndSend :" + transfer);
        log.info("Transferencia Enviada" + transfer);

    }
}
