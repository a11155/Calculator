/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator.Commands;

/**
 *
 * @author Andrii
 */
public class EvalCommand implements CalcCommand{
    
    @Override
    public boolean execute(StringBuilder equation) {
        if(equation.isEmpty())
            return false;
        return true;
    }

   
    @Override
    public boolean execute(StringBuilder equation, StringBuilder prevResult, StringBuilder result) {
        return execute(equation);
    }
    
}
