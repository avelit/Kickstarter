package ua.goit.gojava32.kickstarter.test;

import org.junit.Test;
import ua.goit.gojava32.kickstarter.service.SendMail;
public class MailTest {

    @Test
    public void SendEmailTest(){
        SendMail.send("kickstartergoit32@gmail.com","It`s fucking work!", "It`s fucking work!");
    }
}
