/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.calculator;

import com.mycompany.calculator.Commands.CalcCommand;

/**
 *
 * @author Andrii
 */
public interface Observer {
    void getNotified(CalcCommand str);
}
