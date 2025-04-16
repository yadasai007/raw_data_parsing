package com.example.text_parser.model;
import java.util.Date;

public interface InsuranceDataProjection {
    String getClaimNumber();      // maps to claim_occ
    String getPolicyNumber();
    String getProcessCenter();
    String getCompanyCode();     // maps to company_name
    String getInsuredName();     // maps to name
    String getGroupLine();
    String getLineCode();        // maps to suser_line
    String getCoverageCode();
    String getTransactionType();
    Date getLossDate();     // or Date/String depending on your type
    Double getLossAmount();  // or Double depending on your type
}