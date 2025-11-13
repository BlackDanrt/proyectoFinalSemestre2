package co.edu.unbosque.model.persistence;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

import co.edu.unbosque.model.Correo;
import co.edu.unbosque.model.CorreoDTO;

/**
 * Clase de acceso a datos (DAO) encargada de gestionar el envío de correos
 * electrónicos desde el sistema BosTinder.
 * 
 * <p>
 * Implementa métodos para enviar mensajes de verificación y notificaciones de
 * registro exitoso utilizando el protocolo SMTP de Gmail. Los correos se
 * generan con formato HTML y soporte multiidioma.
 * </p>
 * 
 * <p>
 * Esta clase utiliza objetos {@link CorreoDTO} para recibir los datos del
 * destinatario, alias y contenido del mensaje, los cuales se convierten en
 * instancias de {@link Correo} mediante el {@link DataMapper}.
 * </p>
 * 
 * <h3>Funciones principales:</h3>
 * <ul>
 * <li>Enviar correos de verificación con código de acceso</li>
 * <li>Enviar correos de confirmación de registro exitoso</li>
 * <li>Generar contenido HTML personalizado según el idioma del usuario</li>
 * </ul>
 * 
 * <h3>Idiomas soportados:</h3>
 * <ul>
 * <li>ES - Español</li>
 * <li>US - Inglés</li>
 * <li>BR - Portugués</li>
 * <li>RU - Ruso</li>
 * <li>CN - Chino</li>
 * <li>IL - Hebreo</li>
 * </ul>
 * 
 * <p>
 * La autenticación se realiza mediante credenciales almacenadas en las
 * constantes {@code EMAIL_REMITENTE} y {@code PASSWORD_REMITENTE}, y la
 * comunicación con el servidor se efectúa por medio de TLS (puerto 587).
 * </p>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class CorreoDAO {

	/**
	 * Host del servidor SMTP de Gmail.
	 */
	private static final String SMTP_HOST = "smtp.gmail.com";

	/**
	 * Puerto utilizado para la conexión SMTP con TLS.
	 */
	private static final String SMTP_PORT = "587";

	/**
	 * Dirección de correo electrónico del remitente del sistema.
	 */
	private static final String EMAIL_REMITENTE = "danrt2018@gmail.com";

	/**
	 * Contraseña de aplicación para autenticación SMTP.
	 */
	private static final String PASSWORD_REMITENTE = "bwuqfizniporvykl";

	/**
	 * Constructor por defecto de la clase CorreoDAO. Crea una nueva instancia del
	 * DAO de correos electrónicos.
	 */
	public CorreoDAO() {
		// Constructor vacío
	}

	/**
	 * Envía un correo electrónico con un código de verificación al destinatario
	 * especificado. El contenido del correo se genera en formato HTML y se adapta
	 * automáticamente al idioma proporcionado.
	 * 
	 * @param dto    objeto {@link CorreoDTO} que contiene los datos del
	 *               destinatario, alias y código
	 * @param idioma código del idioma para el contenido del correo ("ES", "US",
	 *               "BR", "RU", "CN", "IL")
	 * @return {@code true} si el correo se envió correctamente; {@code false} si
	 *         ocurrió algún error
	 */
	public boolean enviarCodigoVerificacion(CorreoDTO dto, String idioma) {

		Correo entity = DataMapper.convertirCorreoDTOaCorreo(dto);

		Properties props = configurarPropiedades();
		Session session = crearSesion(props);

		try {
			Message mensaje = new MimeMessage(session);
			mensaje.setFrom(new InternetAddress(EMAIL_REMITENTE, "Sistema de Verificación"));
			mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(entity.getDestinatario()));
			mensaje.setSubject("Código de Verificación");

			String contenidoHTML = construirMensajeCodigoHTML(entity, idioma);
			mensaje.setContent(contenidoHTML, "text/html; charset=utf-8");

			Transport.send(mensaje);
			return true;

		} catch (MessagingException | java.io.UnsupportedEncodingException e) {
			System.err.println("Error al enviar el email: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Envía un correo de confirmación cuando un registro se realiza exitosamente.
	 * El correo incluye los datos de la cuenta creada y se adapta al idioma del
	 * usuario.
	 * 
	 * @param dto    objeto {@link CorreoDTO} que contiene los datos del
	 *               destinatario y alias
	 * @param idioma código del idioma para el contenido del correo ("ES", "US",
	 *               "BR", "RU", "CN", "IL")
	 * @return {@code true} si el correo fue enviado correctamente; {@code false} si
	 *         ocurrió algún error
	 */
	public boolean enviarRegistroExitoso(CorreoDTO dto, String idioma) {

		Correo entity = DataMapper.convertirCorreoDTOaCorreo(dto);

		Properties props = configurarPropiedades();
		Session session = crearSesion(props);

		try {
			Message mensaje = new MimeMessage(session);
			mensaje.setFrom(new InternetAddress(EMAIL_REMITENTE, "Sistema de Registro"));
			mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(entity.getDestinatario()));
			mensaje.setSubject("¡Registro Exitoso!");

			String contenidoHTML = construirMensajeRegistroHTML(entity, idioma);
			mensaje.setContent(contenidoHTML, "text/html; charset=utf-8");

			Transport.send(mensaje);
			return true;

		} catch (MessagingException | java.io.UnsupportedEncodingException e) {
			System.err.println("Error al enviar el email: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Configura las propiedades necesarias para la conexión con el servidor SMTP de
	 * Gmail. Establece el host, puerto, autenticación y habilitación de TLS.
	 * 
	 * @return objeto {@link Properties} con las configuraciones del servidor SMTP
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
	 * Crea una sesión de correo autenticada utilizando las credenciales del
	 * remitente.
	 * 
	 * @param props propiedades configuradas para el servidor SMTP
	 * @return instancia de {@link Session} autenticada lista para enviar correos
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
	 * Construye el cuerpo del mensaje en formato HTML para el correo de
	 * verificación. El mensaje se personaliza automáticamente según el idioma del
	 * usuario, incluyendo el código de verificación con diseño visual atractivo.
	 * 
	 * @param correo         objeto {@link Correo} que contiene alias, destinatario
	 *                       y código de verificación
	 * @param idiomaGuardado código del idioma ("ES", "US", "BR", "RU", "CN", "IL")
	 * @return cadena de texto con el contenido HTML completo del correo de
	 *         verificación
	 */
	private String construirMensajeCodigoHTML(Correo correo, String idiomaGuardado) {
		String titulo, saludo, mensajePrincipal, avisoImportante, pie, textoCodigo;

		switch (idiomaGuardado) {
		case "US" -> {
			titulo = "Verification Code";
			saludo = "Hello <strong>" + correo.getAlias() + "</strong>,";
			mensajePrincipal = "You requested a verification code to access your account.";
			textoCodigo = "Your code is:";
			avisoImportante = "<strong>Important:</strong> This code is valid while you remain on the verification screen. If you didn't request it, please ignore this message.";
			pie = "This is an automatic message, please do not reply.";
		}
		case "BR" -> {
			titulo = "Código de Verificação";
			saludo = "Olá <strong>" + correo.getAlias() + "</strong>,";
			mensajePrincipal = "Você solicitou um código de verificação para acessar sua conta.";
			textoCodigo = "Seu código é:";
			avisoImportante = "<strong>Importante:</strong> Este código é válido enquanto você estiver na tela de verificação. Se você não solicitou este código, ignore esta mensagem.";
			pie = "Esta é uma mensagem automática, por favor não responda.";
		}
		case "RU" -> {
			titulo = "Код подтверждения";
			saludo = "Здравствуйте, <strong>" + correo.getAlias() + "</strong>!";
			mensajePrincipal = "Вы запросили код подтверждения для доступа к своей учетной записи.";
			textoCodigo = "Ваш код:";
			avisoImportante = "<strong>Важно:</strong> Этот код действителен, пока вы находитесь на экране подтверждения. Если вы не запрашивали этот код, просто проигнорируйте сообщение.";
			pie = "Это автоматическое сообщение, не отвечайте на него.";
		}
		case "CN" -> {
			titulo = "验证码";
			saludo = "你好，<strong>" + correo.getAlias() + "</strong>，";
			mensajePrincipal = "您请求了一个验证码以访问您的账户。";
			textoCodigo = "您的验证码是：";
			avisoImportante = "<strong>重要提示：</strong> 此验证码仅在您停留在验证界面时有效。如果您没有请求此验证码，请忽略此邮件。";
			pie = "这是一封自动发送的邮件，请勿回复。";
		}
		case "IL" -> {
			titulo = "קוד אימות";
			saludo = "שלום <strong>" + correo.getAlias() + "</strong>,";
			mensajePrincipal = "ביקשת קוד אימות כדי לגשת לחשבון שלך.";
			textoCodigo = "הקוד שלך הוא:";
			avisoImportante = "<strong>חשוב:</strong> קוד זה תקף כל עוד אתה נשאר במסך האימות. אם לא ביקשת קוד זה, התעלם מהודעה זו.";
			pie = "זוהי הודעה אוטומטית, אנא אל תגיב.";
		}
		default -> { // Español
			titulo = "Código de Verificación";
			saludo = "Hola <strong>" + correo.getAlias() + "</strong>,";
			mensajePrincipal = "Has solicitado un código de verificación para acceder a tu cuenta.";
			textoCodigo = "Tu código es:";
			avisoImportante = "<strong>Importante:</strong> Este código es válido mientras sigas en la pantalla de verificación. Si no solicitaste este código, ignora este mensaje.";
			pie = "Este es un mensaje automático, por favor no responder.";
		}
		}

		return "<!DOCTYPE html><html><head><meta charset='UTF-8'></head>"
				+ "<body style='font-family: Arial, sans-serif; padding: 20px; background-color: #f5f5f5;'>"
				+ "<div style='max-width: 600px; margin: 0 auto; background-color: white; border: 1px solid #ddd; padding: 30px; border-radius: 10px; box-shadow: 0 2px 4px rgba(0,0,0,0.1);'>"
				+ "<h2 style='color: #333; text-align: center;'>" + titulo + "</h2>"
				+ "<p style='font-size: 16px; color: #555;'>" + saludo + "</p>"
				+ "<p style='font-size: 16px; color: #555;'>" + mensajePrincipal + "</p>"
				+ "<div style='background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); padding: 20px; margin: 30px 0; text-align: center; border-radius: 8px;'>"
				+ "<p style='color: white; margin: 0; font-size: 14px; margin-bottom: 10px;'>" + textoCodigo + "</p>"
				+ "<h1 style='color: white; margin: 0; font-size: 42px; letter-spacing: 8px; font-weight: bold;'>"
				+ correo.getCodigo() + "</h1>" + "</div>"
				+ "<p style='font-size: 14px; color: #777; background-color: #fff3cd; padding: 15px; border-left: 4px solid #ffc107; border-radius: 4px;'>"
				+ avisoImportante + "</p>" + "<hr style='border: none; border-top: 1px solid #ddd; margin: 30px 0;'>"
				+ "<p style='font-size: 12px; color: #999; text-align: center; margin: 0;'>" + pie + "</p>"
				+ "</div></body></html>";
	}

	/**
	 * Construye el cuerpo del mensaje en formato HTML para el correo de registro
	 * exitoso. El mensaje incluye los datos de la cuenta creada y se personaliza
	 * según el idioma del usuario.
	 * 
	 * @param correo         objeto {@link Correo} que contiene alias y destinatario
	 * @param idiomaGuardado código del idioma ("ES", "US", "BR", "RU", "CN", "IL")
	 * @return cadena de texto con el contenido HTML completo del correo de registro
	 *         exitoso
	 */
	private String construirMensajeRegistroHTML(Correo correo, String idiomaGuardado) {
		String titulo, saludo, mensaje, datosCuenta, usuario, email, consejo, pie1, pie2;

		switch (idiomaGuardado) {
		case "US" -> {
			titulo = "Registration Successful!";
			saludo = "Welcome <strong>" + correo.getAlias() + "</strong>";
			mensaje = "Your account has been successfully created. You can now start using our services.";
			datosCuenta = "Your account details:";
			usuario = "Username:";
			email = "Email:";
			consejo = "<strong>Tip:</strong> Save this information in a safe place.";
			pie1 = "If you didn't create this account, please contact support immediately.";
			pie2 = "This is an automatic message, please do not reply.";
		}
		case "BR" -> {
			titulo = "Registro Concluído!";
			saludo = "Bem-vindo(a) <strong>" + correo.getAlias() + "</strong>";
			mensaje = "Sua conta foi criada com sucesso. Você já pode começar a usar nossos serviços.";
			datosCuenta = "Dados da sua conta:";
			usuario = "Usuário:";
			email = "Email:";
			consejo = "<strong>Dica:</strong> Guarde essas informações em um local seguro.";
			pie1 = "Se você não criou esta conta, entre em contato com o suporte imediatamente.";
			pie2 = "Esta é uma mensagem automática, por favor não responda.";
		}
		case "RU" -> {
			titulo = "Регистрация прошла успешно!";
			saludo = "Добро пожаловать, <strong>" + correo.getAlias() + "</strong>";
			mensaje = "Ваша учетная запись успешно создана. Теперь вы можете использовать наши сервисы.";
			datosCuenta = "Данные вашей учетной записи:";
			usuario = "Пользователь:";
			email = "Электронная почта:";
			consejo = "<strong>Совет:</strong> Сохраните эту информацию в надежном месте.";
			pie1 = "Если вы не создавали эту учетную запись, свяжитесь со службой поддержки.";
			pie2 = "Это автоматическое сообщение, не отвечайте на него.";
		}
		case "CN" -> {
			titulo = "注册成功！";
			saludo = "欢迎，<strong>" + correo.getAlias() + "</strong>";
			mensaje = "您的账户已成功创建，现在您可以开始使用我们的服务。";
			datosCuenta = "账户信息：";
			usuario = "用户名：";
			email = "电子邮箱：";
			consejo = "<strong>提示：</strong> 请妥善保存此信息。";
			pie1 = "如果您没有创建此账户，请立即联系支持。";
			pie2 = "这是一封自动发送的邮件，请勿回复。";
		}
		case "IL" -> {
			titulo = "ההרשמה הושלמה בהצלחה!";
			saludo = "ברוך הבא <strong>" + correo.getAlias() + "</strong>";
			mensaje = "החשבון שלך נוצר בהצלחה. כעת תוכל להתחיל להשתמש בשירותים שלנו.";
			datosCuenta = "פרטי החשבון שלך:";
			usuario = "שם משתמש:";
			email = "אימייל:";
			consejo = "<strong>עצה:</strong> שמור מידע זה במקום בטוח.";
			pie1 = "אם לא יצרת חשבון זה, אנא צור קשר עם התמיכה מיד.";
			pie2 = "זוהי הודעה אוטומטית, אנא אל תגיב.";
		}
		default -> {
			titulo = "¡Registro Exitoso!";
			saludo = "Bienvenido/a <strong>" + correo.getAlias() + "</strong>";
			mensaje = "Tu cuenta ha sido creada exitosamente. Ya puedes comenzar a utilizar todos nuestros servicios.";
			datosCuenta = "Datos de tu cuenta:";
			usuario = "Usuario:";
			email = "Correo:";
			consejo = "<strong>Consejo:</strong> Guarda esta información en un lugar seguro.";
			pie1 = "Si no creaste esta cuenta, por favor contacta a soporte inmediatamente.";
			pie2 = "Este es un mensaje automático, por favor no responder.";
		}
		}

		return "<!DOCTYPE html><html><head><meta charset='UTF-8'></head>"
				+ "<body style='font-family: Arial, sans-serif; padding: 20px; background-color: #f5f5f5;'>"
				+ "<div style='max-width: 600px; margin: 0 auto; background-color: white; border: 1px solid #ddd; padding: 30px; border-radius: 10px; box-shadow: 0 2px 4px rgba(0,0,0,0.1);'>"
				+ "<div style='text-align: center; margin-bottom: 20px;'>"
				+ "<div style='background-color: #4CAF50; width: 80px; height: 80px; border-radius: 50%; margin: 0 auto; display: flex; align-items: center; justify-content: center;'>"
				+ "<span style='color: white; font-size: 48px;'>✓</span></div></div>"
				+ "<h2 style='color: #4CAF50; text-align: center; margin-top: 20px;'>" + titulo + "</h2>"
				+ "<p style='font-size: 16px; color: #555; text-align: center;'>" + saludo + "</p>"
				+ "<div style='background-color: #f8f9fa; padding: 20px; margin: 25px 0; border-radius: 8px; border-left: 4px solid #4CAF50;'>"
				+ "<p style='font-size: 15px; color: #333; margin: 0;'>" + mensaje + "</p></div>"
				+ "<div style='text-align: center; margin: 30px 0;'>"
				+ "<p style='font-size: 14px; color: #666; margin-bottom: 15px;'>" + datosCuenta + "</p>"
				+ "<p style='font-size: 16px; color: #333; margin: 5px 0;'><strong>" + usuario + "</strong> "
				+ correo.getAlias() + "</p>" + "<p style='font-size: 16px; color: #333; margin: 5px 0;'><strong>"
				+ email + "</strong> " + correo.getDestinatario() + "</p></div>"
				+ "<div style='background-color: #e3f2fd; padding: 15px; border-radius: 8px; margin: 25px 0;'>"
				+ "<p style='font-size: 14px; color: #1976d2; margin: 0; text-align: center;'>" + consejo + "</p></div>"
				+ "<hr style='border: none; border-top: 1px solid #ddd; margin: 30px 0;'>"
				+ "<p style='font-size: 12px; color: #999; text-align: center; margin: 0;'>" + pie1 + "</p>"
				+ "<p style='font-size: 12px; color: #999; text-align: center; margin: 10px 0 0 0;'>" + pie2 + "</p>"
				+ "</div></body></html>";
	}

}