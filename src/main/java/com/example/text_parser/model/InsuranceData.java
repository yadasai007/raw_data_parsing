package com.example.text_parser.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity

public class InsuranceData {
	
    private String companyName;
    private String stateCode;
    private String itemState;
    private String branch;
    private String processCenter;
    private String groupLine;
    private String suserLine;
    private String coverageCode;
    private String agtNumber12;
    private String agtNumber35;
    private String agtSub;
    private String dacInd;
    private String billType1;
    @Temporal(TemporalType.DATE)
    private Date expDate;
    @Temporal(TemporalType.DATE)
    private Date effDate;
    private Double term;
    @Temporal(TemporalType.DATE)
    private Date actgDate;
    @Temporal(TemporalType.DATE)
    private Date changeDate;
    private String transCode;
    private String source;
    private String policyNumber;
    @Temporal(TemporalType.DATE)
    private Date origEffDate;
    private Long dppEff;
    private Long dppExp;
    private String dppInstanceNumber;
    private String dppTotalInstance;
    @Temporal(TemporalType.DATE)
    private Date bookDate;
    private String cancelReason;
    private String cancelType;
    private String audit;
    private String zip1;
    private String zip2;
    private Double cityCode;
    private Double countryCode;
    private Double location;
    private String origCompany;
    private String name;
    private String payOption;
    private String accNumber;
    private String batchNumber;
    private String pictureFlag;
    private Double retainedAmt;
    private String agMstNum;
    private String agMstSub;
    private Double terr;
    private Double commPct;
    private Double exposure;
    private Double polLevelExp;
    private Double inforcePrem;
    private Double writtenPrem;
    private Double limitAmtPerson;
    private String dedType;
    private Double dedAmt;
    private String cspSubline;
    private String cspPolType;
    private String cspRateId;
    private Double cspRatingMod;
    private Double cspRatingDepart;
    private String cspAnnualStmt;
    private String cspCov;
    private String cspCarBillForm;
    @Temporal(TemporalType.DATE)
    private Date cspIncepDate;
    private String classCode;
    private String reinType;
    private String reinCompany;
    private String reinContract;
    private Double reinPct;
    private String cedeReason;
    private String reinsInd;
    private String filler1;
    private Double retAmt;
    private Double limitAmtOccur;
    private String itemNo;
    private String termShort;
    private Double diarySeq;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    private Double age;
    private String sex;
    private String licNum;
    private Double driverNumber;
    private String licState;
    private String stateCdSave;
    private String netCovProTolSw;
    private String fiveEndNum;
    private String billType2;
    private Double amountDue;
    private String leadPoisonCov;
    private String totItems;
    private String numRenewCommInd;
    private String filler2;
    private String random;
    private Double dipSpct1;
    private Double multiSpct1;
    private Double groupSpct1;
    private Double dipSpct2;
    private Double multiSpct2;
    private Double groupSpct2;
    private String pcb10Cov110Sw;
    private String pcb10Cov151Sw;
    private String claimOcc;
    @Temporal(TemporalType.DATE)
    private Date lossDate;
    @Temporal(TemporalType.DATE)
    private Date reportedDate;
    @Temporal(TemporalType.DATE)
    private Date activityDate;
    private String accidentCode;
    private String accidentState;
    private String catastropheNumber;
    private Double claimantNumber;
    private String causeLoss1;
    private String typeLoss;
    private String excessLossInd;
    private String superNumber;
    private String adjusterNumber;
    @Temporal(TemporalType.DATE)
    private Date draftDate;
    private String draftNumber;
    private String draftIrs;
    private Double lossAmount;
    private String origPayYear;
    private String typeClaim;
    private Double occurNew;
    private Double occurStatus;
    private Double covNew;
    private Double covStatus;
    private Double clmtNew;
    private Double clmtStatus;
    private String suitInd;
    private String transactionType;
    private Double reserveTakenDown;
    private Double netChange;
    private String indpndtAdj;
    @Temporal(TemporalType.DATE)
    private Date reinspectionDate;
    private String nameType;
    private String convClaimInd;
    private String adjCaseCount;
    private String causeLoss2;
    private String appraiserStatus;
    private String siuStatus;
    private String suitStatus;
    private String subrStatus;
    private String suppStatus;
    private String liabilityInd;
    private String experienceRated;
    private Double experienceLiab;
    private Double experiencePd;
    private String excessLimitSw;
    private Double excessLimit;
    private String sortCompany;
    private String sortClaimOcc;
    private String sortGroupLine;
    private String sortUserLine;
    private String sortItemNo;
    private String sortCoverageCode;
    private Double sortClaimantNumber;
    private String sortDacInd;
    private String sortReinCompany;
    @Temporal(TemporalType.DATE)
    private Date sortActgDate;
    private String sortTransCode;
    
   
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_Id")
	private Integer customerId;
    
