/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import GUI.CronometroUI;
import GUI.TemporizadorUI;
import Modelo.CronometroModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.Timer;

/**
 *
 * @author davsa
 */
public class CronometroCtrl implements ActionListener {

    private CronometroUI c;
    private CronometroModel cm;

    public CronometroCtrl(CronometroUI cui) {
        this.c = cui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == c.getBtnStart()) {
            c.getT().start();
            c.getBtnStart().setEnabled(false);
            c.getBtnStart().setText("Reanudar");
            c.getBtnPause().setEnabled(true);
            c.getBtnStop().setEnabled(true);

        }
        if (e.getSource() == c.getBtnPause()) {
            c.getT().stop();
            c.getBtnStart().setEnabled(true);
            c.getBtnPause().setEnabled(false);

        }
        if (e.getSource() == c.getBtnStop()) {
            int contador = 0;
            if (c.getT().isRunning()) {
                c.getT().stop();
                c.getBtnStart().setEnabled(true);
            }
            c.getBtnStart().setText("Iniciar");
            c.getBtnPause().setEnabled(false);
            c.getBtnStop().setEnabled(false);
            Stack<String> pila = new Stack<String>();
            pila.push(c.getLblTime().getText());
            c.cm.setH(0);
            c.cm.setM(0);
            c.cm.setS(0);
            c.cm.setCs(0);
            c.cm.actualizarLabel();
            while (!pila.isEmpty()) { // mostrar pila completa
                c.getTiempos().setText(c.getTiempos().getText() + "\n"  + "- " + pila.pop());
            }

        }

    }

}
