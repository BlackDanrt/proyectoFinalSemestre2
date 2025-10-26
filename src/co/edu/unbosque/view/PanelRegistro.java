package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelRegistro extends JPanel {

    private JLabel lblFondo;
    private JTextField txtNombre;
    private JTextField txtAlias;
    private JTextField txtEmail;
    private JPasswordField jpfContrasenia;
    private JPasswordField jpfConfirmarContrasenia;
    private JTextField txtFechaNacimiento;
    private JTextField txtEstatura;
    private JTextField txtIngresosMensuales;
    private JCheckBox chkDivorciada;
    private JButton btnRegistrar;
    private JButton btnCancelar;
    private JRadioButton rbHombre;
    private JRadioButton rbMujer;
    private ButtonGroup grupoGenero;

    public PanelRegistro() {
        this.setLayout(null);
        this.setSize(560, 700);
        this.setBackground(Color.decode("#BB82CF"));
        this.setVisible(true);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        lblFondo = new JLabel();
        lblFondo.setBounds(70, 40, 450, 170);
 
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(70, 250, 340, 20);
        txtNombre = new JTextField();
        txtNombre.setBounds(70, 270, 340, 30);

        JLabel lblAlias = new JLabel("Alias (único e irrepetible):");
        lblAlias.setBounds(70, 305, 340, 20);
        txtAlias = new JTextField();
        txtAlias.setBounds(70, 325, 340, 30);

        JLabel lblEmail = new JLabel("Correo Electrónico:");
        lblEmail.setBounds(70, 360, 340, 20);
        txtEmail = new JTextField();
        txtEmail.setBounds(70, 380, 340, 30);

        JLabel lblContrasenia = new JLabel("Contraseña:");
        lblContrasenia.setBounds(70, 415, 340, 20);
        jpfContrasenia = new JPasswordField();
        jpfContrasenia.setBounds(70, 435, 340, 30);

        JLabel lblConfirmarContrasenia = new JLabel("Confirmar Contraseña:");
        lblConfirmarContrasenia.setBounds(70, 470, 340, 20);
        jpfConfirmarContrasenia = new JPasswordField();
        jpfConfirmarContrasenia.setBounds(70, 490, 340, 30);

        JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento (DD/MM/YYYY):");
        lblFechaNacimiento.setBounds(70, 525, 340, 20);
        txtFechaNacimiento = new JTextField();
        txtFechaNacimiento.setBounds(70, 545, 340, 30);

        JLabel lblGenero = new JLabel("Género:");
        lblGenero.setBounds(70, 580, 340, 20);
        
        rbHombre = new JRadioButton("Hombre");
        rbHombre.setBounds(70, 600, 100, 20);
        
        rbMujer = new JRadioButton("Mujer");
        rbMujer.setBounds(180, 600, 100, 20);
        
        grupoGenero = new ButtonGroup();
        grupoGenero.add(rbHombre);
        grupoGenero.add(rbMujer);

        JLabel lblEstatura = new JLabel("Estatura (cm):");
        lblEstatura.setBounds(70, 625, 340, 20);
        txtEstatura = new JTextField();
        txtEstatura.setBounds(70, 645, 150, 30);

        JLabel lblIngresosMensuales = new JLabel("Ingresos Mensuales ($):");
        lblIngresosMensuales.setBounds(230, 625, 340, 20);
        txtIngresosMensuales = new JTextField();
        txtIngresosMensuales.setBounds(230, 645, 150, 30);

        chkDivorciada = new JCheckBox("¿Ha tenido divorcios?");
        chkDivorciada.setBounds(70, 680, 200, 20);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(70, 720, 140, 35);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(230, 720, 140, 35);

        this.add(lblFondo);
        this.add(lblNombre);
        this.add(txtNombre);
        this.add(lblAlias);
        this.add(txtAlias);
        this.add(lblEmail);
        this.add(txtEmail);
        this.add(lblContrasenia);
        this.add(jpfContrasenia);
        this.add(lblConfirmarContrasenia);
        this.add(jpfConfirmarContrasenia);
        this.add(lblFechaNacimiento);
        this.add(txtFechaNacimiento);
        this.add(lblGenero);
        this.add(rbHombre);
        this.add(rbMujer);
        this.add(lblEstatura);
        this.add(txtEstatura);
        this.add(lblIngresosMensuales);
        this.add(txtIngresosMensuales);
        this.add(chkDivorciada);
        this.add(btnRegistrar);
        this.add(btnCancelar);
    }


    public JLabel getLblFondo() {
        return lblFondo;
    }

    public void setLblFondo(JLabel lblFondo) {
        this.lblFondo = lblFondo;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtAlias() {
        return txtAlias;
    }

    public void setTxtAlias(JTextField txtAlias) {
        this.txtAlias = txtAlias;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public JPasswordField getJpfContrasenia() {
        return jpfContrasenia;
    }

    public void setJpfContrasenia(JPasswordField jpfContrasenia) {
        this.jpfContrasenia = jpfContrasenia;
    }

    public JPasswordField getJpfConfirmarContrasenia() {
        return jpfConfirmarContrasenia;
    }

    public void setJpfConfirmarContrasenia(JPasswordField jpfConfirmarContrasenia) {
        this.jpfConfirmarContrasenia = jpfConfirmarContrasenia;
    }

    public JTextField getTxtFechaNacimiento() {
        return txtFechaNacimiento;
    }

    public void setTxtFechaNacimiento(JTextField txtFechaNacimiento) {
        this.txtFechaNacimiento = txtFechaNacimiento;
    }

    public JTextField getTxtEstatura() {
        return txtEstatura;
    }

    public void setTxtEstatura(JTextField txtEstatura) {
        this.txtEstatura = txtEstatura;
    }

    public JTextField getTxtIngresosMensuales() {
        return txtIngresosMensuales;
    }

    public void setTxtIngresosMensuales(JTextField txtIngresosMensuales) {
        this.txtIngresosMensuales = txtIngresosMensuales;
    }

    public JCheckBox getChkDivorciada() {
        return chkDivorciada;
    }

    public void setChkDivorciada(JCheckBox chkDivorciada) {
        this.chkDivorciada = chkDivorciada;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(JButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JRadioButton getRbHombre() {
        return rbHombre;
    }

    public void setRbHombre(JRadioButton rbHombre) {
        this.rbHombre = rbHombre;
    }

    public JRadioButton getRbMujer() {
        return rbMujer;
    }

    public void setRbMujer(JRadioButton rbMujer) {
        this.rbMujer = rbMujer;
    }

    public ButtonGroup getGrupoGenero() {
        return grupoGenero;
    }

    public void setGrupoGenero(ButtonGroup grupoGenero) {
        this.grupoGenero = grupoGenero;
    }
}