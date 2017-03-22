package org.egov.lams.notification.models;

import java.util.Date;

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
public class RentIncrementType {

	private Long id;
	private String type;
	private String assetCategory;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fromDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date toDate;
	private Double percentage;
	private Double flatAmount;

}
