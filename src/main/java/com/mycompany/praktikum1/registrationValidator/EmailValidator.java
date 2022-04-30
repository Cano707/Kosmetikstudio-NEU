/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum1.registrationValidator;

import java.util.regex.Pattern;
import javax.faces.validator.FacesValidator;

/**
 *
 * @author cano
 */
@FacesValidator("emailValidator")
public class EmailValidator extends RegexValidator {

    @Override
    protected String getValidationErrorString() {
        return "E-Mail ungültig";
    }

    @Override
    protected Pattern getRegexPattern() {
        Pattern pattern = Pattern.compile("[\\w\\d]+@[\\w\\d]+.[\\w\\d]+|\\s*");
        return pattern;
    }
    
}
