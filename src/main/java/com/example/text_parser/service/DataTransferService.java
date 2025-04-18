package com.example.text_parser.service;

import com.example.text_parser.model.InsuranceData;
import com.example.text_parser.model.NpsData;
import com.example.text_parser.model.TransactionDetails;
import com.example.text_parser.repository.InsuranceRepository;
import com.example.text_parser.repository.NpsRepository;
import com.example.text_parser.repository.TransactionRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataTransferService {

    private final InsuranceRepository insuranceRepository;
    private final NpsRepository npsRepository;
    private final TransactionRepository transactionTypeRepository;

    public DataTransferService(InsuranceRepository insuranceRepository, 
                             NpsRepository npsRepository,TransactionRepository transactionTypeRepository) {
        this.insuranceRepository = insuranceRepository;
        this.npsRepository = npsRepository;
        this.transactionTypeRepository= transactionTypeRepository;
    }

    @Transactional
    public void transferToNps(String claimNumber) {
        InsuranceData insuranceData = insuranceRepository.findByClaimOcc(claimNumber);
        if (insuranceData != null) {
            NpsData npsData = new NpsData();
            // Map fields from insurance_data to nps_data
            npsData.setClaimNumber(insuranceData.getClaimOcc());
            npsData.setPolicyNumber(insuranceData.getPolicyNumber());
            npsData.setProcessCenter(insuranceData.getProcessCenter());
            npsData.setCompanyCode(insuranceData.getCompanyName());
            npsData.setInsuredName(insuranceData.getName());
            npsData.setGroupLine(insuranceData.getGroupLine());
            npsData.setLineCode(insuranceData.getSuserLine());
            npsData.setTransactionCode(insuranceData.getTransCode());
            npsData.setTransactionDescription(
                insuranceData.getTransCode() + " - " + insuranceData.getCoverageCode());
            npsData.setLossDate(insuranceData.getLossDate());
            npsData.setLossAmount(insuranceData.getLossAmount());
            
            npsRepository.save(npsData);
        }
    }
    @Transactional
    public void transferAllToNps() {
        List<InsuranceData> allInsuranceData = insuranceRepository.findAll();
        allInsuranceData.sort(Comparator.comparing(InsuranceData::getClaimOcc));
    	List<TransactionDetails> transactionList = transactionTypeRepository.findAll();
        Map<String, String> transactionMap = transactionList.stream()
                .collect(Collectors.toMap(
                    TransactionDetails::getTransactionType, 
                    TransactionDetails::getTransactionDescription
                ));
        allInsuranceData.forEach(insuranceData -> {
            NpsData npsData = new NpsData();
            // Mapping as shown above
            if (insuranceData != null) {
                // Map fields from insurance_data to nps_data
                npsData.setClaimNumber(insuranceData.getClaimOcc());
                npsData.setPolicyNumber(insuranceData.getPolicyNumber());
                npsData.setProcessCenter(insuranceData.getProcessCenter());
                npsData.setCompanyCode(insuranceData.getCompanyName());
                npsData.setInsuredName(insuranceData.getName());
                npsData.setGroupLine(insuranceData.getGroupLine());
                npsData.setLineCode(insuranceData.getSuserLine());
                npsData.setTransactionCode(insuranceData.getTransCode());
                npsData.setTransactionDescription(transactionMap.get(insuranceData.getTransCode()));
                npsData.setLossDate(insuranceData.getLossDate());
                npsData.setLossAmount(insuranceData.getLossAmount());
            }
                npsRepository.save(npsData);
        });
    }
    
}