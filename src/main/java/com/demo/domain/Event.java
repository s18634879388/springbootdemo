package com.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Event {
	

	private String AppId;
	

	private String UnionUserId;


	private String RelatedUserId;
	
	//String	事件名
	private String EvtEnName;
	
	// String(DateTime) 事件时间 24小时制
	private String EvtTime;
	
	//Double	事件时间对应的时间戳
	private Long EvtStamp;
	
	//String	设备号
	private String EquipmentNum;
	
	//String	帖子id、新闻id等任务唯一字段
	private String EntryId;

	//Boolean  是否已经补全了信息
	private Boolean IsImprovedAll;
	@JsonProperty("IsImprovedAll")
//	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	public Boolean getIsImprovedAll() {
		return IsImprovedAll;
	}

	public void setIsImprovedAll(Boolean improvedAll) {
		IsImprovedAll = improvedAll;
	}

	@JsonProperty("AppId")
//	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	public String getAppId() {
		return AppId;
	}

	public void setAppId(String appId) {
		AppId = appId;
	}

	@JsonProperty("UnionUserId")
//	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	public String getUnionUserId() {
		return UnionUserId;
	}

	public void setUnionUserId(String unionUserId) {
		UnionUserId = unionUserId;
	}

	@JsonProperty("RelatedUserId")
//	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	public String getRelatedUserId() {
		return RelatedUserId;
	}

	public void setRelatedUserId(String relatedUserId) {
		RelatedUserId = relatedUserId;
	}

	@JsonProperty("EvtEnName")
//	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	public String getEvtEnName() {
		return EvtEnName;
	}

	public void setEvtEnName(String evtEnName) {
		EvtEnName = evtEnName;
	}

	@JsonProperty("EvtTime")
//	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	public String getEvtTime() {
		return EvtTime;
	}

	public void setEvtTime(String evtTime) {
		EvtTime = evtTime;
	}

	@JsonProperty("EvtStamp")
//	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	public Long getEvtStamp() {
		return EvtStamp;
	}

	public void setEvtStamp(Long evtStamp) {
		EvtStamp = evtStamp;
	}

//	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	@JsonProperty("EquipmentNum")
	public String getEquipmentNum() {
		return EquipmentNum;
	}

	public void setEquipmentNum(String equipmentNum) {
		EquipmentNum = equipmentNum;
	}

//	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	@JsonProperty("EntryId")
	public String getEntryId() {
		return EntryId;
	}

	public void setEntryId(String entryId) {
		EntryId = entryId;
	}
	

}
