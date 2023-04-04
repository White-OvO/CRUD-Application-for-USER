package com.example.users.exception;
@ResponseStatus(value = HTTPStatus.NOT_FOUND)
public class resouceNotFoundExceotion extends RunTimeException{
	private String resourceName;
	private String filedName;
	private object fieldValue;
	
	//error block
	
	
	//constructor 
	public ResourceNotFoundException(String, resourceName, string fieldName, object fieldValue) {
		super(St0ring.format("%s not found with %s: %d", resourceName, fieldName, fieldValue));
	//Creates something when a ID that is not found is  until something that is in the database is inputed
		
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		
	}
	// getter for methods , we are setting it to save this info to users
	public String getResourceName() { 
		return resourceName;
		
	}
	
	public String getFieldName() {
		return fieldName;
		
	}
	public Object getFieldValue() { 
		return fieldValue;
	
}
	
	
	
}
