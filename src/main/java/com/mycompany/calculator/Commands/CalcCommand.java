/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.calculator.Commands;

/**
 *
 * @author Andrii
 */
public interface CalcCommand {
    boolean execute(StringBuilder equation);
    
    boolean execute(StringBuilder equation, StringBuilder prevResult, StringBuilder result);
}
