/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controlador.TemporizadorCtrl;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author davsa
 */
public class TemporizadorUI extends JFrame {

    TemporizadorCtrl ctrl = new TemporizadorCtrl(this);

    private JLabel lblTitle = new JLabel();
    private JLabel lblHour = new JLabel();
    private JLabel lblMin = new JLabel();
    private JLabel lblSec = new JLabel();
    private JLabel lblTime = new JLabel();
    private JTextField txtHour = new JTextField(2);
    private JTextField txtMin = new JTextField(2);
    private JTextField txtSec = new JTextField(2);
    private JButton btnStart = new JButton();
    public Font font = new Font("Agency FB", Font.BOLD, 28);

    public TemporizadorUI() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Cronometro");
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
        setSize(380, 300);
    }

    private void initComponents() {
        Container c = getContentPane();
        c.setLayout(null);

        //agregando componentes al container        
        c.add(lblTitle);
        c.add(lblTime);
        c.add(lblHour);
        c.add(lblMin);
        c.add(lblSec);
        c.add(txtHour);
        c.add(txtMin);
        c.add(txtSec);
        c.add(btnStart);

        // Posicion de los componentes
        lblTitle.setBounds(15, 20, 250, 25);
        lblTime.setBounds(120, 130, 250, 50);
        lblHour.setBounds(30, 100, 50, 25);
        txtHour.setBounds(80, 100, 50, 25);
        lblMin.setBounds(140, 100, 50, 25);
        txtMin.setBounds(180, 100, 50, 25);
        lblSec.setBounds(240, 100, 50, 25);
        txtSec.setBounds(290, 100, 50, 25);
        btnStart.setBounds(120, 180, 100, 25);
        //Setteando texto en los componentes
        lblTitle.setText("TEMPORIZADOR FIS");
        lblHour.setText("Hora:");
        lblMin.setText("Min:");
        lblSec.setText("Seg:");
        txtHour.setText("00");
        txtMin.setText("00");
        txtSec.setText("00");
        lblTime.setText("00:00:00");
        lblTime.setFont(font);
        btnStart.setText("Iniciar");

        // Agregandole el listener a los botones
        btnStart.addActionListener(ctrl);
        btnStart.setEnabled(true);

    }

    /*
     * *********************************************************
     * Getter and Setter de los componentes
    ***********************************************************
     */

    public JLabel getLblTime() {
        return lblTime;
    }

    public void setLblTime(JLabel lblTime) {
        this.lblTime = lblTime;
    }

    public JTextField getTxtHour() {
        return txtHour;
    }

    public void setTxtHour(JTextField txtHour) {
        this.txtHour = txtHour;
    }

    public JTextField getTxtMin() {
        return txtMin;
    }

    public void setTxtMin(JTextField txtMin) {
        this.txtMin = txtMin;
    }

    public JTextField getTxtSec() {
        return txtSec;
    }

    public void setTxtSec(JTextField txtSec) {
        this.txtSec = txtSec;
    }

    public JButton getBtnStart() {
        return btnStart;
    }

    public void setBtnStart(JButton btnStart) {
        this.btnStart = btnStart;
    }

}
