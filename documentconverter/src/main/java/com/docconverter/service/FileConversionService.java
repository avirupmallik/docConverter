package com.docconverter.service;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import com.cloudmersive.client.ConvertDocumentApi;
import com.cloudmersive.client.invoker.ApiClient;
import com.cloudmersive.client.invoker.ApiException;
import com.cloudmersive.client.invoker.Configuration;
import com.cloudmersive.client.invoker.auth.ApiKeyAuth;

@Service
public class FileConversionService {

	
	public byte[] fileConversion(String details) {

		ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Apikey

		ApiKeyAuth Apikey = (ApiKeyAuth) defaultClient.getAuthentication("Apikey");

		Apikey.setApiKey("fb7f10a0-0ea3-49c5-8961-8bb6ff3b779d");

		ConvertDocumentApi apiInstance = new ConvertDocumentApi(); 
		byte[] result = null;
		File inputFile = new File(details); // File | Input file to perform the operation on.
		try {
			String extension = FilenameUtils.getExtension(details);
			if(extension.contains("odt")) 
				result = apiInstance.convertDocumentOdtToPdf(inputFile);
			else
		        result = apiInstance.convertDocumentAutodetectToPdf(inputFile);
		     
		} catch (ApiException e) {
		    System.err.println("Exception when calling ConvertDocumentApi#convertDocumentDocToPdf");
		    e.printStackTrace();
		}
		return result;
		
		
	}
}
