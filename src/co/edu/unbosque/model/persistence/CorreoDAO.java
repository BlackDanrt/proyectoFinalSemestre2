package co.edu.unbosque.model.persistence;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

import co.edu.unbosque.model.Correo;

public class CorreoDAO {

	private static final String SMTP_HOST = "smtp.gmail.com";
	private static final String SMTP_PORT = "587";
	private static final String EMAIL_REMITENTE = "tucorreo@gmail.com";
	private static final String PASSWORD_REMITENTE = "tu_contraseña_app";

	public boolean enviarCodigoVerificacion(Correo correo) {

		// Configurar propiedades del servidor SMTP
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST);
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		// Crear sesión con autenticación
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL_REMITENTE, PASSWORD_REMITENTE);
			}
		});

		try {
			// Crear el mensaje
			Message mensaje = new MimeMessage(session);

			// Remitente
			mensaje.setFrom(new InternetAddress(EMAIL_REMITENTE, "Sistema de Verificación"));

			// Destinatario con alias
			mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo.getDestinatario()));

			// Asunto
			mensaje.setSubject("Código de Verificación");

			// Cuerpo del mensaje (HTML para mejor formato)
			String contenidoHTML = construirMensajeHTML(correo);
			mensaje.setContent(contenidoHTML, "text/html; charset=utf-8");

			// Enviar
			Transport.send(mensaje);

			System.out.println("Email enviado exitosamente a: " + correo.getDestinatario());
			return true;

		} catch (MessagingException | java.io.UnsupportedEncodingException e) {
			System.err.println("Error al enviar el email: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Construye el cuerpo del mensaje en HTML
	 */
	private String construirMensajeHTML(Correo correo) {
		return "<!DOCTYPE html>" + "<html>" + "<head>" + "    <meta charset='UTF-8'>" + "</head>"
				+ "<body style='font-family: Arial, sans-serif; padding: 20px;'>"
				+ "    <div style='max-width: 600px; margin: 0 auto; border: 1px solid #ddd; padding: 20px; border-radius: 10px;'>"
				+ "        <h2 style='color: #333;'>Hola, " + correo.getAlias() + "</h2>"
				+ "        <p style='font-size: 16px; color: #555;'>"
				+ "            Has solicitado un código de verificación para acceder a tu cuenta." + "        </p>"
				+ "        <div style='background-color: #f4f4f4; padding: 15px; margin: 20px 0; text-align: center; border-radius: 5px;'>"
				+ "            <h1 style='color: #4CAF50; margin: 0; font-size: 36px; letter-spacing: 5px;'>"
				+ correo.getCodigo() + "            </h1>" + "        </div>"
				+ "        <p style='font-size: 14px; color: #777;'>"
				+ "            Este código es válido por 10 minutos. Si no solicitaste este código, ignora este mensaje."
				+ "        </p>" + "        <hr style='border: none; border-top: 1px solid #ddd; margin: 20px 0;'>"
				+ "        <p style='font-size: 12px; color: #999; text-align: center;'>"
				+ "            Este es un mensaje automático, por favor no responder." + "        </p>" + "    </div>"
				+ "</body>" + "</html>";
	}
}