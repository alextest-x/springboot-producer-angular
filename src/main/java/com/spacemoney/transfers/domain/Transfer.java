package com.spacemoney.transfers.domain;

import lombok.Data;

import java.io.Serializable;


//ponemos el serializable porque se envia por el broker de mensajeria

@Data
public class Transfer implements Serializable {

    private String origin;

    private String destin;

    private String bank;

    private String amount;

}
