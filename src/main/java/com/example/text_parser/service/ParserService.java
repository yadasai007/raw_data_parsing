package com.example.text_parser.service;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
public class ParserService
{
	private boolean contain(String[] array, String value) {
        for (String s : array) {
            if (s.equals(value)) {
                return true;
            }
        }
        return false;
    }
    public LinkedHashMap<String, Object> search2(String searchText) {
    	searchText=URLDecoder.decode(searchText, StandardCharsets.UTF_8);
        final LinkedHashMap<String, Integer> fieldDefinitions = new LinkedHashMap<String,Integer>() {
			private static final long serialVersionUID = 1L;
			{
                put("Company Name", 2);
                put("State Code", 2);
                put("Item State", 2);
                put("Branch", 2);
                put("Process Center", 2);
                put("Group Line", 2);
                put("Suser Line", 2);
                put("Coverage Code", 3);
                put("Agt Number 12", 2);
                put("Agt Number 35", 3);
                put("Agt Sub", 3);
                put("Dac Ind", 1);
                put("Bill Type-1", 1);
                put("Exp Date", 8);
                put("Eff Date", 8);
                put("Term", 3);
                put("Actg Date", 8);
                put("Change Date", 8);
                put("Trans Code", 2);
                put("Source", 2);
                put("Policy Number", 10);
                put("Orig Eff Date", 8);
                put("DPP EFF", 8);
                put("DPP EXP", 8);
                put("DPP Instance Number", 1);
                put("DPP Total Instance", 1);
                put("Book Date", 8);
                put("Cancel Reason", 2);
                put("Cancel Type", 1);
                put("Audit", 1);
                put("Zip-1", 5);
                put("Zip-2", 4);
                put("City-Code", 5);
                put("Country-Code", 5);
                put("Location", 3);
                put("Orig Company", 4);
                put("Name", 20);
                put("Pay Option", 1);
                put("Acc Number", 15);
                put("Batch Number", 4);
                put("Picture Flag", 2);
                put("Retained Amt", 10);
                put("Ag Mst Num", 5);
                put("Ag Mst Sub", 3);
                put("Terr", 6);
                put("Comm Pct", 7);
                put("Exposure", 10);
                put("Pol Level Exp", 10);
                put("Inforce Prem", 11);
                put("Written Prem", 11);
                put("Limit Amt Person", 7);
                put("Ded Type", 2);
                put("Ded Amt", 7);
                put("Csp Subline", 3);
                put("Csp Pol Type", 2);
                put("Csp Rate Id", 1);
                put("Csp Rating Mod", 3);
                put("Csp Rating Depart", 3);
                put("Csp Annual Stmt", 3);
                put("Csp Cov", 3);
                put("Csp Car Bill Form", 3);
                put("Csp Incep Date", 8);
                put("Class Code", 8);
                put("Rein Type", 2);
                put("Rein Company", 4);
                put("Rein Contract", 8);
                put("Rein Pct", 6);
                put("Cede Reason", 2);
                put("Reins Ind", 1);
                put("Filler-1", 1);
                put("Ret Amt", 8);
                put("Limit Amt Occur", 7);
                put("Item No", 3);
                put("Term Short", 1);
                put("Diary Seq", 4);
                put("Birth Date", 8);
                put("Age", 3);
                put("Sex", 1);
                put("Lic Num", 17);
                put("Driver Number", 3);
                put("Lic State", 2);
                put("State Cd Save", 2);
                put("Net Cov Pro Tol Sw", 1);
                put("5 End Num", 8);
                put("Bill Type-2", 2);
                put("Amount Due", 10);
                put("Lead Poison Cov", 1);
                put("Tot Items", 5);
                put("Num Renew Comm Ind", 1);
                put("Filler-2", 2);
                put("Random", 6);
                put("Dip Spct 1", 4);
                put("Multi Spct 1", 4);
                put("Group Spct 1", 4);
                put("Dip Spct 2", 4);
                put("Multi Spct 2", 4);
                put("Group Spct 2", 4);
                put("Pcb10 Cov 110 Sw", 1);
                put("Pcb10 Cov 151 Sw", 1);
                put("Claim Occ", 10);
                put("Loss Date", 8);
                put("Reported Date", 8);
                put("Activity Date", 8);
                put("Accident Code", 3);
                put("Accident State", 2);
                put("Catastrophe Number", 3);
                put("Claimant Number", 3);
                put("Cause Loss-1", 2);
                put("Type Loss", 2);
                put("Excess Loss Ind", 1);
                put("Super Number", 3);
                put("Adjuster Number", 3);
                put("Draft Date", 8);
                put("Draft Number", 10);
                put("Draft Irs", 11);
                put("Loss Amount", 11);
                put("Orig Pay Year", 2);
                put("Type Claim", 1);
                put("Occur New", 1);
                put("Occur Status", 1);
                put("Cov New", 1);
                put("Cov Status", 1);
                put("Clmt New", 2);
                put("Clmt Status", 1);
                put("Suit Ind", 1);
                put("Transaction Type", 3);
                put("Reserve Taken Down", 11);
                put("Net Change", 10);
                put("Indpndt Adj", 3);
                put("Reinspection Date", 8);
                put("Name Type", 2);
                put("Conv Claim Ind", 1);
                put("Adj Case Count", 1);
                put("Cause Loss-2", 2);
                put("Appraiser Status", 1);
                put("Siu Status", 1);
                put("Suit Status", 1);
                put("Subr Status", 1);
                put("Supp Status", 1);
                put("Liability Ind", 1);
                put("Experience Rated", 1);
                put("Experience Liab", 3);
                put("Experience Pd", 3);
                put("Excess Limit Sw", 2);
                put("Excess Limit", 9);
                put("Sort Company", 2);
                put("Sort Claim Occ", 10);
                put("Sort Group Line", 2);
                put("Sort User Line", 2);
                put("Sort Item No", 3);
                put("Sort Coverage Code", 3);
                put("Sort Claimant Number", 3);
                put("Sort Dac Ind", 1);
                put("Sort Rein Company", 4);
                put("Sort Actg Date", 8);
                put("Sort Trans Code", 2);
            }
        };
        String[] stringColumns = { "Company Name", "State Code", "Item State", "Branch", "Process Center",
                "Group Line", "Suser Line", "Coverage Code", "Agt Number 12", "Agt Number 35", "Agt Sub", "Dac Ind",
                "Bill Type-1", "Trans Code", "Source", "Policy Number", "DPP Instance Number", "DPP Total Instance",
                "Cancel Reason", "Cancel Type", "Audit", "Zip-1", "Zip-2", "Orig Company", "Name", "Pay Option",
                "Acc Number", "Batch Number", "Picture Flag", "Ag Mst Num", "Ag Mst Sub", "Ded Type", "Csp Subline",
                "Csp Pol Type", "Csp Rate Id", "Csp Annual Stmt", "Csp Cov", "Csp Car Bill Form", "Class Code",
                "Rein Type", "Rein Company", "Rein Contract", "Cede Reason", "Reins Ind", "Filler-1", "Item No",
                "Term Short", "Sex", "Lic Num", "Lic State", "State Cd Save", "Net Cov Pro Tol Sw", "5 End Num",
                "Bill Type-2", "Lead Poison Cov", "Tot Items", "Num Renew Comm Ind", "Filler-2", "Random",
                "Pcb10 Cov 110 Sw", "Pcb10 Cov 151 Sw", "Claim Occ", "Accident Code", "Accident State",
                "Catastrophe Number", "Cause Loss-1", "Type Loss", "Excess Loss Ind", "Super Number", "Adjuster Number",
                "Draft Number", "Draft Irs", "Orig Pay Year", "Type Claim", "Suit Ind", "Transaction Type",
                "Indpndt Adj", "Name Type", "Conv Claim Ind", "Adj Case Count", "Cause Loss-2", "Appraiser Status",
                "Siu Status", "Suit Status", "Subr Status", "Supp Status", "Liability Ind", "Experience Rated",
                "Excess Limit Sw", "Sort Company", "Sort Claim Occ", "Sort Group Line", "Sort User Line",
                "Sort Item No", "Sort Coverage Code", "Sort Dac Ind", "Sort Rein Company", "Sort Trans Code" };
        String[] dateColumns = { "Exp Date", "Eff Date", "Actg Date", "Change Date", "Orig Eff Date", "Book Date",
                "Birth Date", "Csp Incep Date", "Loss Date", "Reported Date", "Activity Date", "Draft Date",
                "Reinspection Date", "Sort Actg Date" };
        String[] doubleColumns = { "Term", "DPP EFF", "DPP EXP", "City-Code", "Country-Code", "Location",
                "Retained Amt",
                "Terr", "Exposure", "Pol Level Exp", "Inforce Prem", "Written Prem", "Limit Amt Person", "Ded Amt",
                "Csp Rating Mod", "Csp Rating Depart", "Ret Amt", "Limit Amt Occur", "Diary Seq", "Age",
                "Driver Number", "Amount Due", "Claimant Number", "Loss Amount", "Reserve Taken Down", "Net Change",
                "Experience Liab", "Experience Pd", "Excess Limit", "Sort Claimant Number", "Occur New", "Occur Status",
                "Cov New", "Cov Status", "Clmt New", "Clmt Status", "Dip Spct 1", "Multi Spct 1", "Group Spct 1",
                "Dip Spct 2", "Multi Spct 2",
                "Group Spct 2", "Comm Pct", "Rein Pct" };
        LinkedHashMap<String, Object> parsed = new LinkedHashMap<>(fieldDefinitions.size());
        int startIndex = 0;
        int textLength = searchText.length();
        try
        {
            for (Map.Entry<String, Integer> entry : fieldDefinitions.entrySet()) {
                String fieldName = entry.getKey();
                int endIndex = startIndex + entry.getValue();

                if (endIndex > textLength) {
                    endIndex = textLength;
                    if (startIndex >= endIndex)
                        break;
                }

                String stringValue = searchText.substring(startIndex, endIndex);
                Object value;
                if (contain(stringColumns, fieldName)) {
                    value = stringValue;
                } else if (contain(dateColumns, fieldName)) {
                    // Parse as date (you might want to add proper date parsing logic)
                	stringValue = stringValue.replaceAll("[^0-9.-]", "");
                    SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy");
                    Date date=null;
                    if(stringValue.equals("00000000"))
                    {
                    	stringValue="";
                    }
                    else
                    {
                        try {
                            date = formatter.parse(stringValue);
                       } catch (ParseException e) {
                           System.out.println("Invalid date format: " + e.getMessage());
                       }                	
                    }


                    value = date; // or parse to Date object
                } else if (contain(doubleColumns, fieldName)) {
                	stringValue = stringValue.replaceAll("[^0-9.-]", "");
                    value = stringValue.isEmpty() ? 0.0 : Double.parseDouble(stringValue);
                } else {
                    // Default to string if not found in any category
                    value = stringValue;
                }

                parsed.put(fieldName, value);
                startIndex = endIndex;
            }
            System.out.println(parsed);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }

        return parsed;
    }
}