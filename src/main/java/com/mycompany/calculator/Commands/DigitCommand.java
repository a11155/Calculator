/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator.Commands;

/**
 *
 * @author Andrii
 */
public class DigitCommand implements CalcCommand {

    private String digit; 
    
    public DigitCommand(String digit){
        this.digit = digit;
    }
    
    @Override
    public boolean execute(StringBuilder equation) {
        equation.append(digit);
        return true;
    }

    @Override
    public boolean execute(StringBuilder equation, StringBuilder prevResult, StringBuilder result) {
        return execute(equation);
    }
    
}
