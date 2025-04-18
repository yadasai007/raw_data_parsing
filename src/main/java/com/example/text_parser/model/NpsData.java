package com.example.text_parser.model;
import lombok.*;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class NpsData
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer npsId;
    
    private String claimNumber;
    
    private String policyNumber;
    
    private String processCenter;
    
    private String companyCode;
    
    private String insuredName;
    
    private String groupLine;
    
    private String lineCode;
    
    private String transactionCode;
    
    private String transactionDescription;
    
    private Date lossDate;
    
    private Double lossAmount;
}