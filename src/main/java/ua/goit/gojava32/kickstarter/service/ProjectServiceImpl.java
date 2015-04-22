package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.dao.ProjectDAO;
import ua.goit.gojava32.kickstarter.dao.ProjectDAOImpl;
import ua.goit.gojava32.kickstarter.factory.FactoryModel;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public class ProjectServiceImpl implements ProjectService {

  private ProjectDAO projectDAO = new ProjectDAOImpl();

  @Override
  public void add(Project project, Category category) {
    projectDAO.add(project,category);
  }

  @Override
  public Project add(String name, Category category) {
    Project project = FactoryModel.createProject(name, category);
    projectDAO.add(project,category);
    return projectDAO.get(name);
  }

  @Override
  public void update(Project project) {
    projectDAO.update(project);
  }

  @Override
  public void delete(Project project) {
    projectDAO.delete(project);
    project = null;
  }

  @Override
  public Project get(Integer id) {
    return projectDAO.get(id);
  }

  @Override
  public Project get(String name) {
    return projectDAO.get(name);
  }
}
