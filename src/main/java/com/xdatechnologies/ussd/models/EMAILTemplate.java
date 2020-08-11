package com.xdatechnologies.ussd.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EMAILTemplate implements Serializable {
    public static final long serialVersionUID = 42L;
    private String email;
    private String subject;
    private String emailBody;
}
