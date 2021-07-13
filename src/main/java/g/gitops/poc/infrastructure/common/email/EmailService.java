package g.gitops.poc.infrastructure.common.email;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    boolean sendSimpleEmail(String emailFrom, String emailTo, String emailCc, String emailBcc, String subject, String body);
    boolean sendSimpleEmail(SimpleMailMessage simpleMessage);
}
