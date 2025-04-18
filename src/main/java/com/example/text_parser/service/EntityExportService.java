package com.example.text_parser.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.text_parser.model.NpsData;
import com.example.text_parser.repository.NpsRepository;

@Service
public class EntityExportService
{
	private final NpsRepository npsDataRepository;
	public EntityExportService(NpsRepository npsDataRepository)
	{
		this.npsDataRepository=npsDataRepository;
	}
	public String getSign(Double number)
	{
		if(number<0)
			return "-";
		return "";
	}
	public void exportEntitiesToFile() throws IOException {
    String filePath = "results\\nps_data.txt";
    List<NpsData> entities = npsDataRepository.findAll();
    entities.sort(Comparator.comparing(NpsData::getClaimNumber));
    
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        // Get current date and time for the report
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yy");
        int pageNumber = 1;
        int entityCount = 0;
        
        // Write header for first page
        writePageHeader(writer, now, dateFormatter, timeFormatter, pageNumber);
        
        // Write data
        for (NpsData entity : entities) {
            // Check if we need a new page (before writing the next record)
            if (entityCount > 0 && entityCount % 51 == 0) {
                pageNumber++;
                writer.newLine();
                writePageHeader(writer, now, dateFormatter, timeFormatter, pageNumber);
            }
            
            writer.write(String.format("%10s %12s %4s %4s %20s %3s %3s %3s %-5s %-25s %-15s %.2f%s", 
                    entity.getClaimNumber(),
                    entity.getPolicyNumber(),
                    entity.getProcessCenter(),
                    entity.getCompanyCode(),
                    entity.getInsuredName(),
                    entity.getGroupLine(),
                    entity.getLineCode(),
                    entity.getCompanyCode(),
                    entity.getTransactionCode(),
                    entity.getTransactionDescription(),
                    formatter.format(entity.getLossDate()),
                    Math.abs(entity.getLossAmount()),
                    getSign(entity.getLossAmount())));
            writer.newLine();
            
            entityCount++;
        }
    }
}

private void writePageHeader(BufferedWriter writer, LocalDateTime now, 
                           DateTimeFormatter dateFormatter, 
                           DateTimeFormatter timeFormatter, 
                           int pageNumber) throws IOException {
    // Clear previous page content with form feed if needed (optional)
    // writer.write("\f"); // Uncomment if you want actual page breaks
    
    // Write page header
    writer.write(String.format("  R2C12-ACC                             NORFOLK & DEDHAM MUTUAL FIRE INSURANCE COMPANIES             RUN DATE   %s    PAGE    %d", 
            now.format(dateFormatter),
            pageNumber));
    writer.newLine();
    writer.write(String.format("                                        A C C E P T E D   C L A I M S   L I S T                    RUN TIME  %s",
            now.format(timeFormatter)));
    writer.newLine();
    writer.newLine();
    
    // Write column headers
    writer.write("CLAIM      POLICY       PROC  CO         INSUREDS       GP LN  COV -------TRANSACTION------------    LOSS           LOSS");
    writer.newLine();
    writer.write("NUMBER     NUMBER       CNTR  CD           NAME         LN CD   CD TYPE      DESCRIPTION             DATE          AMOUNT");
    writer.newLine();
    writer.newLine();
}
}