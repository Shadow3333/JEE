package springapp.mailer;

import java.util.Date;
import java.util.Properties;
import javax.mail.internet.*;
import javax.mail.*;

public class MailerSTMP implements Mailer{
	private final static String MAILER_VERSION = "Java";
	private final static String serveur = "smtp.yopmail.com";
	private final static boolean debug = true;

	public MailerSTMP() {}

	public boolean sendmail(String dest, String text) {
		boolean result = false;
		try {
			Properties prop = System.getProperties();
			prop.put("mail.smtp.host", serveur);
			prop.put("mail.smtp.starttls.enable", "true");
			Session session = Session.getDefaultInstance(prop, null);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("Recovery@annuaire.com"));
			InternetAddress[] internetAddresses = new InternetAddress[1];
			internetAddresses[0] = new InternetAddress(dest);
			message.setRecipients(Message.RecipientType.TO, internetAddresses);
			message.setSubject("Annuaire recovery mail");
			message.setText(text);
			message.setHeader("X-Mailer", MAILER_VERSION);
			message.setSentDate(new Date());
			session.setDebug(debug);
			Transport.send(message);
			result = true;
		} 
		catch (AddressException e) {e.printStackTrace();}
		catch (MessagingException e){e.printStackTrace();}
		return result;
	}

	public static void main(String[] args) {
		MailerSTMP m = new MailerSTMP();
		m.sendmail("aabzeazjenazejbakzezae@yopmail.com", "mon texte");
	}
}
