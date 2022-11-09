/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator.Commands;

/**
 *
 * @author Andrii
 */
public class RemoveCommand implements CalcCommand {

    @Override
    public boolean execute(StringBuilder equation) {
        
        if (equation.length() == 0) return false;
        
        if(equation.charAt(equation.length()-1) == 'n' ||
                equation.charAt(equation.length() - 1) == 's')
        {
            equation.setLength(equation.length() - 3);
            return true;
          
        }    
        equation.setLength(equation.length() - 1);
          
        return true;
    }

    
    @Override
    public boolean execute(StringBuilder equation, StringBuilder prevResult, StringBuilder result) {
        return execute(equation);
    }
    
}
