package g.gitops.poc.infrastructure.common.email.impl;

import g.gitops.poc.infrastructure.common.email.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public boolean sendSimpleEmail(String emailFrom, String emailTo, String emailCc, String emailBcc, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailFrom);
        message.setTo(emailTo);
        if(emailCc!=null){
            message.setCc(emailCc);
        }
        if(emailBcc!=null){
            message.setBcc(emailBcc);
        }

        message.setSubject(subject);
        message.setText(body);
        return this.sendSimpleEmail(message);
    }

    public boolean sendSimpleEmail(SimpleMailMessage simpleMessage) {
        log.info("Mail sent to " + simpleMessage.getTo());
        mailSender.send(simpleMessage);
        return true;
    }
}
