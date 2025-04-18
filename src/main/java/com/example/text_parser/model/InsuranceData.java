package com.example.text_parser.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor // Required by JPA
@AllArgsConstructor
@Builder // For object creation using builder pattern
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
}