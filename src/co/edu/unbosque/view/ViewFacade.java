package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class ViewFacade {

	private Ventana ven;
	private PanelBanner pBan;
	private PanelIniciarSesion pInic;
	private PanelRegistro pReg;
	private PanelSeleccionarGenero pGen;
	private PanelCodigoVerificacion pCV;
	private PanelAdministrador pAdmin;
	private PanelPerfil pPerfil;
	private PanelScroll pScr;

	public ViewFacade() {
		ven = new Ventana();
		pBan = new PanelBanner();
		pInic = new PanelIniciarSesion();
		pReg = new PanelRegistro();
		pGen = new PanelSeleccionarGenero();
		pCV = new PanelCodigoVerificacion();
		pAdmin = new PanelAdministrador();
		pPerfil = new PanelPerfil();
		pScr = new PanelScroll();
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

	public PanelPerfil getpPerfil() {
		return pPerfil;
	}

	public void setpPerfil(PanelPerfil pPerfil) {
		this.pPerfil = pPerfil;
	}

	public PanelScroll getpScr() {
		return pScr;
	}

	public void setpScr(PanelScroll pScr) {
		this.pScr = pScr;
	}

	private void cambiarIconoModo(String ruta) {
		ImageIcon iconoOriginal = new ImageIcon(ruta);
		Image imgEscalada = iconoOriginal.getImage().getScaledInstance(40, 40,

				Image.SCALE_SMOOTH);
		pBan.getBtnModoOscuro().setIcon(new ImageIcon(imgEscalada));
	}

	public void modoOscuro() {
		ven.getContentPane().setBackground(Color.decode("#101010"));
		pBan.setBackground(Color.decode("#19191C"));

		pBan.getBtnModoOscuro().setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));

		cambiarIconoModo("files/sol.png");
	}

	public void modoClaro() {
		ven.getContentPane().setBackground(Color.WHITE);
		pBan.setBackground(Color.decode("#F5F5F5"));

		pBan.getBtnModoOscuro().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

		cambiarIconoModo("files/luna.png");
	}
}
