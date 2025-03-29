package org.example;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

public class ServiceMail implements IMailService {

    private final String username = "2e74a25c291adf";
    private final String password = "05b1cdffe5297b";

    @Override
    public void enviarCorreo(String destinatario, String asunto, String mensaje) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("no-reply@tuapp.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            msg.setSubject(asunto);
            msg.setText(mensaje);
            Transport.send(msg);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}