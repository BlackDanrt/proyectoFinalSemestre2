package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ViewFacade {

	private Ventana ven;
	private PanelBanner pBan;
	private PanelIniciarSesion pInic;
	private PanelRegistro pReg;
	private PanelSeleccionarGenero pGen;
	private PanelCodigoVerificacion pCV;
	private PanelAdministrador pAdmin;
	private PanelScroll pScr;
	private PanelPerfilMujer pPM;
	private PanelPerfilHombre pPH;
	private PanelPlantilla pPa;

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

	public void refrescarVista() {
		pBan.repaint();
	}

	public Ventana getVen() {
		return ven;
	}

	public void setVen(Ventana ven) {
		this.ven = ven;
	}

	public PanelBanner getpBan() {
		return pBan;
	}

	public void setpBan(PanelBanner pBan) {
		this.pBan = pBan;
	}

	public PanelIniciarSesion getpInic() {
		return pInic;
	}

	public void setpInic(PanelIniciarSesion pInic) {
		this.pInic = pInic;
	}

	public PanelRegistro getpReg() {
		return pReg;
	}

	public void setpReg(PanelRegistro pReg) {
		this.pReg = pReg;
	}

	public PanelSeleccionarGenero getpGen() {
		return pGen;
	}

	public void setpGen(PanelSeleccionarGenero pGen) {
		this.pGen = pGen;
	}

	public PanelCodigoVerificacion getpCV() {
		return pCV;
	}

	public void setpCV(PanelCodigoVerificacion pCV) {
		this.pCV = pCV;
	}

	public PanelAdministrador getpAdmin() {
		return pAdmin;
	}

	public void setpAdmin(PanelAdministrador pAdmin) {
		this.pAdmin = pAdmin;
	}

	public PanelScroll getpScr() {
		return pScr;
	}

	public void setpScr(PanelScroll pScr) {
		this.pScr = pScr;
	}

	public PanelPerfilMujer getpPM() {
		return pPM;
	}

	public void setpPM(PanelPerfilMujer pPM) {
		this.pPM = pPM;
	}

	public PanelPerfilHombre getpPH() {
		return pPH;
	}

	public void setpPH(PanelPerfilHombre pPH) {
		this.pPH = pPH;
	}

	public PanelPlantilla getpPa() {
		return pPa;
	}

	public void setpPa(PanelPlantilla pPa) {
		this.pPa = pPa;
	}

	private void cambiarIconoModo(String ruta) {
		ImageIcon iconoOriginal = new ImageIcon(ruta);
		Image imgEscalada = iconoOriginal.getImage().getScaledInstance(40, 40,

				Image.SCALE_SMOOTH);
		pBan.getBtnModoOscuro().setIcon(new ImageIcon(imgEscalada));
	}

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

	public void ordenAscendente() {
		cargarIconoOrden("files/ascendente.png");
	}

	public void ordenDescendente() {
		cargarIconoOrden("files/descendente.png");
	}

	private void cargarIconoOrden(String ruta) {
		ImageIcon iconoOriginal = new ImageIcon(ruta);
		Image imgEscalada = iconoOriginal.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		pAdmin.getBtnOrden().setIcon(new ImageIcon(imgEscalada));

		// Configurar el botón
		pAdmin.getBtnOrden().setMargin(new Insets(0, 0, 0, 0));
		pAdmin.getBtnOrden().setBorderPainted(false);
		pAdmin.getBtnOrden().setContentAreaFilled(false);
		pAdmin.getBtnOrden().setFocusPainted(false);
	}
}
