package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase {@code ViewFacade} que implementa el patrón Fachada (Facade Pattern)
 * para centralizar el acceso y la gestión de todos los paneles de la interfaz
 * gráfica del sistema BosTinder.
 * <p>
 * Esta clase facilita el control de los componentes visuales, el cambio entre
 * modos de visualización (oscuro/claro) y la actualización de íconos e imágenes
 * de fondo sin que otras capas del programa interactúen directamente con cada
 * panel.
 * </p>
 *
 * @author Juan Martinez
 * @version 1.0
 */
public class ViewFacade {

	/**
	 * Ventana principal del sistema BosTinder. Actúa como contenedor base de todos
	 * los paneles de la aplicación.
	 */
	private Ventana ven;

	/**
	 * Panel superior de la interfaz que contiene el banner y los controles
	 * principales de navegación o configuración.
	 */
	private PanelBanner pBan;

	/**
	 * Panel destinado a la gestión del inicio de sesión de los usuarios.
	 */
	private PanelIniciarSesion pInic;

	/**
	 * Panel utilizado para el registro de nuevos usuarios, incluyendo la selección
	 * de foto de perfil y datos personales.
	 */
	private PanelRegistro pReg;

	/**
	 * Panel que permite al usuario seleccionar su género durante el proceso de
	 * registro o configuración del perfil.
	 */
	private PanelSeleccionarGenero pGen;

	/**
	 * Panel encargado de mostrar la interfaz de ingreso y verificación del código
	 * de seguridad.
	 */
	private PanelCodigoVerificacion pCV;

	/**
	 * Panel de administración que permite gestionar usuarios, visualizar
	 * estadísticas o aplicar filtros de ordenamiento.
	 */
	private PanelAdministrador pAdmin;

	/**
	 * Panel con desplazamiento vertical (scroll) para visualizar listados o
	 * catálogos de perfiles.
	 */
	private PanelScroll pScr;

	/**
	 * Panel que representa la vista del perfil femenino dentro del sistema
	 * BosTinder.
	 */
	private PanelPerfilMujer pPM;

	/**
	 * Panel que representa la vista del perfil masculino dentro del sistema
	 * BosTinder.
	 */
	private PanelPerfilHombre pPH;

	/**
	 * Panel plantilla base que sirve como estructura general para la creación o
	 * extensión de nuevas vistas.
	 */
	private PanelPlantilla pPa;

	/**
	 * Constructor que inicializa todos los paneles de la vista y los asocia a la
	 * ventana principal.
	 * <p>
	 * Por defecto, todos los paneles (excepto el banner) se configuran como no
	 * visibles.
	 * </p>
	 */
	public ViewFacade() {
		ven = new Ventana();
		pBan = new PanelBanner();
		pInic = new PanelIniciarSesion();
		pReg = new PanelRegistro();
		pGen = new PanelSeleccionarGenero();
		pCV = new PanelCodigoVerificacion();
		pAdmin = new PanelAdministrador();
		pScr = new PanelScroll();
		pPM = new PanelPerfilMujer();
		pPH = new PanelPerfilHombre();
		pPa = new PanelPlantilla();

		pGen.setVisible(false);
		pReg.setVisible(false);
		pCV.setVisible(false);
		pAdmin.setVisible(false);
		pScr.setVisible(false);
		pPM.setVisible(false);
		pPH.setVisible(false);
		pPa.setVisible(false);
	}

	/**
	 * Refresca los elementos gráficos visibles en la vista principal. Se utiliza
	 * cuando se requiere actualizar el panel banner.
	 */
	public void refrescarVista() {
		pBan.repaint();
	}

	/** @return la ventana principal del sistema. */
	public Ventana getVen() {
		return ven;
	}

	/** @param ven la ventana principal a asignar. */
	public void setVen(Ventana ven) {
		this.ven = ven;
	}

	/** @return el panel del banner principal. */
	public PanelBanner getpBan() {
		return pBan;
	}

	/** @param pBan el panel banner a asignar. */
	public void setpBan(PanelBanner pBan) {
		this.pBan = pBan;
	}

	/** @return el panel de inicio de sesión. */
	public PanelIniciarSesion getpInic() {
		return pInic;
	}

	/** @param pInic el panel de inicio de sesión a asignar. */
	public void setpInic(PanelIniciarSesion pInic) {
		this.pInic = pInic;
	}

	/** @return el panel de registro de usuario. */
	public PanelRegistro getpReg() {
		return pReg;
	}

	/** @param pReg el panel de registro de usuario a asignar. */
	public void setpReg(PanelRegistro pReg) {
		this.pReg = pReg;
	}

	/** @return el panel de selección de género. */
	public PanelSeleccionarGenero getpGen() {
		return pGen;
	}

	/** @param pGen el panel de selección de género a asignar. */
	public void setpGen(PanelSeleccionarGenero pGen) {
		this.pGen = pGen;
	}

