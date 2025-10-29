package co.edu.unbosque.model.persistence;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

import co.edu.unbosque.model.Correo;

public class CorreoDAO {

	private static final String SMTP_HOST = "smtp.gmail.com";
	private static final String SMTP_PORT = "587";
	private static final String EMAIL_REMITENTE = "danrt2018@gmail.com";
	private static final String PASSWORD_REMITENTE = "bwuqfizniporvykl";

	public boolean enviarCodigoVerificacion(Correo correo) {

		Properties props = configurarPropiedades();
		Session session = crearSesion(props);

		try {
			Message mensaje = new MimeMessage(session);
			mensaje.setFrom(new InternetAddress(EMAIL_REMITENTE, "Sistema de Verificación"));
			mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo.getDestinatario()));
			mensaje.setSubject("Código de Verificación");

			String contenidoHTML = construirMensajeCodigoHTML(correo);
			mensaje.setContent(contenidoHTML, "text/html; charset=utf-8");

			Transport.send(mensaje);
			System.out.println("Email de código enviado exitosamente a: " + correo.getDestinatario());
			return true;

		} catch (MessagingException | java.io.UnsupportedEncodingException e) {
			System.err.println("Error al enviar el email: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Envía un correo de registro exitoso
	 * 
	 * @param correo Objeto Correo con destinatario y alias
	 * @return true si se envió correctamente, false si hubo error
	 */
	public boolean enviarRegistroExitoso(Correo correo) {

		Properties props = configurarPropiedades();
		Session session = crearSesion(props);

		try {
			Message mensaje = new MimeMessage(session);
			mensaje.setFrom(new InternetAddress(EMAIL_REMITENTE, "Sistema de Registro"));
			mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo.getDestinatario()));
			mensaje.setSubject("¡Registro Exitoso!");

			String contenidoHTML = construirMensajeRegistroHTML(correo);
			mensaje.setContent(contenidoHTML, "text/html; charset=utf-8");

			Transport.send(mensaje);
			System.out.println("Email de registro enviado exitosamente a: " + correo.getDestinatario());
			return true;

		} catch (MessagingException | java.io.UnsupportedEncodingException e) {
			System.err.println("Error al enviar el email: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Configura las propiedades del servidor SMTP
	 */
	private Properties configurarPropiedades() {
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST);
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		return props;
	}

	/**
	 * Crea la sesión con autenticación
	 */
	private Session crearSesion(Properties props) {
		return Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL_REMITENTE, PASSWORD_REMITENTE);
			}
		});
	}

	/**
	 * Construye el mensaje HTML para código de verificación
	 */
	private String construirMensajeCodigoHTML(Correo correo) {
		return "<!DOCTYPE html>" + "<html>" + "<head>" + "    <meta charset='UTF-8'>" + "</head>"
				+ "<body style='font-family: Arial, sans-serif; padding: 20px; background-color: #f5f5f5;'>"
				+ "    <div style='max-width: 600px; margin: 0 auto; background-color: white; border: 1px solid #ddd; padding: 30px; border-radius: 10px; box-shadow: 0 2px 4px rgba(0,0,0,0.1);'>"
				+ "        <h2 style='color: #333; text-align: center;'>🔐 Código de Verificación</h2>"
				+ "        <p style='font-size: 16px; color: #555;'>" + "            Hola <strong>" + correo.getAlias()
				+ "</strong>," + "        </p>" + "        <p style='font-size: 16px; color: #555;'>"
				+ "            Has solicitado un código de verificación para acceder a tu cuenta." + "        </p>"
				+ "        <div style='background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); padding: 20px; margin: 30px 0; text-align: center; border-radius: 8px;'>"
				+ "            <p style='color: white; margin: 0; font-size: 14px; margin-bottom: 10px;'>Tu código es:</p>"
				+ "            <h1 style='color: white; margin: 0; font-size: 42px; letter-spacing: 8px; font-weight: bold;'>"
				+ correo.getCodigo() + "            </h1>" + "        </div>"
				+ "        <p style='font-size: 14px; color: #777; background-color: #fff3cd; padding: 15px; border-left: 4px solid #ffc107; border-radius: 4px;'>"
				+ "            ⚠️ <strong>Importante:</strong> Este código es válido por 10 minutos. Si no solicitaste este código, ignora este mensaje."
				+ "        </p>" + "        <hr style='border: none; border-top: 1px solid #ddd; margin: 30px 0;'>"
				+ "        <p style='font-size: 12px; color: #999; text-align: center; margin: 0;'>"
				+ "            Este es un mensaje automático, por favor no responder." + "        </p>" + "    </div>"
				+ "</body>" + "</html>";
	}

	/**
	 * Construye el mensaje HTML para registro exitoso
	 */
	private String construirMensajeRegistroHTML(Correo correo) {
		return "<!DOCTYPE html>" + "<html>" + "<head>" + "    <meta charset='UTF-8'>" + "</head>"
				+ "<body style='font-family: Arial, sans-serif; padding: 20px; background-color: #f5f5f5;'>"
				+ "    <div style='max-width: 600px; margin: 0 auto; background-color: white; border: 1px solid #ddd; padding: 30px; border-radius: 10px; box-shadow: 0 2px 4px rgba(0,0,0,0.1);'>"
				+ "        <div style='text-align: center; margin-bottom: 20px;'>"
				+ "            <div style='background-color: #4CAF50; width: 80px; height: 80px; border-radius: 50%; margin: 0 auto; display: flex; align-items: center; justify-content: center;'>"
				+ "                <span style='color: white; font-size: 48px;'>✓</span>" + "            </div>"
				+ "        </div>"
				+ "        <h2 style='color: #4CAF50; text-align: center; margin-top: 20px;'>¡Registro Exitoso!</h2>"
				+ "        <p style='font-size: 16px; color: #555; text-align: center;'>"
				+ "            Bienvenido/a <strong>" + correo.getAlias() + "</strong>" + "        </p>"
				+ "        <div style='background-color: #f8f9fa; padding: 20px; margin: 25px 0; border-radius: 8px; border-left: 4px solid #4CAF50;'>"
				+ "            <p style='font-size: 15px; color: #333; margin: 0;'>"
				+ "                Tu cuenta ha sido creada exitosamente. Ya puedes comenzar a utilizar todos nuestros servicios."
				+ "            </p>" + "        </div>" + "        <div style='text-align: center; margin: 30px 0;'>"
				+ "            <p style='font-size: 14px; color: #666; margin-bottom: 15px;'>Datos de tu cuenta:</p>"
				+ "            <p style='font-size: 16px; color: #333; margin: 5px 0;'>"
				+ "                <strong>Usuario:</strong> " + correo.getAlias() + "            </p>"
				+ "            <p style='font-size: 16px; color: #333; margin: 5px 0;'>"
				+ "                <strong>Email:</strong> " + correo.getDestinatario() + "            </p>"
				+ "        </div>"
				+ "        <div style='background-color: #e3f2fd; padding: 15px; border-radius: 8px; margin: 25px 0;'>"
				+ "            <p style='font-size: 14px; color: #1976d2; margin: 0; text-align: center;'>"
				+ "                💡 <strong>Consejo:</strong> Guarda esta información en un lugar seguro."
				+ "            </p>" + "        </div>"
				+ "        <hr style='border: none; border-top: 1px solid #ddd; margin: 30px 0;'>"
				+ "        <p style='font-size: 12px; color: #999; text-align: center; margin: 0;'>"
				+ "            Si no creaste esta cuenta, por favor contacta a soporte inmediatamente." + "        </p>"
				+ "        <p style='font-size: 12px; color: #999; text-align: center; margin: 10px 0 0 0;'>"
				+ "            Este es un mensaje automático, por favor no responder." + "        </p>" + "    </div>"
				+ "</body>" + "</html>";
	}

}