/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Modelo.CronometroModel;
import controlador.CronometroCtrl;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author davsa
 */
public class CronometroUI extends JFrame {

    CronometroCtrl ctrl = new CronometroCtrl(this);
    public CronometroModel cm = new CronometroModel(this);
    private Timer t;

    // Componentes
    private JButton btnStart = new JButton();
    private JButton btnStop = new JButton();
    private JButton btnPause = new JButton();
    private JLabel lblTime = new JLabel();
    private JLabel lblTitle = new JLabel();
    private JScrollPane scTimes;
    private JTextArea tiempos = new JTextArea();
    private Font font = new Font("Agency FB", Font.BOLD, 28);

    public CronometroUI() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Cronometro");
        initComponents();
        setVisible(true);
        setSize(600, 400);
        t = new Timer(10, cm.getCronoAcciones());

    }

    private void initComponents() {
        Container c = getContentPane();
        c.setLayout(null);
        scTimes = new JScrollPane(tiempos);
        //agregando componentes al container        
        c.add(lblTitle);
        c.add(lblTime);
        c.add(btnStart);
        c.add(btnPause);
        c.add(btnStop);
        c.add(scTimes);

        // Posicion de los componentes
        lblTitle.setBounds(15, 50, 250, 25);
        lblTime.setBounds(110, 120, 250, 50);
        btnStart.setBounds(40, 200, 90, 25);
        btnPause.setBounds(140, 200, 80, 25);
        btnStop.setBounds(230, 200, 80, 25);
        scTimes.setBounds(320, 120, 150, 150);

        //Setteando texto en los componentes
        lblTitle.setText("CRONOMETRO FIS");
        lblTime.setText("00:00:00:00");
        lblTime.setFont(font);
        btnStart.setText("Iniciar");
        btnPause.setText("Pausar");
        btnStop.setText("Detener");
        //tiempos.setText("Hola mundo");

        // Agregandole el listener a los botones
        btnStart.addActionListener(ctrl);
        btnPause.addActionListener(ctrl);
        btnStop.addActionListener(ctrl);

        btnStart.setEnabled(true);
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);

    }

    /*
     * *********************************************************
     * Getter and Setter de los componentes
    ***********************************************************
     */

    public JButton getBtnStart() {
        return btnStart;
    }

    public JButton getBtnStop() {
        return btnStop;
    }
    
    public JButton getBtnPause() {
        return btnPause;
    }

    public JLabel getLblTime() {
        return lblTime;
    }

    public JTextArea getTiempos() {
        return tiempos;
    }

    public Timer getT() {
        return t;
    }      

}
