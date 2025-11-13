package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelScroll extends JPanel {

	private Image imagenFondo;
	private JLabel lblFondo;
	private JLabel lblAlias;
	private JLabel lblEdadTexto;
	private JLabel lblEdad;
	private JLabel lblEstaturaTexto;
	private JLabel lblEstatura;
	private JLabel lblIngresosTexto;
	private JLabel lblIngresos;
	private JLabel lblDivorcioTexto;
	private JLabel lblDivorcio;
	private JButton btnSmash;
	private JButton btnPass;

	public PanelScroll() {
		this.setLayout(null);
		this.setSize(560, 700);
		this.setOpaque(false);
		this.setVisible(true);
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		// Foto de perfil centrada
		lblFondo = new JLabel();
		lblFondo.setBounds(505, 40, 270, 360);
		lblFondo.setOpaque(true);
		lblFondo.setBackground(new Color(255, 255, 255, 100));

		// Configuración de fuente común para los labels
		Font labelFont = new Font("Noto Sans CJK SC", Font.BOLD, 16);
		Color labelColor = Color.WHITE;

		// Alias - debajo de la foto
		lblAlias = new JLabel();
		lblAlias.setBounds(505, 425, 270, 30);
		lblAlias.setForeground(labelColor);

		// Edad
		lblEdadTexto = new JLabel();
		lblEdadTexto.setBounds(505, 468, 135, 30);
		lblEdadTexto.setFont(labelFont);
		lblEdadTexto.setForeground(labelColor);

		// Edad
		lblEdad = new JLabel();
		lblEdad.setBounds(670, 468, 105, 30);
		lblEdad.setFont(labelFont);
		lblEdad.setForeground(labelColor);

		// Estatura
		lblEstaturaTexto = new JLabel();
		lblEstaturaTexto.setFont(labelFont);
		lblEstaturaTexto.setForeground(labelColor);
		lblEstaturaTexto.setVisible(false);

		lblEstatura = new JLabel();
		lblEstatura.setFont(labelFont);
		lblEstatura.setForeground(labelColor);
		lblEstatura.setVisible(false);

		// Ingresos
		lblIngresosTexto = new JLabel();
		lblIngresosTexto.setFont(labelFont);
		lblIngresosTexto.setForeground(labelColor);
		lblIngresosTexto.setVisible(false);

		lblIngresos = new JLabel();
		lblIngresos.setFont(labelFont);
		lblIngresos.setForeground(labelColor);
		lblIngresos.setVisible(false);

		// Divorcios
		lblDivorcioTexto = new JLabel();
		lblDivorcioTexto.setFont(labelFont);
		lblDivorcioTexto.setForeground(labelColor);
		lblDivorcioTexto.setVisible(false);

		lblDivorcio = new JLabel();
		lblDivorcio.setFont(labelFont);
		lblDivorcio.setForeground(labelColor);
		lblDivorcio.setVisible(false);

		// Configuración de fuente para botones
		Font buttonFont = new Font("Noto Sans CJK SC", Font.BOLD, 18);

		// Botón Pass (izquierda)
		btnPass = new JButton();
		btnPass.setBackground(Color.decode("#F23C29"));
		btnPass.setForeground(Color.WHITE);
		btnPass.setFont(buttonFont);
		btnPass.setBounds(400, 610, 160, 50);
		btnPass.setFocusPainted(false);
		btnPass.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// Botón Smash (derecha)
		btnSmash = new JButton();
		btnSmash.setBackground(Color.decode("#44F533"));
		btnSmash.setForeground(Color.WHITE);
		btnSmash.setFont(buttonFont);
		btnSmash.setBounds(700, 610, 160, 50);
		btnSmash.setFocusPainted(false);
		btnSmash.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// Agregar componentes al panel
		this.add(lblFondo);
		this.add(lblAlias);
		this.add(lblEdad);
		this.add(lblEdadTexto);
		this.add(lblEstatura);
		this.add(lblEstaturaTexto);
		this.add(lblIngresos);
		this.add(lblIngresosTexto);
		this.add(lblDivorcio);
		this.add(lblDivorcioTexto);
		this.add(btnPass);
		this.add(btnSmash);
	}

	public void mostrarAtributosHombre() {
		lblEstatura.setBounds(670, 511, 135, 30);
		lblEstaturaTexto.setBounds(505, 511, 105, 30);
		lblEstatura.setVisible(true);
		lblEstaturaTexto.setVisible(true);

		lblIngresos.setBounds(670, 554, 135, 30);
		lblIngresosTexto.setBounds(505, 554, 135, 30);
		lblIngresos.setVisible(true);
		lblIngresosTexto.setVisible(true);
	}

	public void ocultarAtributos() {
		lblEstatura.setVisible(false);
		lblEstaturaTexto.setVisible(false);

		lblIngresos.setVisible(false);
		lblIngresosTexto.setVisible(false);

		lblDivorcio.setVisible(false);
		lblDivorcioTexto.setVisible(false);

		lblEstatura.setVisible(false);
		lblEstaturaTexto.setVisible(false);
	}

	public void mostrarAtributosMujer(boolean atributoExtra) {
		lblDivorcio.setBounds(670, 511, 135, 30);
		lblDivorcioTexto.setBounds(505, 511, 135, 30);
		lblDivorcio.setVisible(true);
		lblDivorcioTexto.setVisible(true);
		if (atributoExtra) {
			lblEstatura.setBounds(670, 554, 135, 30);
			lblEstaturaTexto.setBounds(505, 554, 135, 30);
			lblEstatura.setVisible(true);
			lblEstaturaTexto.setVisible(true);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imagenFondo != null) { // Verifica que exista
			g.drawImage(imagenFondo, 440, 20, this);
		}
	}

	public Image getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(Image imagenFondo) {
		this.imagenFondo = imagenFondo;
	}

	public JLabel getLblFondo() {
		return lblFondo;
	}

	public void setLblFondo(JLabel lblFondo) {
		this.lblFondo = lblFondo;
	}

	public JLabel getLblAlias() {
		return lblAlias;
	}

	public void setLblAlias(JLabel lblAlias) {
		this.lblAlias = lblAlias;
	}

	public JLabel getLblEdadTexto() {
		return lblEdadTexto;
	}

	public void setLblEdadTexto(JLabel lblEdadTexto) {
		this.lblEdadTexto = lblEdadTexto;
	}

	public JLabel getLblEdad() {
		return lblEdad;
	}

	public void setLblEdad(JLabel lblEdad) {
		this.lblEdad = lblEdad;
	}

	public JLabel getLblEstaturaTexto() {
		return lblEstaturaTexto;
	}

	public void setLblEstaturaTexto(JLabel lblEstaturaTexto) {
		this.lblEstaturaTexto = lblEstaturaTexto;
	}

	public JLabel getLblEstatura() {
		return lblEstatura;
	}

	public void setLblEstatura(JLabel lblEstatura) {
		this.lblEstatura = lblEstatura;
	}

	public JLabel getLblIngresosTexto() {
		return lblIngresosTexto;
	}

	public void setLblIngresosTexto(JLabel lblIngresosTexto) {
		this.lblIngresosTexto = lblIngresosTexto;
	}

	public JLabel getLblIngresos() {
		return lblIngresos;
	}

	public void setLblIngresos(JLabel lblIngresos) {
		this.lblIngresos = lblIngresos;
	}

	public JLabel getLblDivorcioTexto() {
		return lblDivorcioTexto;
	}

	public void setLblDivorcioTexto(JLabel lblDivorcioTexto) {
		this.lblDivorcioTexto = lblDivorcioTexto;
	}

	public JLabel getLblDivorcio() {
		return lblDivorcio;
	}

	public void setLblDivorcio(JLabel lblDivorcio) {
		this.lblDivorcio = lblDivorcio;
	}

	public JButton getBtnSmash() {
		return btnSmash;
	}

	public void setBtnSmash(JButton btnSmash) {
		this.btnSmash = btnSmash;
	}

	public JButton getBtnPass() {
		return btnPass;
	}

	public void setBtnPass(JButton btnPass) {
		this.btnPass = btnPass;
	}

}