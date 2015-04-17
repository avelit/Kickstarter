package ua.goit.gojava32.kickstarter.data;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public class ProjectDAOImpl implements ProjectDAO {

  @Override
  public void add(Project project) {
    Data.projects.get(project.getCategory()).add(project);
  }

  @Override
  public void update(Project project) {
    // TODO Auto-generated method stub
  }

  @Override
  public void delete(Project project) {
    // TODO Auto-generated method stub
  }

  @Override
  public Project get(Integer id) {
    for (Category cat : Data.projects.keySet()) {
      for (Project project : cat.getProjects()) {
        if (project.getId() == id) {
          return project;
        }
      }
    }
    return null;
  }
}
