package com.morev.springboottask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {


    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知-今晚开会");

        message.setText("今晚7:30开会 张畅君");

        message.setTo("490138742@qq.com");
        message.setFrom("496043045@qq.com");
        javaMailSender.send(message);

    }

    @Test
    public void test02() throws Exception{
        //1.创建一个复杂的消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();


        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setSubject("通知-今晚开会");

        helper.setText("<b style='color: red'>今晚7:30开会 张畅君</b>",true);

        helper.setTo("490138742@qq.com");
        helper.setFrom("496043045@qq.com");

        //上传文件
        helper.addAttachment("07becb16fdfaaf51b6f696ca875494eef11f7ad7.jpg",new File("C:\\Users\\Administrator\\Desktop\\图片\\07becb16fdfaaf51b6f696ca875494eef11f7ad7.jpg"));

    }

}
