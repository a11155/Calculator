/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator.Panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Andrii
 */
public class PrevResultPanel extends JPanel {       
    private final String DEFAULT = "0.0";
    
    private final JLabel result;
    
    
    
    public PrevResultPanel(){
        result = new JLabel(DEFAULT);
        add(result);
    }
    
    public void setResult(String newResult){
       
        if(newResult.equals(""))
            clear();
        else
            result.setText(newResult + " = ");
    }
    
    
    public void clear(){
        result.setText(DEFAULT);
    }
    
}
