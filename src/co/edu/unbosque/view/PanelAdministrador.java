package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.MujerDTO;

public class PanelAdministrador extends JPanel {

	private JComboBox<String> cmbGenero, cmbFiltro;
	private JButton btnOrden, btnCrearPdf, btnCerrarSesion;
	private JScrollPane scroll;

	public PanelAdministrador() {
		this.setLayout(null);
		this.setSize(1280, 800);
		this.setVisible(true);
		this.setOpaque(false);
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		cmbGenero = new JComboBox<String>();
		cmbGenero.setBounds(115, 58, 150, 27);
		cmbGenero.setLightWeightPopupEnabled(false);
		cmbGenero.addItem("Hombre");
		cmbGenero.addItem("Mujer");

		cmbFiltro = new JComboBox<String>();
		cmbFiltro.setBounds(417, 58, 150, 27);
		cmbFiltro.setLightWeightPopupEnabled(false);
		cmbFiltro.addItem("Alias");
		cmbFiltro.addItem("Nombre");
		cmbFiltro.addItem("Apellido");
		cmbFiltro.addItem("Likes");
		cmbFiltro.addItem("Edad");
		cmbFiltro.addItem("Top 10 Likes");
		cmbFiltro.addItem("Ingresos");

		btnOrden = new JButton();
		btnOrden.setBounds(367, 56, 35, 35);
		btnOrden.setBorderPainted(false);
		btnOrden.setContentAreaFilled(false);
		btnOrden.setFocusPainted(false);

		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(100, 705, 264, 45);
		btnCerrarSesion.setFont(new Font("Arial", Font.BOLD, 16));
		btnCerrarSesion.setBackground(Color.decode("#F44336"));
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFocusPainted(false);

		btnCrearPdf = new JButton("Crear PDF");
		btnCrearPdf.setBounds(916, 706, 264, 45);
		btnCrearPdf.setFont(new Font("Arial", Font.BOLD, 16));
		btnCrearPdf.setBackground(Color.decode("#4CAF50"));
		btnCrearPdf.setForeground(Color.WHITE);
		btnCrearPdf.setFocusPainted(false);

		scroll = new JScrollPane();
		scroll.setBounds(100, 142, 1100, 525);

		this.add(cmbGenero);
		this.add(btnOrden);
		this.add(cmbFiltro);
		this.add(scroll);
		this.add(btnCrearPdf);
		this.add(btnCerrarSesion);

	}

	public JComboBox<String> getCmbGenero() {
		return cmbGenero;
	}

	public void setCmbGenero(JComboBox<String> cmbGenero) {
		this.cmbGenero = cmbGenero;
	}

	public JComboBox<String> getCmbFiltro() {
		return cmbFiltro;
	}

	public void setCmbFiltro(JComboBox<String> cmbFiltro) {
		this.cmbFiltro = cmbFiltro;
	}

	public JButton getBtnOrden() {
		return btnOrden;
	}

	public void setBtnOrden(JButton btnOrden) {
		this.btnOrden = btnOrden;
	}

	public JButton getBtnCrearPdf() {
		return btnCrearPdf;
	}

	public void setBtnCrearPdf(JButton btnCrearPdf) {
		this.btnCrearPdf = btnCrearPdf;
	}

	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	public void setBtnCerrarSesion(JButton btnCerrarSesion) {
		this.btnCerrarSesion = btnCerrarSesion;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public void mostrarHombre(ArrayList<HombreDTO> listaDto, ActionListener eliminarListener) {
		JPanel contenedorPaneles = new JPanel();
		contenedorPaneles.setLayout(new BoxLayout(contenedorPaneles, BoxLayout.Y_AXIS));

		for (int i = 0; i < listaDto.size(); i++) {
			HombreDTO dto = listaDto.get(i);
			PanelPlantilla plant = new PanelPlantilla();

			plant.setMaximumSize(new Dimension(Integer.MAX_VALUE, 142));
			plant.setPreferredSize(new Dimension(1080, 142));

			if (i % 2 == 0) {
				plant.setBackground(new Color(240, 240, 240));
			} else {
				plant.setBackground(Color.WHITE);
			}

			plant.setOpaque(true);

			plant.setVisible(true);
			plant.getLblIngresos().setVisible(true);
			plant.getLblIngresosCuenta().setVisible(true);

			// ✅ Cargar desde recursos del proyecto
			ImageIcon icon = new ImageIcon(dto.getFoto());
			Image img = icon.getImage().getScaledInstance(90, 120, Image.SCALE_SMOOTH);
			plant.getLblImagenCuenta().setIcon(new ImageIcon(img));

			plant.getLblAlias().setText(dto.getAlias());
			plant.getLblNombreCuenta().setText(dto.getNombre());
			plant.getLblApellidoCuenta().setText(dto.getApellido());
			plant.getLblEdadCuenta().setText(String.valueOf(dto.getEdad()));
			plant.getLblLikesCuenta().setText(String.valueOf(dto.getCantLike()));
			plant.getLblIngresosCuenta().setText(String.valueOf(dto.getIngresoMensual()));

			plant.getBtnDarDeBaja().setActionCommand("eliminar" + i);
			plant.getBtnDarDeBaja().addActionListener(eliminarListener);
			contenedorPaneles.add(plant);
		}

		scroll.setViewportView(contenedorPaneles);
		scroll.revalidate();
		scroll.repaint();
	}

	public void mostrarMujer(ArrayList<MujerDTO> listaDto, ActionListener eliminarListener) {
		JPanel contenedorPaneles = new JPanel();
		contenedorPaneles.setLayout(new BoxLayout(contenedorPaneles, BoxLayout.Y_AXIS));

		for (int i = 0; i < listaDto.size(); i++) {
			MujerDTO dto = listaDto.get(i);
			PanelPlantilla plant = new PanelPlantilla();

			plant.setMaximumSize(new Dimension(Integer.MAX_VALUE, 142));
			plant.setPreferredSize(new Dimension(1080, 142));

			if (i % 2 == 0) {
				plant.setBackground(new Color(240, 240, 240));
			} else {
				plant.setBackground(Color.WHITE);
			}

			plant.setOpaque(true);

			plant.getLblIngresos().setVisible(false);
			plant.getLblIngresosCuenta().setVisible(false);
			plant.setVisible(true);

			ImageIcon icon = new ImageIcon(dto.getFoto());
			Image img = icon.getImage().getScaledInstance(90, 120, Image.SCALE_SMOOTH);
			plant.getLblImagenCuenta().setIcon(new ImageIcon(img));

			plant.getLblAlias().setText(dto.getAlias());
			plant.getLblNombreCuenta().setText(dto.getNombre());
			plant.getLblApellidoCuenta().setText(dto.getApellido());
			plant.getLblEdadCuenta().setText(String.valueOf(dto.getEdad()));
			plant.getLblLikesCuenta().setText(String.valueOf(dto.getCantLike()));

			plant.getBtnDarDeBaja().setActionCommand("eliminar" + i);
			plant.getBtnDarDeBaja().addActionListener(eliminarListener);
			contenedorPaneles.add(plant);
		}

		scroll.setViewportView(contenedorPaneles);
		scroll.revalidate();
		scroll.repaint();
	}
}