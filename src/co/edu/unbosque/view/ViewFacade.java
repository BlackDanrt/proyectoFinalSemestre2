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

	public ViewFacade() {
		ven = new Ventana();
		pBan = new PanelBanner();
		pInic = new PanelIniciarSesion();
		pReg = new PanelRegistro();
		pGen = new PanelSeleccionarGenero();
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

	public void refrescarVista() {
		pBan.repaint();
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
