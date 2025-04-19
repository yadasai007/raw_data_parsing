package com.example.text_parser.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.example.text_parser.model.NpsData;
import com.example.text_parser.repository.NpsRepository;
import com.example.text_parser.utils.ReportSection;
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
	public void npmDataToFile() throws IOException {
	    String filePath = "results\\nps_data.txt";
	    List<NpsData> entities = npsDataRepository.findAll();
	    entities.sort(Comparator.comparing(NpsData::getClaimNumber));
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	        // Get current date and time for the report
	        LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yy");
	        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mma");
	        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yy");
	        int pageNumber = 1;
	        int entityCount = 0;
	        
	        // Write header for first page
	        writeNpsDataHeader(writer, now, dateFormatter, timeFormatter, pageNumber);
	        
	        // Write data
	        for (NpsData entity : entities) {
	            // Check if we need a new page (before writing the next record)
	            if (entityCount > 0 && entityCount % 51 == 0) {
	                pageNumber++;
	                writer.newLine();
	                writeNpsDataHeader(writer, now, dateFormatter, timeFormatter, pageNumber);
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
	public void amountToFile() throws IOException
	{
		String filePath = "results\\amounts_data.txt";
	    List<NpsData> entities = npsDataRepository.findAll();
	    Double[] directPriorAmounts= {17976518.00,6244142.23,3392414.11,1166970.07,1836642.53,40616686.94,0.00};
	    Long[] directPriorCounts= {2316L,390L,4247L,4016L,647L,0L,0L};
	    Double[] cededPriorAmounts= {148500.00,136700.00,0.00,0.00,117400.79,402600.79,0.00};
	    Long[] cededPriorCounts= {20L,4L,8L,0L,24L,0L,0L};
	    List<Double> cededCurrentAmounts = IntStream.range(0, 7)
	    	    .mapToObj(i -> 0.00)
	    	    .collect(Collectors.toList());

	    List<Long> cededCurrentCounts= IntStream.range(0, 7)
	    	    .mapToObj(i -> 0L)
	    	    .collect(Collectors.toList());
	    Set<String> amount1TransactionCodes = Set.of("01", "11");
	    Set<String> amount2TransactionCodes = Set.of("21");
	    Set<String> amount3TransactionCodes = Set.of("31","41","51","61");
	    Set<String> amount4TransactionCodes = Set.of("53","54","55","56");
	    Set<String> amount5TransactionCodes = Set.of("72", "82","87","92");
	    Set<String> amount6TransactionCodes = entities.stream()
	    	    .map(NpsData::getTransactionCode)  
	    	    .filter(code -> !"84".equals(code))  
	    	    .collect(Collectors.toSet());
	    Set<String> amount7TransactionCodes = Set.of();
	    List<Set<String>> listOfSets = List.of(amount1TransactionCodes, amount2TransactionCodes,amount3TransactionCodes,amount4TransactionCodes,amount5TransactionCodes,amount6TransactionCodes,amount7TransactionCodes);
	    List<Double> directCurrentAmounts = listOfSets.stream()
	    	    .map(set -> entities.stream()
	    	        .filter(entity -> set.contains(entity.getTransactionCode()))
	    	        .mapToDouble(NpsData::getLossAmount)
	    	        .sum()
	    	    )
	    	    .collect(Collectors.toList());
	    List<Long> directCurrentCounts = listOfSets.stream()
	    	    .map(set -> entities.stream()
	    	        .filter(entity -> set.contains(entity.getTransactionCode()))
	    	        .count() // Counts the number of matching entities
	    	    )
	    	    .collect(Collectors.toList());
	    directCurrentCounts.set(5, 0L);
	    Double totalSum = entities.stream()
	    	    .mapToDouble(NpsData::getLossAmount)  // Extract loss_amount as double
	    	    .sum();
	    Double cededAmount=totalSum-directCurrentAmounts.get(5);
	    Long cededCount = entities.stream()
	    	    .filter(entity -> "84".equals(entity.getTransactionCode()))
	    	    .count();

	    cededCurrentAmounts.set(4, cededAmount);
	    cededCurrentAmounts.set(5, cededAmount);
	    cededCurrentCounts.set(4, cededCount);
	    List<Double> grandCurrentAmounts = IntStream.range(0, Math.min(directCurrentAmounts.size(), cededCurrentAmounts.size()))
	    	    .mapToObj(i -> directCurrentAmounts.get(i) - cededCurrentAmounts.get(i))
	    	    .collect(Collectors.toList());
	    List<Long> grandCurrentCounts = IntStream.range(0, Math.min(directCurrentCounts.size(), cededCurrentCounts.size()))
	    	    .mapToObj(i -> directCurrentCounts.get(i) + cededCurrentCounts.get(i))
	    	    .collect(Collectors.toList());
	    Double[] grandPriorAmounts = new Double[directPriorAmounts.length];
	    for (int i = 0; i < directPriorAmounts.length; i++) {
	    	grandPriorAmounts[i] = directPriorAmounts[i] - cededPriorAmounts[i];
	    }
	    Long[] grandPriorCounts = new Long[directPriorCounts.length];
	    for (int i = 0; i < directPriorCounts.length; i++) {
	    	grandPriorCounts[i] = directPriorCounts[i] + cededPriorCounts[i];
	    }
	    System.out.println(directCurrentCounts);
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	        // Get current date and time for the report
	        LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yy");
	        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mma");
	        
	        // Define report sections with their data sources
	        List<ReportSection> sections = Arrays.asList(
	            new ReportSection("DIRECT", directPriorAmounts, directPriorCounts, directCurrentAmounts, directCurrentCounts),
	            new ReportSection("ASSUMED", null, null, null, null), // Zero values
	            new ReportSection("CEDED", cededPriorAmounts, cededPriorCounts, cededCurrentAmounts, cededCurrentCounts),
	            new ReportSection("GRAND", grandPriorAmounts, grandPriorCounts, grandCurrentAmounts, grandCurrentCounts)
	        );
	        
	        // Process each section
	        for (ReportSection section : sections) {
	        	
	            writeAmountDataHeader(writer, now, dateFormatter, timeFormatter, section.getName());
	            
	            // Write amounts
	            for (int i = 1; i <= directCurrentAmounts.size(); i++) {
	                double priorAmount = section.hasData() ? section.getPriorAmounts()[i-1] : 0.0;
	                double currentAmount = section.hasData() ? section.getCurrentAmounts().get(i-1) : 0.0;
	                
	                writer.write(String.format(
	                    "AMOUNT %-3d %26.2f %28.2f %26.2f%n",
	                    i, priorAmount, currentAmount, priorAmount + currentAmount
	                ));
	            }
	            
	            // Write counts
	            for (int i = 1; i <= directCurrentCounts.size(); i++) {
	                Long priorCount = section.hasData() ? section.getPriorCounts()[i-1] : 0;
	                Long currentCount = section.hasData() ? section.getCurrentCounts().get(i-1) : 0;
	                
	                writer.write(String.format(
	                    "COUNT %-3d %27d %28d %26d%n",
	                    i, priorCount, currentCount, priorCount + currentCount
	                ));
	            }
	            
	            writer.newLine();
	            writeAmountDataFooter(writer);
	        }
	    }		
	}
	private void writeAmountDataFooter(BufferedWriter writer) throws IOException
	{
		writer.write("**  CLAIM AMOUNTS  **                               **  CLAIM COUNTS  **");
		writer.newLine();
		writer.newLine();
		writer.write("AMOUNT  1 LOSS AMOUNT-NEW LOSS                      COUNT  1 NEW LOSS");
		writer.newLine();
		writer.write("AMOUNT  2 LOSS AMOUNT-RESERVE CHANGE                COUNT  2 RESERVE CHANGE");
		writer.newLine();
		writer.write("AMOUNT  3 LOSS AMOUNT-PAYMENTS                      COUNT  3 PAYMENTS");
		writer.newLine();
		writer.write("AMOUNT  4 LOSS AMOUNT-EXPENSES                      COUNT  4 EXPENSES");
		writer.newLine();
		writer.write("AMOUNT  5 LOSS AMOUNT-ALL OTHERS                    COUNT  5 ALL OTHERS");
		writer.newLine();
		writer.write("AMOUNT  6 TOTAL LOSS AMOUNT                          COUNT  6 LOSS AMOUNT");
		writer.newLine();
		writer.write("AMOUNT  7 TOTAL 'ZZ' AMOUNT                         COUNT  7 TOTAL 'ZZ' COUNT");
		writer.newLine();
		
		
	}
	
	private void writeAmountDataHeader(BufferedWriter writer, LocalDateTime now, 
	                           DateTimeFormatter dateFormatter, 
	                           DateTimeFormatter timeFormatter,
	                           String type
	                           ) throws IOException {
	    
	    // Write page header
	    writer.write(String.format("  R2C12-SUM   %-7s  CLAIMS   TOTAL                  NORFOLK & DEDHAM MUTUAL FIRE INSURANCE COMPANIESRUN DATE    %s    PAGE    ", 
	            type,
	    		now.format(dateFormatter)));
	    writer.newLine();
	    writer.write(String.format("                                                         M T D    CLAIMS STAT UPDATE            RUN TIME  %s",
	            now.format(timeFormatter)));
	    writer.newLine();
	    writer.newLine();
	    
	    // Write column headers
	    writer.write("                          PRIOR TOTAL       +        CURRENT UPDATE        =         TOTAL");
	    writer.newLine();
	    writer.newLine();
	}
	private void writeNpsDataHeader(BufferedWriter writer, LocalDateTime now, 
            DateTimeFormatter dateFormatter, 
            DateTimeFormatter timeFormatter, 
            int pageNumber) throws IOException 
	{

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
