/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import GUI.TemporizadorUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author davsa
 */
public class TemporizadorCtrl implements ActionListener{
    private TemporizadorUI t;
    public TemporizadorCtrl(TemporizadorUI tui) {
        this.t = tui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
