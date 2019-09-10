package com.fatie.luntan.util;


import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailUtils {

    public static void sendMail(String email, String emailMsg) throws AddressException, MessagingException, GeneralSecurityException {
        // 创建会话对象
        //1、获得邮箱服务的连接(会话对象)
        //封装数据
        Properties props = new Properties();
        //设置发邮件的协议
        props.setProperty("mail.transport.protocol", "SMTP");
        //设置发邮件的地址(smtp邮箱服务器地址)
        //props.setProperty("mail.host", "localhost");
        props.setProperty("mail.smtp.host", "smtp.qq.com");
        // 指定验证为true
        props.setProperty("mail.smtp.auth", "true");
        //QQ邮箱的SSL加密
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        // 创建验证器
        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                //验证邮箱用户名和密码
                return new PasswordAuthentication("2608875917@qq.com", "bzlhnhdmqukwdjcd");//密码
            }
        };

        //会话对象
        Session session = Session.getInstance(props, auth);

        // 创建邮件对象
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("2608875917@qq.com"));
        // 设置发送方式与接收者
        message.setRecipient(RecipientType.TO, new InternetAddress(email));
        //邮件主题
        message.setSubject("激活邮件");
        //设置邮件的正文
        message.setContent(emailMsg, "text/html;charset=utf-8");

        // 邮件发送
        Transport.send(message);
    }
}
