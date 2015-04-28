package ua.goit.gojava32.kickstarter.test;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import ua.goit.gojava32.kickstarter.service.SendMail;

public class MailTest {

//  @Ignore
  @Test
  public void SendEmailTest() {
    SendMail.send("warrax_net@ukr.net", "press for register", "/userActivate?token=");

  }
}
