package com.example.applicationConfig.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document("configurations")
public class ConfModel{

	
	@Id
    private String confId;
	private String confName;
	@NonNull
	private Boolean confStatus;
	
	public String getConfId() {

		return confId;
	}
	public String getConfName() {
		return confName;
	}
	public void setConfName(String confName) {
		this.confName = confName;
	}
	public Boolean getConfStatus() {
		return confStatus;
	}
	public void setConfStatus(Boolean confStatus) {
		this.confStatus = confStatus;
	}

}
