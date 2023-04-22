package com.DelaCasa;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class Encriptar {
    
    public static void main(String[] args) {
        var codigo= new BCryptPasswordEncoder();
        System.out.println("Juan (123):"+codigo.encode("123"));
        System.out.println("Rebeca (456):"+codigo.encode("456"));
        System.out.println("Pedro (789):"+codigo.encode("789"));
        
    }
    
}
