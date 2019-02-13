package com.annie.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class MailUtil {

    @Autowired
    private JavaMailSender jms;

                            // 收信人     // 设置主题    // 设置内容
    public void sendMail(String toUser, String subject, String text) {

        subject = "感谢的您注册~ ";

        text = "感谢你的注册，你的默认密码是："+"<h3>"+text+"</h3>";

        try {
            MimeMessage mimeMessage = jms.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            // 设置发信人，发信人需要和spring.mail.username配置的一样否则报错
            message.setFrom("1310072293@qq.com");
            // 设置收信人
            message.setTo(toUser);
            // 设置主题
            message.setSubject(subject);
            // 第二个参数true表示使用HTML语言来编写邮件
            message.setText(text, true);
            //FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/image/picture.jpg"));
            //helper.addAttachment("图片.jpg", file);//添加带附件的邮件
            //helper.addInline("picture", file);//添加带静态资源的邮件
            jms.send(mimeMessage);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}