    // Getters and Setters
    public Integer getCustomerId()
    {
    return this.customerId;
    }
    
    public void setCustomerId(Integer customerId)
    {
    	this.customerId=customerId;
    }   
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getItemState() {
        return itemState;
    }

    public void setItemState(String itemState) {
        this.itemState = itemState;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getProcessCenter() {
        return processCenter;
    }

    public void setProcessCenter(String processCenter) {
        this.processCenter = processCenter;
    }

    public String getGroupLine() {
        return groupLine;
    }

    public void setGroupLine(String groupLine) {
        this.groupLine = groupLine;
    }

    public String getSuserLine() {
        return suserLine;
    }

    public void setSuserLine(String suserLine) {
        this.suserLine = suserLine;
    }

    public String getCoverageCode() {
        return coverageCode;
    }

    public void setCoverageCode(String coverageCode) {
        this.coverageCode = coverageCode;
    }

    public String getAgtNumber12() {
        return agtNumber12;
    }

    public void setAgtNumber12(String agtNumber12) {
        this.agtNumber12 = agtNumber12;
    }

    public String getAgtNumber35() {
        return agtNumber35;
    }

    public void setAgtNumber35(String agtNumber35) {
        this.agtNumber35 = agtNumber35;
    }

    public String getAgtSub() {
        return agtSub;
    }

    public void setAgtSub(String agtSub) {
        this.agtSub = agtSub;
    }

    public String getDacInd() {
        return dacInd;
    }

    public void setDacInd(String dacInd) {
        this.dacInd = dacInd;
    }

    public String getBillType1() {
        return billType1;
    }

    public void setBillType1(String billType1) {
        this.billType1 = billType1;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public Double getTerm() {
        return term;
    }

    public void setTerm(Double term) {
        this.term = term;
    }

    public Date getActgDate() {
        return actgDate;
    }

    public void setActgDate(Date actgDate) {
        this.actgDate = actgDate;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Date getOrigEffDate() {
        return origEffDate;
    }

    public void setOrigEffDate(Date origEffDate) {
        this.origEffDate = origEffDate;
    }

    public Long getDppEff() {
        return dppEff;
    }

    public void setDppEff(Long dppEff) {
        this.dppEff = dppEff;
    }

    public Long getDppExp() {
        return dppExp;
    }

    public void setDppExp(Long dppExp) {
        this.dppExp = dppExp;
    }

    public String getDppInstanceNumber() {
        return dppInstanceNumber;
    }

    public void setDppInstanceNumber(String dppInstanceNumber) {
        this.dppInstanceNumber = dppInstanceNumber;
    }

    public String getDppTotalInstance() {
        return dppTotalInstance;
    }

    public void setDppTotalInstance(String dppTotalInstance) {
        this.dppTotalInstance = dppTotalInstance;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getCancelType() {
        return cancelType;
    }

    public void setCancelType(String cancelType) {
        this.cancelType = cancelType;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public String getZip1() {
        return zip1;
    }

    public void setZip1(String zip1) {
        this.zip1 = zip1;
    }

    public String getZip2() {
        return zip2;
    }

    public void setZip2(String zip2) {
        this.zip2 = zip2;
    }

    public Double getCityCode() {
        return cityCode;
    }

    public void setCityCode(Double cityCode) {
        this.cityCode = cityCode;
    }

    public Double getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Double countryCode) {
        this.countryCode = countryCode;
    }

    public Double getLocation() {
        return location;
    }

    public void setLocation(Double location) {
        this.location = location;
    }

    public String getOrigCompany() {
        return origCompany;
    }

    public void setOrigCompany(String origCompany) {
        this.origCompany = origCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayOption() {
        return payOption;
    }

    public void setPayOption(String payOption) {
        this.payOption = payOption;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getPictureFlag() {
        return pictureFlag;
    }

    public void setPictureFlag(String pictureFlag) {
        this.pictureFlag = pictureFlag;
    }

    public Double getRetainedAmt() {
        return retainedAmt;
    }

    public void setRetainedAmt(Double retainedAmt) {
        this.retainedAmt = retainedAmt;
    }

    public String getAgMstNum() {
        return agMstNum;
    }

    public void setAgMstNum(String agMstNum) {
        this.agMstNum = agMstNum;
    }

    public String getAgMstSub() {
        return agMstSub;
    }

    public void setAgMstSub(String agMstSub) {
        this.agMstSub = agMstSub;
    }

    public Double getTerr() {
        return terr;
    }

    public void setTerr(Double terr) {
        this.terr = terr;
    }

    public Double getCommPct() {
        return commPct;
    }

    public void setCommPct(Double commPct) {
        this.commPct = commPct;
    }

    public Double getExposure() {
        return exposure;
    }

    public void setExposure(Double exposure) {
        this.exposure = exposure;
    }

    public Double getPolLevelExp() {
        return polLevelExp;
    }

    public void setPolLevelExp(Double polLevelExp) {
        this.polLevelExp = polLevelExp;
    }

    public Double getInforcePrem() {
        return inforcePrem;
    }

    public void setInforcePrem(Double inforcePrem) {
        this.inforcePrem = inforcePrem;
    }

    public Double getWrittenPrem() {
        return writtenPrem;
    }

    public void setWrittenPrem(Double writtenPrem) {
        this.writtenPrem = writtenPrem;
    }

    public Double getLimitAmtPerson() {
        return limitAmtPerson;
    }

    public void setLimitAmtPerson(Double limitAmtPerson) {
        this.limitAmtPerson = limitAmtPerson;
    }

    public String getDedType() {
        return dedType;
    }

    public void setDedType(String dedType) {
        this.dedType = dedType;
    }

    public Double getDedAmt() {
        return dedAmt;
    }

    public void setDedAmt(Double dedAmt) {
        this.dedAmt = dedAmt;
    }

    public String getCspSubline() {
        return cspSubline;
    }

    public void setCspSubline(String cspSubline) {
        this.cspSubline = cspSubline;
    }

    public String getCspPolType() {
        return cspPolType;
    }

    public void setCspPolType(String cspPolType) {
        this.cspPolType = cspPolType;
    }

    public String getCspRateId() {
        return cspRateId;
    }

    public void setCspRateId(String cspRateId) {
        this.cspRateId = cspRateId;
    }

    public Double getCspRatingMod() {
        return cspRatingMod;
    }

    public void setCspRatingMod(Double cspRatingMod) {
        this.cspRatingMod = cspRatingMod;
    }

    public Double getCspRatingDepart() {
        return cspRatingDepart;
    }

    public void setCspRatingDepart(Double cspRatingDepart) {
        this.cspRatingDepart = cspRatingDepart;
    }

    public String getCspAnnualStmt() {
        return cspAnnualStmt;
    }

    public void setCspAnnualStmt(String cspAnnualStmt) {
        this.cspAnnualStmt = cspAnnualStmt;
    }

    public String getCspCov() {
        return cspCov;
    }

    public void setCspCov(String cspCov) {
        this.cspCov = cspCov;
    }

    public String getCspCarBillForm() {
        return cspCarBillForm;
    }

    public void setCspCarBillForm(String cspCarBillForm) {
        this.cspCarBillForm = cspCarBillForm;
    }

    public Date getCspIncepDate() {
        return cspIncepDate;
    }

    public void setCspIncepDate(Date cspIncepDate) {
        this.cspIncepDate = cspIncepDate;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getReinType() {
        return reinType;
    }

    public void setReinType(String reinType) {
        this.reinType = reinType;
    }

    public String getReinCompany() {
        return reinCompany;
    }

    public void setReinCompany(String reinCompany) {
        this.reinCompany = reinCompany;
    }

    public String getReinContract() {
        return reinContract;
    }

    public void setReinContract(String reinContract) {
        this.reinContract = reinContract;
    }

    public Double getReinPct() {
        return reinPct;
    }

    public void setReinPct(Double reinPct) {
        this.reinPct = reinPct;
    }

    public String getCedeReason() {
        return cedeReason;
    }

    public void setCedeReason(String cedeReason) {
        this.cedeReason = cedeReason;
    }

    public String getReinsInd() {
        return reinsInd;
    }

    public void setReinsInd(String reinsInd) {
        this.reinsInd = reinsInd;
    }

    public String getFiller1() {
        return filler1;
    }

    public void setFiller1(String filler1) {
        this.filler1 = filler1;
    }

    public Double getRetAmt() {
        return retAmt;
    }

    public void setRetAmt(Double retAmt) {
        this.retAmt = retAmt;
    }

    public Double getLimitAmtOccur() {
        return limitAmtOccur;
    }

    public void setLimitAmtOccur(Double limitAmtOccur) {
        this.limitAmtOccur = limitAmtOccur;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getTermShort() {
        return termShort;
    }

    public void setTermShort(String termShort) {
        this.termShort = termShort;
    }

    public Double getDiarySeq() {
        return diarySeq;
    }

    public void setDiarySeq(Double diarySeq) {
        this.diarySeq = diarySeq;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLicNum() {
        return licNum;
    }

    public void setLicNum(String licNum) {
        this.licNum = licNum;
    }

    public Double getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(Double driverNumber) {
        this.driverNumber = driverNumber;
    }

    public String getLicState() {
        return licState;
    }

    public void setLicState(String licState) {
        this.licState = licState;
    }

    public String getStateCdSave() {
        return stateCdSave;
    }

    public void setStateCdSave(String stateCdSave) {
        this.stateCdSave = stateCdSave;
    }

    public String getNetCovProTolSw() {
        return netCovProTolSw;
    }

    public void setNetCovProTolSw(String netCovProTolSw) {
        this.netCovProTolSw = netCovProTolSw;
    }

    public String getFiveEndNum() {
        return fiveEndNum;
    }

    public void setFiveEndNum(String fiveEndNum) {
        this.fiveEndNum = fiveEndNum;
    }

    public String getBillType2() {
        return billType2;
    }

    public void setBillType2(String billType2) {
        this.billType2 = billType2;
    }

    public Double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(Double amountDue) {
        this.amountDue = amountDue;
    }

    public String getLeadPoisonCov() {
        return leadPoisonCov;
    }

    public void setLeadPoisonCov(String leadPoisonCov) {
        this.leadPoisonCov = leadPoisonCov;
    }

    public String getTotItems() {
        return totItems;
    }

    public void setTotItems(String totItems) {
        this.totItems = totItems;
    }

    public String getNumRenewCommInd() {
        return numRenewCommInd;
    }

    public void setNumRenewCommInd(String numRenewCommInd) {
        this.numRenewCommInd = numRenewCommInd;
    }

    public String getFiller2() {
        return filler2;
    }

    public void setFiller2(String filler2) {
        this.filler2 = filler2;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public Double getDipSpct1() {
        return dipSpct1;
    }

    public void setDipSpct1(Double dipSpct1) {
        this.dipSpct1 = dipSpct1;
    }

    public Double getMultiSpct1() {
        return multiSpct1;
    }

    public void setMultiSpct1(Double multiSpct1) {
        this.multiSpct1 = multiSpct1;
    }

    public Double getGroupSpct1() {
        return groupSpct1;
    }

    public void setGroupSpct1(Double groupSpct1) {
        this.groupSpct1 = groupSpct1;
    }

    public Double getDipSpct2() {
        return dipSpct2;
    }

    public void setDipSpct2(Double dipSpct2) {
        this.dipSpct2 = dipSpct2;
    }

    public Double getMultiSpct2() {
        return multiSpct2;
    }

    public void setMultiSpct2(Double multiSpct2) {
        this.multiSpct2 = multiSpct2;
    }

    public Double getGroupSpct2() {
        return groupSpct2;
    }

    public void setGroupSpct2(Double groupSpct2) {
        this.groupSpct2 = groupSpct2;
    }

    public String getPcb10Cov110Sw() {
        return pcb10Cov110Sw;
    }

    public void setPcb10Cov110Sw(String pcb10Cov110Sw) {
        this.pcb10Cov110Sw = pcb10Cov110Sw;
    }

    public String getPcb10Cov151Sw() {
        return pcb10Cov151Sw;
    }

    public void setPcb10Cov151Sw(String pcb10Cov151Sw) {
        this.pcb10Cov151Sw = pcb10Cov151Sw;
    }

    public String getClaimOcc() {
        return claimOcc;
    }

    public void setClaimOcc(String claimOcc) {
        this.claimOcc = claimOcc;
    }

    public Date getLossDate() {
        return lossDate;
    }

    public void setLossDate(Date lossDate) {
        this.lossDate = lossDate;
    }

    public Date getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(Date reportedDate) {
        this.reportedDate = reportedDate;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public String getAccidentCode() {
        return accidentCode;
    }

    public void setAccidentCode(String accidentCode) {
        this.accidentCode = accidentCode;
    }

    public String getAccidentState() {
        return accidentState;
    }

    public void setAccidentState(String accidentState) {
        this.accidentState = accidentState;
    }

    public String getCatastropheNumber() {
        return catastropheNumber;
    }

    public void setCatastropheNumber(String catastropheNumber) {
        this.catastropheNumber = catastropheNumber;
    }

    public Double getClaimantNumber() {
        return claimantNumber;
    }

    public void setClaimantNumber(Double claimantNumber) {
        this.claimantNumber = claimantNumber;
    }

    public String getCauseLoss1() {
        return causeLoss1;
    }

    public void setCauseLoss1(String causeLoss1) {
        this.causeLoss1 = causeLoss1;
    }

    public String getTypeLoss() {
        return typeLoss;
    }

    public void setTypeLoss(String typeLoss) {
        this.typeLoss = typeLoss;
    }

    public String getExcessLossInd() {
        return excessLossInd;
    }

    public void setExcessLossInd(String excessLossInd) {
        this.excessLossInd = excessLossInd;
    }

    public String getSuperNumber() {
        return superNumber;
    }

    public void setSuperNumber(String superNumber) {
        this.superNumber = superNumber;
    }

    public String getAdjusterNumber() {
        return adjusterNumber;
    }

    public void setAdjusterNumber(String adjusterNumber) {
        this.adjusterNumber = adjusterNumber;
    }

    public Date getDraftDate() {
        return draftDate;
    }

    public void setDraftDate(Date draftDate) {
        this.draftDate = draftDate;
    }

    public String getDraftNumber() {
        return draftNumber;
    }

    public void setDraftNumber(String draftNumber) {
        this.draftNumber = draftNumber;
    }

    public String getDraftIrs() {
        return draftIrs;
    }

    public void setDraftIrs(String draftIrs) {
        this.draftIrs = draftIrs;
    }

    public Double getLossAmount() {
        return lossAmount;
    }

    public void setLossAmount(Double lossAmount) {
        this.lossAmount = lossAmount;
    }

    public String getOrigPayYear() {
        return origPayYear;
    }

    public void setOrigPayYear(String origPayYear) {
        this.origPayYear = origPayYear;
    }

    public String getTypeClaim() {
        return typeClaim;
    }

    public void setTypeClaim(String typeClaim) {
        this.typeClaim = typeClaim;
    }

    public Double getOccurNew() {
        return occurNew;
    }

    public void setOccurNew(Double occurNew) {
        this.occurNew = occurNew;
    }

    public Double getOccurStatus() {
        return occurStatus;
    }

    public void setOccurStatus(Double occurStatus) {
        this.occurStatus = occurStatus;
    }

    public Double getCovNew() {
        return covNew;
    }

    public void setCovNew(Double covNew) {
        this.covNew = covNew;
    }

    public Double getCovStatus() {
        return covStatus;
    }

    public void setCovStatus(Double covStatus) {
        this.covStatus = covStatus;
    }

    public Double getClmtNew() {
        return clmtNew;
    }

    public void setClmtNew(Double clmtNew) {
        this.clmtNew = clmtNew;
    }

    public Double getClmtStatus() {
        return clmtStatus;
    }

    public void setClmtStatus(Double clmtStatus) {
        this.clmtStatus = clmtStatus;
    }

    public String getSuitInd() {
        return suitInd;
    }

    public void setSuitInd(String suitInd) {
        this.suitInd = suitInd;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getReserveTakenDown() {
        return reserveTakenDown;
    }

    public void setReserveTakenDown(Double reserveTakenDown) {
        this.reserveTakenDown = reserveTakenDown;
    }

    public Double getNetChange() {
        return netChange;
    }

    public void setNetChange(Double netChange) {
        this.netChange = netChange;
    }

    public String getIndpndtAdj() {
        return indpndtAdj;
    }

    public void setIndpndtAdj(String indpndtAdj) {
        this.indpndtAdj = indpndtAdj;
    }

    public Date getReinspectionDate() {
        return reinspectionDate;
    }

    public void setReinspectionDate(Date reinspectionDate) {
        this.reinspectionDate = reinspectionDate;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getConvClaimInd() {
        return convClaimInd;
    }

    public void setConvClaimInd(String convClaimInd) {
        this.convClaimInd = convClaimInd;
    }

    public String getAdjCaseCount() {
        return adjCaseCount;
    }

    public void setAdjCaseCount(String adjCaseCount) {
        this.adjCaseCount = adjCaseCount;
    }

    public String getCauseLoss2() {
        return causeLoss2;
    }

    public void setCauseLoss2(String causeLoss2) {
        this.causeLoss2 = causeLoss2;
    }

    public String getAppraiserStatus() {
        return appraiserStatus;
    }

    public void setAppraiserStatus(String appraiserStatus) {
        this.appraiserStatus = appraiserStatus;
    }

    public String getSiuStatus() {
        return siuStatus;
    }

    public void setSiuStatus(String siuStatus) {
        this.siuStatus = siuStatus;
    }

    public String getSuitStatus() {
        return suitStatus;
    }

    public void setSuitStatus(String suitStatus) {
        this.suitStatus = suitStatus;
    }

    public String getSubrStatus() {
        return subrStatus;
    }

    public void setSubrStatus(String subrStatus) {
        this.subrStatus = subrStatus;
    }

    public String getSuppStatus() {
        return suppStatus;
    }

    public void setSuppStatus(String suppStatus) {
        this.suppStatus = suppStatus;
    }

    public String getLiabilityInd() {
        return liabilityInd;
    }

    public void setLiabilityInd(String liabilityInd) {
        this.liabilityInd = liabilityInd;
    }

    public String getExperienceRated() {
        return experienceRated;
    }

    public void setExperienceRated(String experienceRated) {
        this.experienceRated = experienceRated;
    }

    public Double getExperienceLiab() {
        return experienceLiab;
    }

    public void setExperienceLiab(Double experienceLiab) {
        this.experienceLiab = experienceLiab;
    }

    public Double getExperiencePd() {
        return experiencePd;
    }

    public void setExperiencePd(Double experiencePd) {
        this.experiencePd = experiencePd;
    }

    public String getExcessLimitSw() {
        return excessLimitSw;
    }

    public void setExcessLimitSw(String excessLimitSw) {
        this.excessLimitSw = excessLimitSw;
    }

    public Double getExcessLimit() {
        return excessLimit;
    }

    public void setExcessLimit(Double excessLimit) {
        this.excessLimit = excessLimit;
    }

    public String getSortCompany() {
        return sortCompany;
    }

    public void setSortCompany(String sortCompany) {
        this.sortCompany = sortCompany;
    }

    public String getSortClaimOcc() {
        return sortClaimOcc;
    }

    public void setSortClaimOcc(String sortClaimOcc) {
        this.sortClaimOcc = sortClaimOcc;
    }

    public String getSortGroupLine() {
        return sortGroupLine;
    }

    public void setSortGroupLine(String sortGroupLine) {
        this.sortGroupLine = sortGroupLine;
    }

    public String getSortUserLine() {
        return sortUserLine;
    }

    public void setSortUserLine(String sortUserLine) {
        this.sortUserLine = sortUserLine;
    }

    public String getSortItemNo() {
        return sortItemNo;
    }

    public void setSortItemNo(String sortItemNo) {
        this.sortItemNo = sortItemNo;
    }

    public String getSortCoverageCode() {
        return sortCoverageCode;
    }

    public void setSortCoverageCode(String sortCoverageCode) {
        this.sortCoverageCode = sortCoverageCode;
    }

    public Double getSortClaimantNumber() {
        return sortClaimantNumber;
    }

    public void setSortClaimantNumber(Double sortClaimantNumber) {
        this.sortClaimantNumber = sortClaimantNumber;
    }

    public String getSortDacInd() {
        return sortDacInd;
    }

    public void setSortDacInd(String sortDacInd) {
        this.sortDacInd = sortDacInd;
    }

    public String getSortReinCompany() {
        return sortReinCompany;
    }

    public void setSortReinCompany(String sortReinCompany) {
        this.sortReinCompany = sortReinCompany;
    }

    public Date getSortActgDate() {
        return sortActgDate;
    }

    public void setSortActgDate(Date sortActgDate) {
        this.sortActgDate = sortActgDate;
    }

    public String getSortTransCode() {
        return sortTransCode;
    }

    public void setSortTransCode(String sortTransCode) {
        this.sortTransCode = sortTransCode;
    }
}