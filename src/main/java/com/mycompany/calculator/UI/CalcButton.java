/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator.UI;

import com.mycompany.calculator.CalcCommands.CalcCommand;
import com.mycompany.calculator.CalcCommands.DigitCommand;
import com.mycompany.calculator.Observer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Andrii
 */
public class CalcButton extends JButton {
    protected int _x, _y;
    protected int _width = 1;
    protected Observer observer;
    protected String _text;
    protected CalcCommand command;

    
    public CalcButton(Observer observer, String text, int x, int y, CalcCommand command){
        super(text);
        this._text= text;
        this.observer = observer;
        this._x = x; this._y = y;
        this.command = command;
        
        addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             observer.getNotified(command);
         }
        });
    }
    
    public CalcButton(Observer observer, String text, int x, int y, CalcCommand command, int width){
        this(observer, text, x, y, command);
        this._width = width;
    }
    
    public int get_X(){
        return _x;
    }
    public int get_Y(){
        return _y;
    }
    public int get_Width(){
        return _width;
    }
 
}
