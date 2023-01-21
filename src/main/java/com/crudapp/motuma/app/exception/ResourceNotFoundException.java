package com.crudapp.motuma.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//We have to annotate ResourceNotFoundException with @ResponseStatus.
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends  RuntimeException{
    //This is usefull if there is any change happened on this class for serrialization and desirialization
    private static final long serialVersionUID=1L;
    private String resourceName;
    private String fieldname;
    private Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldname, Object fieldValue) {
        super(String.format("%S not found with %S: '%S'",resourceName,fieldname,fieldValue));
        this.resourceName = resourceName;
        this.fieldname = fieldname;
        this.fieldValue = fieldValue;
    }
    public  String getResourceName(){
        return resourceName;
    }
    public  String getFieldname(){
        return  fieldname;
    }
    public  Object getFieldValue(){
        return fieldValue;
    }
}
