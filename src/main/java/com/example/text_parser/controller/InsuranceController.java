package com.example.text_parser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.text_parser.model.InsuranceData;
import com.example.text_parser.model.TransactionDetails;
import com.example.text_parser.repository.InsuranceRepository;
import com.example.text_parser.repository.TransactionRepository;
import com.example.text_parser.service.DataTransferService;
import com.example.text_parser.service.EntityExportService;
import com.example.text_parser.service.InsuranceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller 
@Tag(name = "Insurance Data Processing", description = "APIs for processing insurance data")
public class InsuranceController {
	private static final Logger logger = LoggerFactory.getLogger(InsuranceController.class);

    private final InsuranceService insuranceService;
    private final DataTransferService dataTransferService;
    private final EntityExportService entityExportService;
    @Autowired
    private InsuranceRepository insuranceDataRepository;
    
    @Autowired
    private TransactionRepository transactionTypeRepository;

    public InsuranceController(InsuranceService insuranceService,DataTransferService dataTransferService,EntityExportService entityExportService) {
        this.insuranceService = insuranceService;
        this.dataTransferService=dataTransferService;
        this.entityExportService=entityExportService;
        try {
			this.entityExportService.npmDataToFile();
			this.entityExportService.amountToFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @Operation(summary = "Show single line form", description = "Returns the HTML form for single line input")
    @ApiResponse(responseCode = "200", description = "Form displayed successfully")
    @GetMapping("/upload")
    public String showForm() {
    	logger.info("HTML form is loaded successfully for single entry");
        return "entry";  
    }
    
    @Operation(summary = "Show multi-line form", description = "Returns the HTML form for multi-line input")
    @ApiResponse(responseCode = "200", description = "Form displayed successfully")
    @GetMapping("/upload-multi")
    public String showMultiLineForm() {
    	logger.info("HTML form is loaded successfully for multiple lines entry");
        return "multi-entry";  
    }

    @Operation(summary = "Process Single Line Data", description = "Add Single line data to database")
    @PostMapping("/upload")
    public ResponseEntity<String> uploadData(@RequestBody String dataString) {
    	System.out.println(dataString);
        if(insuranceService.processInsuranceData(dataString)==false)
        {
        	logger.error("Unable to Insert Data Error occured");     
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        		       .body("Failed to insert data into database");
        }
        logger.info("New data added to database successfully");     
        return ResponseEntity.ok("Single Entry Inserted Into Database");

       }
    
    @Operation(summary = "Process multi-line data", description = "Processes multiple lines of insurance data")
    @PostMapping("/upload-multi")
    public ResponseEntity<String> uploadMultiData(@RequestBody String dataString) {
        String[] lines = dataString.split("\\r?\\n");
        Integer count=0;
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
            	logger.info("New line added");
                if(insuranceService.processInsuranceData(line))
                	count+=1;
            }
        }
        if(count==0)
        {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        		       .body("Failed to insert data into database");
        }
        return ResponseEntity.ok("Processed " + count + " lines");
    }
    
    @Operation(summary = "View Data", description = "Returns HTML form to view all the users data")
    @ApiResponse(responseCode = "200", description = "Form displayed successfully")
    @GetMapping("/dashboard")
    public String viewNames(Model model) {

    	List<InsuranceData> insuranceData = insuranceDataRepository.findAll();
    	List<InsuranceData> sortedList = insuranceData.stream()
    		    .sorted(Comparator.comparing(InsuranceData::getClaimOcc))
    		    .collect(Collectors.toList());
    	List<TransactionDetails> transactionList = transactionTypeRepository.findAll();
        Map<String, String> transactionMap = transactionList.stream()
                .collect(Collectors.toMap(
                    TransactionDetails::getTransactionType, 
                    TransactionDetails::getTransactionDescription
                ));

        // Add the complete list to the model
        model.addAttribute("insuranceDataList", sortedList);
        model.addAttribute("transactionMap",transactionMap);
        return "view-data"; // name of your Thymeleaf template
    }
    
    @GetMapping("/transfer/all")
    public String transferAllToNps() {
        dataTransferService.transferAllToNps();
        return "redirect:/dashboard";
    }
    
}
