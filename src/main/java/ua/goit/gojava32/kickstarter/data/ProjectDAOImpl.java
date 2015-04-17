package ua.goit.gojava32.kickstarter.data;

import java.util.Collections;

import ua.goit.gojava32.kickstarter.model.Project;

public class ProjectDAOImpl implements ProjectDAO {

  @Override
  public Project add(Project project) {
    Collections.addAll(project.getCategory(), project);
    return project;
  }

  @Override
  public Project update(Project project) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Project delete(Project project) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Project get(Integer id) {
    // TODO Auto-generated method stub
    return null;
  }

}
