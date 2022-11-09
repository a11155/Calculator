/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator.CalcCommands;

/**
 *
 * @author Andrii
 */
public class ClearCommand implements CalcCommand {


    
    @Override
    public boolean execute(StringBuilder equation) {
        equation.setLength(0);
        return true;
    }

    @Override
    public boolean execute(StringBuilder equation, StringBuilder prevResult, StringBuilder result) {
       execute(equation);
       prevResult.setLength(0);
       result.setLength(0);
       
       return true;
    
    }
    
}
