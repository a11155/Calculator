/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator;

import com.mycompany.calculator.CalcCommands.CalcCommand;
import com.mycompany.calculator.CalcCommands.EvalCommand;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;

/**
 *
 * @author Andrii
 */
class EquationHolder {
    
    private StringBuilder equation;
    private String result;
    private String prevResult;
    
    
    public EquationHolder(){
        
        result = "";
        prevResult = "";
        equation = new StringBuilder();
    }
    
    private boolean evaluate() {
        prevResult = result;
        
        
        
        try{
        double parsedResult = new EquationParser(equation.toString()).evaluate();
        
        result = Double.toString(parsedResult);
        
        equation.setLength(0);
        }catch(Exception e){
            equation.setLength(0);
            
            result = "Error";
            
            
            return false;
        }        
        
        return true;
        
    }
    
    
    
    public boolean execute(CalcCommand command){
        
        if (command instanceof EvalCommand){
                if(command.execute(equation) && evaluate())
                    return true;
                return false;
                
            
        }
        
        
        command.execute(equation);
        
        result = equation.toString();
         
        
        return true;
       
    }
    
    
    public String getResult(){
        return result;
    }
    
    public String getPrevResult(){
        return prevResult;
    }
    
}
