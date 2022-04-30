/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.praktikum1_neu;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cano
 */
public class PasswordHashConverter implements Serializable {
    
     private static final Logger logger
            = Logger.getLogger(PasswordHashConverter.class.getName());

    /**
     * Erzeugt für ein jeweiliges Passwort einen Hashwert
     *
     * @param pwd
     * @return
     */
    public String getPwdHash(String pwd) {
        String hash = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            byte[] digest = md.digest(pwd.getBytes());
            hash = byArrayToHex(digest);
        } catch (NoSuchAlgorithmException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        return hash;
    }

    private String byArrayToHex(byte[] digest) {
        /*
        jedes Byte (-128...127) von digest wird in eine 2-stellige Hex-Zahl
        umgewandelt.
         */
        StringBuilder sb = new StringBuilder(digest.length * 2);
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
}
