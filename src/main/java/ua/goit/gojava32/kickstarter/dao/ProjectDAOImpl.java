package ua.goit.gojava32.kickstarter.dao;

import ua.goit.gojava32.kickstarter.data.Data;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public class ProjectDAOImpl implements ProjectDAO {

  @Override
  public void add(Project project,Category category) {
    project.setCategory(category);
    Data.projects.get(category).add(project);
    category.addProject(project);
  }

  @Override
  public void update(Project project) {

  }

  @Override
  public void delete(Project project) {
    Data.projects.values().remove(project);
  }

  @Override
  public Project get(Integer id) {
    for (Category cat : Data.projects.keySet()) {
      if (cat.getProjects() != null) {
        for (Project project : cat.getProjects()) {
          if (project.getId().equals(id)) {
            return project;
          }
        }
      }
    }
    return null;
  }

  @Override
  public Project get(String name) {
    for (Category cat : Data.projects.keySet()) {
      if (cat.getProjects() != null) {
        for (Project project : cat.getProjects()) {
          if (project.getName().equals(name)) {
            return project;
          }
        }
      }
    }
    return Data.projects.get(new CategoryDAOImpl().get("medicine")).get(1);
  }
}