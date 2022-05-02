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
 * Dient zur Validiernug der Telefonnummer
 */

@FacesValidator("phoneValidator")
public class PhoneValidator extends RegexValidator{
    
    @Override
    protected String getValidationErrorString() {
        return "Nummer ungültigawdawd";
    }

    @Override
    protected Pattern getRegexPattern() {
        Pattern pattern = Pattern.compile("\\d+|.{0}");
        return pattern;
    }
    
}
