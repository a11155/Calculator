/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator.ArithmNodes;

/**
 *
 * @author Andrii
 */
public class Cos implements Node {

    private Node child;
    
    public Cos(Node child){
        this.child = child;
    }
    
    @Override
    public double eval() {
        return Math.cos(child.eval());
    }

    @Override
    public void print() {
        
        System.out.print("cos ");
        child.print();
        
    }
    
}
