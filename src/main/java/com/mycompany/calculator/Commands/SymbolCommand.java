/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator.Commands;

/**
 *
 * @author Andrii
 */
public class SymbolCommand implements CalcCommand{
    
    private String symbol; 
    
    public SymbolCommand(String symbol){
        this.symbol = symbol;
    }
    
    @Override
    public boolean execute(StringBuilder equation) {
        if(equation.length() == 0) return false;
        
        if(!Character.isDigit(equation.charAt(equation.length()- 1)) &&
                equation.charAt(equation.length() - 1) != '(' &&
                equation.charAt(equation.length() - 1) != ')')
            return false;
            
        equation.append(symbol);
        return true;
    }

  
    @Override
    public boolean execute(StringBuilder equation, StringBuilder prevResult, StringBuilder result) {
        return execute(equation);
    }
}
    
