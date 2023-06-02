/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.analizadorsintatico;

/**
 *
 * @author user
 */
public class AnalizadorSintatico {
private static String newString = "";
private static int newPosition = 0;
private static int newError = 0;

private static boolean expression() {
    return term() && expression_();
}

private static boolean expression_() {
    if (newPosition < newString.length() && newString.charAt(newPosition) == '+') {
        newPosition++;
        return term() && expression_();
    }
    return true;
}

private static boolean term() {
    return factor() && term_();
}

private static boolean term_() {
    if (newPosition < newString.length() && newString.charAt(newPosition) == '*') {
        newPosition++;
        return factor() && term_();
    }
    return true;
}

private static boolean factor() {
    if (newPosition < newString.length() && newString.charAt(newPosition) == '(') {
        newPosition++;
        boolean result = expression() && newString.charAt(newPosition++) == ')';
        return result;
    } else if (newPosition < newString.length() && newString.charAt(newPosition) == 'i') {
        newPosition++;
        return true;
    }
    return false;
}
public static void main(String[] args) {
    newString = "Lor";
    String[] newStrings = {
        "Lor", "em", "ipsum", "dolor", "sit", "amet", "con", "sec", "t", "e", "t", "ur", "adi", "pis", "cing", "el", "it"
};

    for (String e : newStrings) {
        newString = e;
        newPosition = 0;
        newError = 0;
        if (expression() && newPosition == newString.length() && newError == 0) {
            System.out.println("La cadena [ " + e + " ] es válida");
        } else {
            System.out.println("La cadena [ " + e + " ] es inválida");
        }
    }
}

    }



