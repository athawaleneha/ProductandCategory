package com.code.ProductCRUD.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String resName;
	private String fieldName;
	private Object fieldValue;
	
	public ResourceNotFound(String resName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'",resName, fieldName,fieldValue));
		this.resName = resName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getResName() {
		return resName;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public Object getFieldValue() {
		return fieldValue;
	}

	/*public void setResName(String resName) {
		this.resName = resName;
	}*/

	

	/*public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}*/

	

	/*public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}*/
	
}
