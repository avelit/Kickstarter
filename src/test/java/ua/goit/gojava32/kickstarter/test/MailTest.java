package ua.goit.gojava32.kickstarter.test;

import org.junit.Ignore;
import org.junit.Test;

import ua.goit.gojava32.kickstarter.service.SendMail;

public class MailTest {

  @Ignore
  @Test
  public void SendEmailTest() {
    SendMail.send("avelit@ukr.net", "press for register", "/userActivate?token=");
  }
}
