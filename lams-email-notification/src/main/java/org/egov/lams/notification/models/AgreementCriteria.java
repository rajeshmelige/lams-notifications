package org.egov.lams.notification.models;

import java.util.Date;
import java.util.List;

import org.egov.lams.notification.model.enums.Status;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AgreementCriteria {

	 private String tenantId;
	 private List<Long> agreementId;
	 private String agreementNumber;
	 private String tenderNumber;
	 
	 @JsonFormat(pattern="dd/MM/yyyy")
	 private Date fromDate;
	 
	 @JsonFormat(pattern="dd/MM/yyyy")
	 private Date toDate;
	 private Status status;
	 private String tinNumber;
	 private String tradelicenseNumber;
	 private Long assetCategory;
	 private String shoppingComplexNo;
	 private String assetCode;
	 private Long locality;
	 private Long revenueWard;
	 private Long electionWard;
	 private Long doorno;
	 private String allotteeName;
	 private Long mobilenumber;
	 private String offSet;
	 private String size;
	
	/* @Setter(onMethod=@__(@JsonIgnore))
	 @JsonIgnore*/
	 private List<Long> asset;
	 private List<Long> allottee;
}
