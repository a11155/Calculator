/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator.Nodes;

/**
 *
 * @author Andrii
 */
public class Sin implements Node {

    private Node child;
    
    public Sin(Node child){
        this.child = child;
    }
    
    @Override
    public double eval() {
        return Math.sin(child.eval());
    }

    @Override
    public void print() {
        
        System.out.print("sin ");
        child.print();
        
    }
    
}
