/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import GUI.TemporizadorUI;
import Modelo.TemporizadorModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author davsa
 */
public class TemporizadorCtrl implements ActionListener {

    private TemporizadorUI t;
    private Timer timer;
    private boolean isTimerRunning;
    private TemporizadorModel tm;

    public TemporizadorCtrl(TemporizadorUI tui) {
        this.t = tui;
        this.timer = new Timer();
        this.tm = new TemporizadorModel();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == t.getBtnStart()) {
            if (!isInteger(t.getTxtHour().getText())) {
                JOptionPane.showMessageDialog(null, "No es un numero");
                return;
            }
            int hour = Integer.parseInt(t.getTxtHour().getText());
            tm.setHour(hour);
            if (!isInteger(t.getTxtMin().getText())) {
                JOptionPane.showMessageDialog(null, "No es un numero");
                return;
            }
            int min = Integer.parseInt(t.getTxtMin().getText());
            tm.setMinute(min);
            if (!isInteger(t.getTxtSec().getText())) {
                JOptionPane.showMessageDialog(null, "No es un numero");
                return;
            }
            int sec = Integer.parseInt(t.getTxtSec().getText());
            tm.setSecond(sec);
            start(0, 1000);
        }

    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            isTimerRunning = true;
            if (tm.second > 0) {
                tm.second--;
            } else {
                tm.second = 59;
                if (tm.minute > 0) {
                    tm.minute--;
                } else {
                    tm.minute = 59;
                    if (tm.hour > 0) {
                        tm.hour--;
                    } // si segundo = 0, minuto = 0 y hora = 0,
                    // cancelamos el timer
                    else {
                        isTimerRunning = false;
                        timer.cancel();
                        timer.purge();
                    }
                }
            }
            if (isTimerRunning) {
                String time = tm.formatTime(tm.hour, tm.minute, tm.second);
                t.getLblTime().setText(time);
            }
        }
    }; // fin timertask

    public void start(int timeout, int interval) {
        timer.schedule(task, timeout, interval);
    }
    
    private boolean isInteger(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
