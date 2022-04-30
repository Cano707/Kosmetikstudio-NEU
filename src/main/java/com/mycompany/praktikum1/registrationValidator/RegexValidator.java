/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum1.registrationValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author cano
 */
public abstract class RegexValidator implements Validator {
    
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object obj) throws ValidatorException {
        
        if (obj == null || "".equals(obj)) {
            FacesMessage msg = new FacesMessage(getValidatorMessage(uic));
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        
        String input = (String) obj;
        
        Matcher matcher = getRegexPattern().matcher(input);
        
        
        
        if(!matcher.matches()) {
            FacesMessage msg = new FacesMessage(getValidatorMessage(uic));
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        
    }
    
    private String getValidatorMessage(UIComponent uic) {
        String validatorMsg = ((UIInput) uic).getValidatorMessage();
        return validatorMsg != null ? validatorMsg : getValidationErrorString();
    }
    
    protected abstract String getValidationErrorString();
    
    protected abstract Pattern getRegexPattern();
    
}
