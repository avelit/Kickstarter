package ua.goit.gojava32.kickstarter.data;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public class ProjectDAOImpl implements ProjectDAO {

  Data data = new Data();
  
  @Override
  public Project add(Project project) {
    data.projects.get(project.getCategory()).add(project);
    return project;
  }

  @Override
  public Project update(Project project) {
    // TODO Auto-generated method stub
    return project;
  }

  @Override
  public Project delete(Project project) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Project get(Integer id) {
    Collection<List<Project>> projects = data.projects.values();
    for (List<Project> project : projects) {
      if (project.getId() == id){
          return project;
      }
  }

}
