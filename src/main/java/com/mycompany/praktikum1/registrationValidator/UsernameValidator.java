/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum1.registrationValidator;

import com.mycompany.praktikum1.registrationValidator.RegexValidator;
import java.util.regex.Pattern;
import javax.faces.validator.FacesValidator;

/**
 *
 * @author Onur-Can Yaman
 * @version 1.0
 * 
 * Dient zur Validierung des Benutzernamens
 */
@FacesValidator("usernameValidator")
public class UsernameValidator extends RegexValidator {

    @Override
    protected String getValidationErrorString() {
        return "Benutzername ungültig";
    }

    @Override
    protected Pattern getRegexPattern() {
        Pattern pattern = Pattern.compile("^[a-z0-9_-]{3,15}$");
        return pattern;
    }
    
}
