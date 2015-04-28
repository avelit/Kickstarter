package ua.goit.gojava32.kickstarter.test;

import org.junit.Test;
import ua.goit.gojava32.kickstarter.service.SendMail;
public class MailTest {

    @Test
    public void SendEmailTest(){
        SendMail.send("your@email","press for register","/userActivate?token=");

    }
}
