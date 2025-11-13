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

/**
 * Panel de interfaz gráfica para la administración de usuarios del sistema.
 * Proporciona funcionalidades para visualizar, filtrar y ordenar usuarios
 * (hombres y mujeres), así como generar reportes en PDF y cerrar sesión.
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class PanelAdministrador extends JPanel {

	private JComboBox<String> cmbGenero, cmbFiltro;
	private JButton btnOrden, btnCrearPdf, btnCerrarSesion;
	private JScrollPane scroll;

	/**
	 * Constructor que inicializa el panel de administrador con sus componentes
	 * gráficos y configuraciones predeterminadas.
	 */
	public PanelAdministrador() {
		this.setLayout(null);
		this.setSize(1280, 800);
		this.setVisible(true);
		this.setOpaque(false);
		inicializarComponentes();
	}

	/**
	 * Inicializa todos los componentes gráficos del panel de administrador,
	 * incluyendo combo boxes, botones y el área de scroll para mostrar usuarios.
	 */
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

	/**
	 * Obtiene el combo box para seleccionar el género.
	 * 
	 * @return el combo box de género
	 */
	public JComboBox<String> getCmbGenero() {
		return cmbGenero;
	}

	/**
	 * Establece el combo box para seleccionar el género.
	 * 
	 * @param cmbGenero el nuevo combo box de género
	 */
	public void setCmbGenero(JComboBox<String> cmbGenero) {
		this.cmbGenero = cmbGenero;
	}

	/**
	 * Obtiene el combo box para seleccionar el filtro de ordenamiento.
	 * 
	 * @return el combo box de filtro
	 */
	public JComboBox<String> getCmbFiltro() {
		return cmbFiltro;
	}

	/**
	 * Establece el combo box para seleccionar el filtro de ordenamiento.
	 * 
	 * @param cmbFiltro el nuevo combo box de filtro
	 */
	public void setCmbFiltro(JComboBox<String> cmbFiltro) {
		this.cmbFiltro = cmbFiltro;
	}

	/**
	 * Obtiene el botón para cambiar el orden de visualización.
	 * 
	 * @return el botón de orden
	 */
	public JButton getBtnOrden() {
		return btnOrden;
	}

	/**
	 * Establece el botón para cambiar el orden de visualización.
	 * 
	 * @param btnOrden el nuevo botón de orden
	 */
	public void setBtnOrden(JButton btnOrden) {
		this.btnOrden = btnOrden;
	}

	/**
	 * Obtiene el botón para crear un reporte en PDF.
	 * 
	 * @return el botón de crear PDF
	 */
	public JButton getBtnCrearPdf() {
		return btnCrearPdf;
	}

	/**
	 * Establece el botón para crear un reporte en PDF.
	 * 
	 * @param btnCrearPdf el nuevo botón de crear PDF
	 */
	public void setBtnCrearPdf(JButton btnCrearPdf) {
		this.btnCrearPdf = btnCrearPdf;
	}

	/**
	 * Obtiene el botón para cerrar la sesión del administrador.
	 * 
	 * @return el botón de cerrar sesión
	 */
	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	/**
	 * Establece el botón para cerrar la sesión del administrador.
	 * 
	 * @param btnCerrarSesion el nuevo botón de cerrar sesión
	 */
	public void setBtnCerrarSesion(JButton btnCerrarSesion) {
		this.btnCerrarSesion = btnCerrarSesion;
	}

	/**
	 * Obtiene el scroll pane que contiene la lista de usuarios.
	 * 
	 * @return el scroll pane
	 */
	public JScrollPane getScroll() {
		return scroll;
	}

	/**
	 * Establece el scroll pane que contiene la lista de usuarios.
	 * 
	 * @param scroll el nuevo scroll pane
	 */
	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	/**
	 * Muestra la lista de hombres registrados en el sistema en forma de paneles.
	 * <p>
	 * Cada usuario se muestra en un panel individual con su información completa
	 * incluyendo foto, alias, nombre, apellido, edad, cantidad de likes e ingresos
	 * mensuales. Los paneles se muestran con colores alternados para facilitar la
	 * lectura.
	 * </p>
	 * 
	 * @param listaDto         la lista de objetos {@link HombreDTO} a mostrar
	 * @param eliminarListener el listener para manejar la acción de eliminar
	 *                         usuarios
	 */
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

	/**
	 * Muestra la lista de mujeres registradas en el sistema en forma de paneles.
	 * <p>
	 * Cada usuario se muestra en un panel individual con su información completa
	 * incluyendo foto, alias, nombre, apellido, edad y cantidad de likes. Los
	 * paneles se muestran con colores alternados para facilitar la lectura. A
	 * diferencia del método para hombres, este método oculta el campo de ingresos
	 * mensuales.
	 * </p>
	 * 
	 * @param listaDto         la lista de objetos {@link MujerDTO} a mostrar
	 * @param eliminarListener el listener para manejar la acción de eliminar
	 *                         usuarios
	 */
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