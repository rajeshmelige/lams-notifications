package org.egov.lams.notification.model.wrapper;



import org.egov.lams.notification.models.Agreement;
import org.egov.lams.notification.models.RequestInfo;

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
public class AgreementRequest {

	private RequestInfo requestInfo;
	private Agreement agreement;

}
