package com.attraction.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class AttractionDescription {
	
	private int contentId;
	private String homepage;
	private String overview;
	private String telname;
	
}
