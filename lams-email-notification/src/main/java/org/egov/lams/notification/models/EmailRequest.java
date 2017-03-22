package org.egov.lams.notification.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class EmailRequest {

	    @JsonProperty("email")
	    private String email = null;

	    @JsonProperty("subject")
	    private String subject = null;

	    @JsonProperty("body")
	    private String body = null;

	    @JsonProperty("sender")
	    private String sender = null;

	    
}
