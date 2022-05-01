/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum1.registrationValidator;

import java.util.regex.Pattern;
import javax.faces.validator.FacesValidator;

/**
 * 
 * @author Onur-Can Yaman
 * @version 1.0
 * 
 * 
 */
@FacesValidator("passwordValidator")
public class PasswordValidator extends RegexValidator{

    /**
     * Nachricht, die im Falle einer erfolglosen Validierung zurückgegeben wird,
     * wenn die Komponente nicht selbst eine Fehlermeldung als Attribut 
     * definiert hat.
     * 
     * @return Fehlermeldung
     */
    @Override
    protected String getValidationErrorString() {
        return "Mind. 8 Zeichen; 1 Sonderzeichen; 1 Klein- und Großbuchstaben";
    }

    
    /**
     * 
     * @return 
     */
    @Override
    protected Pattern getRegexPattern() {
        Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&amp;*-]).{8,}$");
        return pattern;
    }
    
}
