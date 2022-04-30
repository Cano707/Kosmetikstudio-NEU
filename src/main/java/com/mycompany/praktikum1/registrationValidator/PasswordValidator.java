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
@FacesValidator("passwordValidator")
public class PasswordValidator extends RegexValidator{

    @Override
    protected String getValidationErrorString() {
        return "Mind. 8 Zeichen; 1 Sonderzeichen; 1 Klein- und Großbuchstaben";
    }

    @Override
    protected Pattern getRegexPattern() {
        Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&amp;*-]).{8,}$");
        return pattern;
    }
    
}
