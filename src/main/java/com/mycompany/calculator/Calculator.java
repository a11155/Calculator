/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.calculator;

import com.mycompany.calculator.Panels.DigitPanel;
import com.mycompany.calculator.Panels.ResultPanel;
import com.mycompany.calculator.Panels.PrevResultPanel;
import com.mycompany.calculator.Commands.CalcCommand;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Andrii
 */
public class Calculator extends JFrame implements Observer {

    final private  DigitPanel digitPanel;
    final private ResultPanel resultPanel;
    final private PrevResultPanel prevResultPanel;
    final private EquationHolder equationHolder;
    
    
   public static void main(String[] args) {
        new Calculator();
    }
    
    public Calculator(){
        digitPanel = new DigitPanel(this);
        resultPanel = new ResultPanel();
        prevResultPanel = new PrevResultPanel();
        equationHolder = new EquationHolder();
        
       getContentPane().setLayout(
        new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)
    );

        getContentPane().add(prevResultPanel);
        getContentPane().add(resultPanel);
        getContentPane().add(digitPanel);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        pack();
        setVisible(true);
        
    } 

    // Get notified when a button is pressed from digitPanel
    @Override
    public void getNotified(CalcCommand command) {
        try{
        equationHolder.execute(command); 
        prevResultPanel.setResult(equationHolder.getPrevResult());
        resultPanel.setResult(equationHolder.getResult());
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    
  
}
