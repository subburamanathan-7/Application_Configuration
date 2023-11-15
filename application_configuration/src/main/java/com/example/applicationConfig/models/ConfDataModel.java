package com.example.applicationConfig.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("configurationData")
	public class ConfDataModel {
		@Id
		private String confDataId;
		
	    private String confId;

	    private String userId;

		public enum confTypes{
			INT,
			STRING,
			BOOLEAN
		}
		private confTypes confType;
		
		Integer confIntData;
		String confStrData;
		Boolean confBoolData;
		

		public String getConfDataId() {
			return confDataId;
		}
		public void setConfId(String confId) {
			this.confId = confId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		
		public confTypes getConfType() {
			return confType;
		}
		public void setConfType(confTypes confType) {
			this.confType = confType;
		}
		public Integer getConfIntData() {
			return confIntData;
		}
		public void setConfIntData(Integer confIntData) {
			this.confIntData = confIntData;
		}
		public String getConfStrData() {
			return confStrData;
		}
		public void setConfStrData(String confStrData) {
			this.confStrData = confStrData;
		}
		public Boolean getConfBoolData() {
			return confBoolData;
		}
		public void setConfBoolData(Boolean confBoolData) {
			this.confBoolData = confBoolData;
		}
		public String getConfId() {
			return confId;
		}
		public String getUserId() {
			return userId;
		}
}
