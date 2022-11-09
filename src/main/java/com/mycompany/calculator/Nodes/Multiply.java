/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator.Nodes;

/**
 *
 * @author Andrii
 */
public class Multiply implements Node {

    private Node leftChild, rightChild;
    
    public Multiply(Node left, Node right){
        this.leftChild = left;
        this.rightChild = right;
    }
    
    @Override
    public double eval() {
        return leftChild.eval() * rightChild.eval();
    }

    @Override
    public void print() {
        
        System.out.print("(");
        leftChild.print();
        System.out.print("*");
        rightChild.print();
        System.out.print(")");
        
        
    }
    
}
