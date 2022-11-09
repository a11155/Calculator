/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator.ArithmNodes;

/**
 *
 * @author Andrii
 */
public class Sqrt implements Node {

    private Node child;
    
    public Sqrt(Node child){
        this.child = child;
    }
    
    @Override
    public double eval() {
        return Math.sqrt(child.eval());
    }

    @Override
    public void print() {
        
        System.out.print("sqrt ");
        child.print();
        
    }
    
}
