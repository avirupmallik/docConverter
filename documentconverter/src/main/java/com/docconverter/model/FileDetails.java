package com.docconverter.model;

import java.util.Base64;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class FileDetails {

	private int fileId;
	
	private String fileName;
	
	private String fileType;
	
}
