package ua.goit.gojava32.kickstarter.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.goit.gojava32.kickstarter.model.User;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

  private Logger logger = Logger.getLogger(this.getClass());

  @Autowired
  private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userService.findUserByEmail(email);
    logger.info("filter login: " + email);
    return user;
  }
}
