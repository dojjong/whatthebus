package what.the.bus.mail.service;

public interface MailService {
	boolean send(String subject, String text, String from, String to);
}
