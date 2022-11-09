/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.mycompany.calculator;

import com.mycompany.calculator.Nodes.Node;
import com.mycompany.calculator.Nodes.Add;
import com.mycompany.calculator.Nodes.Cos;
import com.mycompany.calculator.Nodes.Divide;
import com.mycompany.calculator.Nodes.DoubleNode;
import com.mycompany.calculator.Nodes.Modulo;
import com.mycompany.calculator.Nodes.Multiply;
import com.mycompany.calculator.Nodes.Negative;
import com.mycompany.calculator.Nodes.Sin;
import com.mycompany.calculator.Nodes.Sqrt;
import com.mycompany.calculator.Nodes.Subtract;
import java.beans.Expression;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
/**
 *
 * @author Andrii
 */


/*

Forms Equation Tree with the following grammar:
E -> T { +/- T }
T -> F { x/÷/% F }
F -> Double | (E) | -F | sin | cos | sqrt


*/
public class EquationParser {
    private char[] equation;
    private int i;
    private String nextToken = null;
    
    public EquationParser(String equation){
       this.equation = equation.toCharArray();
    }
    
    private boolean isDigit(char c){
        return Character.isDigit(c) || c == '.';
    }
    
    private void scanToken(){
        if(i >= equation.length) {
            nextToken = null;
            return;
        }
        
        if(!isDigit(equation[i])){
            
            if(equation[i] == 's'){
                i += 3;
                nextToken = "sin";
                return;
            }
            
            if(equation[i] == 'c'){
                i += 3;
                nextToken = "cos";
                return;
            }
            nextToken = Character.toString(equation[i++]);
            return;
        }
        
        StringBuilder str = new StringBuilder();
        while(i < equation.length && isDigit(equation[i]))
            str.append(equation[i++]);
       
        nextToken = str.toString();
    }
    
    public double evaluate(){
        Node tree = parse();
        
        return tree.eval();
    }
    
    public Node parse(){
        scanToken();
       
        Node tree=  parseE();
        tree.print();
        
        return tree;
        
        
    }
    
    private Node parseE() throws ArithmeticException{
        Node a = parseT();
        while(true){
            if(nextToken == null)
                return a;
            
            if(nextToken.equals("+")){
                scanToken();
                Node b = parseT();
                a = new Add(a, b);
            }
            else if(nextToken.equals("-")){
                scanToken();
                Node b = parseT();
                a = new Subtract(a, b);
            }
            else if(nextToken.equals(")")){
                return a;
            }
            else
            {
                a.print();
                System.out.println("E        " + nextToken);
                throw new ArithmeticException();
            }
        }
    }
    
    private Node parseT(){
        Node a = parseF();
        scanToken();
        while(true){
            if(nextToken == null)
                return a;

            else if(nextToken.equals("x"))
            {
                 scanToken();
                 Node b = parseF();
                 a = new Multiply(a, b);
                 scanToken();
            }
            else if(nextToken.equals("%"))
            {
                 scanToken();
                 Node b = parseF();
                 a = new Modulo(a, b);
                 scanToken();
            }
            else if(nextToken.equals("÷")){
                scanToken();
                Node b = parseF();
                a = new Divide(a, b);
                scanToken();
            }
            else{
                
                return a;
            }
        }
        
        
            
    }
    private Node parseF(){
        if(nextToken == null)
            return null;
        
        if(isDigit(nextToken.charAt(0)))
            return new DoubleNode(Double.parseDouble(nextToken));
     
        else if(nextToken.equals("(")){
            scanToken();
            Node a = parseE();
            
            if(a == null) return null;
            if(nextToken.equals(")")){
                return a;
            }
            else 
                return null;
        }
        else if(nextToken.equals("sin")){
            scanToken();
            return new Sin(parseF());
        }
         else if(nextToken.equals("cos")){
            scanToken();
            return new Cos(parseF());
        }
        else if(nextToken.equals("-")){
            scanToken();
            return new Negative(parseF());
        }
        else if(nextToken.equals("√")){
            scanToken();
            return new Sqrt(parseF());
        }
        
                
        return null;
    }

}
