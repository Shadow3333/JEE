package springapp.mailer;

public interface Mailer {
	boolean sendmail(String dest, String text);
}