	/** @return el panel de verificación de código. */
	public PanelCodigoVerificacion getpCV() {
		return pCV;
	}

	/** @param pCV el panel de verificación de código a asignar. */
	public void setpCV(PanelCodigoVerificacion pCV) {
		this.pCV = pCV;
	}

	/** @return el panel de administración. */
	public PanelAdministrador getpAdmin() {
		return pAdmin;
	}

	/** @param pAdmin el panel de administración a asignar. */
	public void setpAdmin(PanelAdministrador pAdmin) {
		this.pAdmin = pAdmin;
	}

	/** @return el panel con scroll para visualizar usuarios. */
	public PanelScroll getpScr() {
		return pScr;
	}

	/** @param pScr el panel con scroll a asignar. */
	public void setpScr(PanelScroll pScr) {
		this.pScr = pScr;
	}

	/** @return el panel del perfil femenino. */
	public PanelPerfilMujer getpPM() {
		return pPM;
	}

	/** @param pPM el panel del perfil femenino a asignar. */
	public void setpPM(PanelPerfilMujer pPM) {
		this.pPM = pPM;
	}

	/** @return el panel del perfil masculino. */
	public PanelPerfilHombre getpPH() {
		return pPH;
	}

	/** @param pPH el panel del perfil masculino a asignar. */
	public void setpPH(PanelPerfilHombre pPH) {
		this.pPH = pPH;
	}

	/** @return el panel de plantilla base. */
	public PanelPlantilla getpPa() {
		return pPa;
	}

	/** @param pPa el panel de plantilla a asignar. */
	public void setpPa(PanelPlantilla pPa) {
		this.pPa = pPa;
	}

	/**
	 * Cambia el icono del botón de modo (oscuro/claro).
	 *
	 * @param ruta la ruta de la imagen del icono.
	 */
	private void cambiarIconoModo(String ruta) {
		ImageIcon iconoOriginal = new ImageIcon(ruta);
		Image imgEscalada = iconoOriginal.getImage().getScaledInstance(40, 40,

				Image.SCALE_SMOOTH);
		pBan.getBtnModoOscuro().setIcon(new ImageIcon(imgEscalada));
	}

	/**
	 * Activa el modo oscuro de la interfaz.
	 * <p>
	 * Cambia los fondos e íconos principales de los paneles para una mejor
	 * visualización en ambientes con poca luz.
	 * </p>
	 */
	public void modoOscuro() {

		pBan.getBtnModoOscuro().setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));

		cambiarIconoModo("files/sol.png");
		ven.getFondo().setIcon(new ImageIcon("files/PrincipalOscuro.png"));
		pInic.setImagenFondo(new ImageIcon("files/LoginOscuro.png").getImage());
		pInic.repaint();
		pCV.setImagenFondo(new ImageIcon("files/codigoOscuro.png").getImage());
		pCV.repaint();
		pScr.setImagenFondo(new ImageIcon("files/scrollOscuro.png").getImage());
		pScr.repaint();
	}

	/**
	 * Activa el modo claro de la interfaz.
	 * <p>
	 * Cambia los fondos e íconos principales de los paneles para una visualización
	 * estándar o diurna.
	 * </p>
	 */
	public void modoClaro() {

		pBan.getBtnModoOscuro().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

		cambiarIconoModo("files/luna.png");
		ven.getFondo().setIcon(new ImageIcon("files/PrincipalClaro.png"));
		pInic.setImagenFondo(new ImageIcon("files/LoginClaro.png").getImage());
		pInic.repaint();
		pCV.setImagenFondo(new ImageIcon("files/codigoClaro.png").getImage());
		pCV.repaint();
		pScr.setImagenFondo(new ImageIcon("files/scrollClaro.png").getImage());
		pScr.repaint();
	}

	/**
	 * Configura el icono del botón de ordenamiento en modo ascendente.
	 */
	public void ordenAscendente() {
		cargarIconoOrden("files/ascendente.png");
	}

	/**
	 * Configura el icono del botón de ordenamiento en modo descendente.
	 */
	public void ordenDescendente() {
		cargarIconoOrden("files/descendente.png");
	}

	/**
	 * Carga y aplica el icono de ordenamiento en el panel de administración.
	 *
	 * @param ruta la ruta del archivo de imagen del icono.
	 */
	private void cargarIconoOrden(String ruta) {
		ImageIcon iconoOriginal = new ImageIcon(ruta);
		Image imgEscalada = iconoOriginal.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		pAdmin.getBtnOrden().setIcon(new ImageIcon(imgEscalada));

		pAdmin.getBtnOrden().setMargin(new Insets(0, 0, 0, 0));
		pAdmin.getBtnOrden().setBorderPainted(false);
		pAdmin.getBtnOrden().setContentAreaFilled(false);
		pAdmin.getBtnOrden().setFocusPainted(false);
	}

}
