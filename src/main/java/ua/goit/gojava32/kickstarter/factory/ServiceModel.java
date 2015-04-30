package ua.goit.gojava32.kickstarter.factory;

import ua.goit.gojava32.kickstarter.service.*;

public class ServiceModel {

  public static CategoryService getCategoryService() {
    return new CategoryServiceImpl();
  }

  public static ProjectService getProjectService() {
    return new ProjectServiceImpl();
  }

  public static CommentService getCommentService() {
    return new CommentServiceImpl();
  }

  public static UserService getUserService() {
    return new UserServiceImpl();
  }
}
