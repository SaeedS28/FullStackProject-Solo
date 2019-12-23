package com.fdmgroup.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"ReturnCode","Type","AdditionalInfo"})
public class ApiStatus {
	private String code;
	private String message;
	private String additionalInformation;
	
	public ApiStatus(String code, String message, String additionalInformation) {
		super();
		this.code = code;
		this.message = message;
		this.additionalInformation = additionalInformation;
	}

	@JsonProperty("ReturnCode")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty("Type")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("AdditionalInfo")
	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	@Override
	public String toString() {
		return "ApiStatus [code=" + code + ", message=" + message + ", additionalInformation=" + additionalInformation
				+ "]";
	}
	
	
	
}
