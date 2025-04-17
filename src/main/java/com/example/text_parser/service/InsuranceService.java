package com.example.text_parser.service;

import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.LinkedHashMap;
import com.example.text_parser.model.InsuranceData;
import com.example.text_parser.repository.InsuranceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class InsuranceService {
	private static final Logger logger = LoggerFactory.getLogger(InsuranceService.class);
    private ParserService parserService=new ParserService();
    private InsuranceRepository insuranceRepository;

    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }


    public boolean processInsuranceData(String dataString) {
        try {
        	dataString=URLDecoder.decode(dataString, StandardCharsets.UTF_8);
            LinkedHashMap<String, Object> dataMap = parserService.search2(dataString);
            InsuranceData obj = new InsuranceData();

            // === String fields ===
            obj.setCompanyName((String) dataMap.get("Company Name"));
            obj.setStateCode((String) dataMap.get("State Code"));
            obj.setItemState((String) dataMap.get("Item State"));
            obj.setBranch((String) dataMap.get("Branch"));
            obj.setProcessCenter((String) dataMap.get("Process Center"));
            obj.setGroupLine((String) dataMap.get("Group Line"));
            obj.setSuserLine((String) dataMap.get("Suser Line"));
            obj.setCoverageCode((String) dataMap.get("Coverage Code"));
            obj.setAgtNumber12((String) dataMap.get("Agt Number 12"));
            obj.setAgtNumber35((String) dataMap.get("Agt Number 35"));
            obj.setAgtSub((String) dataMap.get("Agt Sub"));
            obj.setDacInd((String) dataMap.get("Dac Ind"));
            obj.setBillType1((String) dataMap.get("Bill Type-1"));
            obj.setTransCode((String) dataMap.get("Trans Code"));
            obj.setSource((String) dataMap.get("Source"));
            obj.setPolicyNumber((String) dataMap.get("Policy Number"));
            obj.setDppInstanceNumber((String) dataMap.get("DPP Instance Number"));
            obj.setDppTotalInstance((String) dataMap.get("DPP Total Instance"));
            obj.setCancelReason((String) dataMap.get("Cancel Reason"));
            obj.setCancelType((String) dataMap.get("Cancel Type"));
            obj.setAudit((String) dataMap.get("Audit"));
            obj.setZip1((String) dataMap.get("Zip-1"));
            obj.setZip2((String) dataMap.get("Zip-2"));
            obj.setOrigCompany((String) dataMap.get("Orig Company"));
            obj.setName((String) dataMap.get("Name"));
            obj.setPayOption((String) dataMap.get("Pay Option"));
            obj.setAccNumber((String) dataMap.get("Acc Number"));
            obj.setBatchNumber((String) dataMap.get("Batch Number"));
            obj.setPictureFlag((String) dataMap.get("Picture Flag"));
            obj.setAgMstNum((String) dataMap.get("Ag Mst Num"));
            obj.setAgMstSub((String) dataMap.get("Ag Mst Sub"));
            obj.setDedType((String) dataMap.get("Ded Type"));
            obj.setCspSubline((String) dataMap.get("Csp Subline"));
            obj.setCspPolType((String) dataMap.get("Csp Pol Type"));
            obj.setCspRateId((String) dataMap.get("Csp Rate Id"));
            obj.setCspAnnualStmt((String) dataMap.get("Csp Annual Stmt"));
            obj.setCspCov((String) dataMap.get("Csp Cov"));
            obj.setCspCarBillForm((String) dataMap.get("Csp Car Bill Form"));
            obj.setClassCode((String) dataMap.get("Class Code"));
            obj.setReinType((String) dataMap.get("Rein Type"));
            obj.setReinCompany((String) dataMap.get("Rein Company"));
            obj.setReinContract((String) dataMap.get("Rein Contract"));
            obj.setCedeReason((String) dataMap.get("Cede Reason"));
            obj.setReinsInd((String) dataMap.get("Reins Ind"));
            obj.setFiller1((String) dataMap.get("Filler-1"));
            obj.setItemNo((String) dataMap.get("Item No"));
            obj.setTermShort((String) dataMap.get("Term Short"));
            obj.setSex((String) dataMap.get("Sex"));
            obj.setLicNum((String) dataMap.get("Lic Num"));
            obj.setLicState((String) dataMap.get("Lic State"));
            obj.setStateCdSave((String) dataMap.get("State Cd Save"));
            obj.setNetCovProTolSw((String) dataMap.get("Net Cov Pro Tol Sw"));
            obj.setFiveEndNum((String) dataMap.get("5 End Num"));
            obj.setBillType2((String) dataMap.get("Bill Type-2"));
            obj.setLeadPoisonCov((String) dataMap.get("Lead Poison Cov"));
            obj.setTotItems((String) dataMap.get("Tot Items"));
            obj.setNumRenewCommInd((String) dataMap.get("Num Renew Comm Ind"));
            obj.setFiller2((String) dataMap.get("Filler-2"));
            obj.setRandom((String) dataMap.get("Random"));
            obj.setPcb10Cov110Sw((String) dataMap.get("Pcb10 Cov 110 Sw"));
            obj.setPcb10Cov151Sw((String) dataMap.get("Pcb10 Cov 151 Sw"));
            obj.setClaimOcc((String) dataMap.get("Claim Occ"));
            obj.setAccidentCode((String) dataMap.get("Accident Code"));
            obj.setAccidentState((String) dataMap.get("Accident State"));
            obj.setCatastropheNumber((String) dataMap.get("Catastrophe Number"));
            obj.setCauseLoss1((String) dataMap.get("Cause Loss-1"));
            obj.setTypeLoss((String) dataMap.get("Type Loss"));
            obj.setExcessLossInd((String) dataMap.get("Excess Loss Ind"));
            obj.setSuperNumber((String) dataMap.get("Super Number"));
            obj.setAdjusterNumber((String) dataMap.get("Adjuster Number"));
            obj.setDraftNumber((String) dataMap.get("Draft Number"));
            obj.setDraftIrs((String) dataMap.get("Draft Irs"));
            obj.setOrigPayYear((String) dataMap.get("Orig Pay Year"));
            obj.setTypeClaim((String) dataMap.get("Type Claim"));
            obj.setSuitInd((String) dataMap.get("Suit Ind"));
            obj.setTransactionType((String) dataMap.get("Transaction Type"));
            obj.setIndpndtAdj((String) dataMap.get("Indpndt Adj"));
            obj.setNameType((String) dataMap.get("Name Type"));
            obj.setConvClaimInd((String) dataMap.get("Conv Claim Ind"));
            obj.setAdjCaseCount((String) dataMap.get("Adj Case Count"));
            obj.setCauseLoss2((String) dataMap.get("Cause Loss-2"));
            obj.setAppraiserStatus((String) dataMap.get("Appraiser Status"));
            obj.setSiuStatus((String) dataMap.get("Siu Status"));
            obj.setSuitStatus((String) dataMap.get("Suit Status"));
            obj.setSubrStatus((String) dataMap.get("Subr Status"));
            obj.setSuppStatus((String) dataMap.get("Supp Status"));
            obj.setLiabilityInd((String) dataMap.get("Liability Ind"));
            obj.setExperienceRated((String) dataMap.get("Experience Rated"));
            obj.setExcessLimitSw((String) dataMap.get("Excess Limit Sw"));
            obj.setSortCompany((String) dataMap.get("Sort Company"));
            obj.setSortClaimOcc((String) dataMap.get("Sort Claim Occ"));
            obj.setSortGroupLine((String) dataMap.get("Sort Group Line"));
            obj.setSortUserLine((String) dataMap.get("Sort User Line"));
            obj.setSortItemNo((String) dataMap.get("Sort Item No"));
            obj.setSortCoverageCode((String) dataMap.get("Sort Coverage Code"));
            obj.setSortDacInd((String) dataMap.get("Sort Dac Ind"));
            obj.setSortReinCompany((String) dataMap.get("Sort Rein Company"));
            obj.setSortTransCode((String) dataMap.get("Sort Trans Code"));

            // === Dates ===
            obj.setExpDate((Date) dataMap.get("Exp Date"));
            obj.setExpDate((Date) dataMap.get("Eff Date"));
            obj.setActgDate((Date) dataMap.get("Actg Date"));
            obj.setChangeDate((Date) dataMap.get("Change Date"));
            obj.setOrigEffDate((Date) dataMap.get("Orig Eff Date"));
            obj.setBookDate((Date) dataMap.get("Book Date"));
            obj.setBirthDate((Date) dataMap.get("Birth Date"));
            obj.setCspIncepDate((Date) dataMap.get("Csp Incep Date"));
            obj.setLossDate((Date) dataMap.get("Loss Date"));
            obj.setReportedDate((Date) dataMap.get("Reported Date"));
            obj.setActivityDate((Date) dataMap.get("Activity Date"));
            obj.setDraftDate((Date) dataMap.get("Draft Date"));
            obj.setReinspectionDate((Date) dataMap.get("Reinspection Date"));
            obj.setSortActgDate((Date) dataMap.get("Sort Actg Date"));

            // === Example Double ===
            obj.setTerm(parseDouble(dataMap.get("Term")));
            obj.setDppEff(parseLong(dataMap.get("DPP EFF")));
            obj.setDppExp(parseLong(dataMap.get("DPP EXP")));
            obj.setCityCode(parseDouble(dataMap.get("City-Code")));
            obj.setCountryCode(parseDouble(dataMap.get("Country-Code")));
            obj.setLocation(parseDouble(dataMap.get("Location")));
            obj.setRetainedAmt(parseDouble(dataMap.get("Retained Amt")));
            obj.setTerr(parseDouble(dataMap.get("Terr")));
            obj.setExposure(parseDouble(dataMap.get("Exposure")));
            obj.setPolLevelExp(parseDouble(dataMap.get("Pol Level Exp")));
            obj.setInforcePrem(parseDouble(dataMap.get("Inforce Prem")));
            obj.setWrittenPrem(parseDouble(dataMap.get("Written Prem")));
            obj.setLimitAmtPerson(parseDouble(dataMap.get("Limit Amt Person")));
            obj.setDedAmt(parseDouble(dataMap.get("Ded Amt")));
            obj.setCspRatingMod(parseDouble(dataMap.get("Csp Rating Mod")));
            obj.setCspRatingDepart(parseDouble(dataMap.get("Csp Rating Depart")));
            obj.setRetAmt(parseDouble(dataMap.get("Ret Amt")));
            obj.setLimitAmtOccur(parseDouble(dataMap.get("Limit Amt Occur")));
            obj.setDiarySeq(parseDouble(dataMap.get("Diary Seq")));
            obj.setAge(parseDouble(dataMap.get("Age")));
            obj.setDriverNumber(parseDouble(dataMap.get("Driver Number")));
            obj.setAmountDue(parseDouble(dataMap.get("Amount Due")));
            obj.setClaimantNumber(parseDouble(dataMap.get("Claimant Number")));
            obj.setLossAmount(parseDouble(dataMap.get("Loss Amount")));
            obj.setReserveTakenDown(parseDouble(dataMap.get("Reserve Taken Down")));
            obj.setNetChange(parseDouble(dataMap.get("Net Change")));
            obj.setExperienceLiab(parseDouble(dataMap.get("Experience Liab")));
            obj.setExperiencePd(parseDouble(dataMap.get("Experience Pd")));
            obj.setExcessLimit(parseDouble(dataMap.get("Excess Limit")));
            obj.setSortClaimantNumber(parseDouble(dataMap.get("Sort Claimant Number")));
            obj.setOccurNew(parseDouble(dataMap.get("Occur New")));
            obj.setOccurStatus(parseDouble(dataMap.get("Occur Status")));
            obj.setCovNew(parseDouble(dataMap.get("Cov New")));
            obj.setCovStatus(parseDouble(dataMap.get("Cov Status")));
            obj.setClmtNew(parseDouble(dataMap.get("Clmt New")));
            obj.setClmtStatus(parseDouble(dataMap.get("Clmt Status")));
            obj.setDipSpct1(parseDouble(dataMap.get("Dip Spct 1")));
            obj.setMultiSpct1(parseDouble(dataMap.get("Multi Spct 1")));
            obj.setGroupSpct1(parseDouble(dataMap.get("Group Spct 1")));
            obj.setDipSpct2(parseDouble(dataMap.get("Dip Spct 2")));
            obj.setMultiSpct2(parseDouble(dataMap.get("Multi Spct 2")));
            obj.setGroupSpct2(parseDouble(dataMap.get("Group Spct 2")));
            obj.setCommPct(parseDouble(dataMap.get("Comm Pct")));
            obj.setReinPct(parseDouble(dataMap.get("Rein Pct")));

            insuranceRepository.save(obj);
            return true;
        } catch (Exception e) {
        	logger.error("Error Occured : "+e);
        	logger.info(dataString);
//            e.printStackTrace();
            return false;
        }
    }


    private Double parseDouble(Object value) {
        try {
            return value != null ? Double.parseDouble(value.toString()) : null;
        } catch (Exception e) {
            return null;
        }
    }

    private Long parseLong(Object value) {
        try {
            return value != null ? Long.parseLong(value.toString()) : null;
        } catch (Exception e) {
            return null;
        }
    }
}
