package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class ViewFacade {

	private Ventana ven;
	private PanelBanner pBan;

	public ViewFacade() {
		ven = new Ventana();
		pBan = new PanelBanner();
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

	private void cambiarIconoModo(String ruta) {
		ImageIcon iconoOriginal = new ImageIcon(ruta);
		Image imgEscalada = iconoOriginal.getImage().getScaledInstance(40, 40,

				Image.SCALE_SMOOTH);
		pBan.getBtnModoOscuro().setIcon(new ImageIcon(imgEscalada));
	}

	public void modoOscuro() {
		String colorFondo = "#121212";
		ven.getContentPane().setBackground(Color.decode(colorFondo));
		pBan.setBackground(Color.decode(colorFondo));

		// Cambiar colores de botones
		pBan.getBtnModoOscuro().setBackground(Color.WHITE);
		pBan.getBtnModoOscuro().setForeground(Color.decode(colorFondo));
		pBan.getBtnModoOscuro().setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));

		cambiarIconoModo("files/sol.png");
	}

	public void modoClaro() {
		ven.getContentPane().setBackground(Color.WHITE);
		pBan.setBackground(Color.WHITE);

		// Cambiar colores de botones
		pBan.getBtnModoOscuro().setBackground(Color.BLACK);
		pBan.getBtnModoOscuro().setForeground(Color.WHITE);
		pBan.getBtnModoOscuro().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

		cambiarIconoModo("files/luna.png");
	}
}
