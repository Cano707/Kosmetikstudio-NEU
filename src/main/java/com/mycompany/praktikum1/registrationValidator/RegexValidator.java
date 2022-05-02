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
 * @author Onur-Can Yaman
 * 
 * Abstrakte Klasse zur Validierung von Eingabedaten
 * via RegEx, die von Validatoren implementiert wird
 */
public abstract class RegexValidator implements Validator {
    
    /**
     * Validierungsfunktion, die - bei erfolgloser Validierung -
     * ein Exception wirft, und somit die Fehlermeldung an 
     * die Client-Side schickt.
     * 
     * @param fc: Der Context 
     * @param uic: Die Komponente, die evtl. die zeigende Fehlermeldung enthält.
     * @param obj: Die Eingabedaten
     * @throws ValidatorException 
     */
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
    
    /**
     * Prüft, ob die Komponente eine eigene Fehlermeldung enthält. 
     * Wenn ja, dann wird diese zurückgegeben, falls nicht, dann wird
     * jene in der Implementierung von "getValidationErrorString" genutzt.
     * 
     * @param uic
     * @return 
     */
    private String getValidatorMessage(UIComponent uic) {
        String validatorMsg = ((UIInput) uic).getValidatorMessage();
        return validatorMsg != null ? validatorMsg : getValidationErrorString();
    }
    
    /**
     * Gibt die Fehlermeldung zurück, die dem Benutzer angezeigt werden soll.
     * @return 
     */
    protected abstract String getValidationErrorString();
    
    /**
     * Gib die RegEx zurück, die zur Validierung genutzt werden soll. 
     * @return 
     */
    protected abstract Pattern getRegexPattern();
    
}
