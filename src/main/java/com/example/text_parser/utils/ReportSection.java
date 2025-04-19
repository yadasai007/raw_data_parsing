package com.example.text_parser.utils;
import java.util.List;

public class ReportSection {
    String name;
    Double[] priorAmounts;
    Long[] priorCounts;
    List<Double> currentAmounts;
    List<Long> currentCounts;
    
    public ReportSection(String name, Double[] priorAmounts, Long[] priorCounts, 
                       List<Double> currentAmounts, List<Long> currentCounts) {
        this.name = name;
        this.priorAmounts = priorAmounts;
        this.priorCounts = priorCounts;
        this.currentAmounts = currentAmounts;
        this.currentCounts = currentCounts;
    }
    
    public boolean hasData() {
        return priorAmounts != null && priorCounts != null && 
               currentAmounts != null && currentCounts != null;
    }
    public String getName()
    {
    	return this.name;
    }
    
    public Double[] getPriorAmounts()
    {
    	return this.priorAmounts;
    }
    
    public Long[] getPriorCounts()
    {
    	return this.priorCounts;
    }
    public List<Double> getCurrentAmounts()
    {
    	return this.currentAmounts;
    }
    
    public List<Long> getCurrentCounts()
    {
    	return this.currentCounts;
    }
}