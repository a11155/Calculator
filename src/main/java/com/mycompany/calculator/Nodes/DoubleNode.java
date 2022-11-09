/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator.Nodes;

/**
 *
 * @author Andrii
 */
public class DoubleNode implements Node{
    private double value;
    
    public DoubleNode(double d){
        value = d;
    }
    @Override 
    public void print(){
        System.out.print(value);
    }
    @Override
    public double eval() {
        return value;
    }
    
}
