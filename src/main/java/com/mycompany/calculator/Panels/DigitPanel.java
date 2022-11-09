/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator.Panels;

import com.mycompany.calculator.UI.CalcButton;
import com.mycompany.calculator.CalcCommands.CalcCommand;
import com.mycompany.calculator.CalcCommands.EvalCommand;
import com.mycompany.calculator.CalcCommands.ClearCommand;
import com.mycompany.calculator.CalcCommands.DigitCommand;
import com.mycompany.calculator.CalcCommands.RemoveCommand;
import com.mycompany.calculator.CalcCommands.SymbolCommand;
import com.mycompany.calculator.Observer;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Andrii
 */
public class DigitPanel extends JPanel implements Observer {
    private Observer observer;
    
    
    private CalcButton[] buttons = {

        new CalcButton(this, "C", 0, 0, new ClearCommand()),
        new CalcButton(this, "(", 1, 0, new DigitCommand("(")),
        new CalcButton(this, ")", 2, 0, new DigitCommand(")")),
        new CalcButton(this, "Del", 3, 0, new RemoveCommand()),
        new CalcButton(this, "÷", 4, 0, new SymbolCommand("÷")),
        new CalcButton(this, "7", 0, 1, new DigitCommand("7")),
        new CalcButton(this, "8", 1, 1, new DigitCommand("8")),
        new CalcButton(this, "9", 2, 1, new DigitCommand("9")),
        new CalcButton(this, "x", 4, 1, new SymbolCommand("x")),
        new CalcButton(this, "sin", 3, 1, new DigitCommand("sin")),
        new CalcButton(this, "4", 0, 2, new DigitCommand("4")),
        new CalcButton(this, "5", 1, 2, new DigitCommand("5")),
        new CalcButton(this, "6", 2, 2, new DigitCommand("6")),
        new CalcButton(this, "-", 4, 2, new DigitCommand("-")),
        new CalcButton(this, "cos", 3, 2, new DigitCommand("cos")),
        new CalcButton(this, "1", 0, 3, new DigitCommand("1")),
        new CalcButton(this, "2", 1, 3, new DigitCommand("2")),
        new CalcButton(this, "3", 2, 3, new DigitCommand("3")),
        new CalcButton(this, "√", 3, 3, new DigitCommand("√")),
        new CalcButton(this, "+", 4, 3, new SymbolCommand("+")),
        new CalcButton(this, ".", 0, 4, new SymbolCommand(".")),
        new CalcButton(this, "0", 1, 4, new DigitCommand("0")),
        new CalcButton(this, "%", 2, 4, new SymbolCommand("%")),
        new CalcButton(this, "=", 3, 4, new EvalCommand(), 2),
        
        
    }; 
    
    
    public DigitPanel(Observer observer){
        this.observer = observer;
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        for(CalcButton button : buttons){
            gbc.gridx = button.get_X();
            gbc.gridy = button.get_Y();
            gbc.gridwidth = button.get_Width();
            
            add(button, gbc);
        }
        
                
    }

    @Override
    public void getNotified(CalcCommand equation) {
        observer.getNotified(equation);
    }
}
