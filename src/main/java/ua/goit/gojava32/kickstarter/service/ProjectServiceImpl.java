package ua.goit.gojava32.kickstarter.service;

import java.util.List;

import ua.goit.gojava32.kickstarter.dao.ProjectDAO;
import ua.goit.gojava32.kickstarter.dao.ProjectDAOImpl;
import ua.goit.gojava32.kickstarter.factory.FactoryModel;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Project;

public class ProjectServiceImpl implements ProjectService {

  private ProjectDAO projectDAO = new ProjectDAOImpl();

  @Override
  public Project add(String name, String description, Category category) {
    Project project = FactoryModel.createProject(name, category, description);
    projectDAO.add(project);
    return projectDAO.get(name);
  }

  @Override
  public void update(Project project) {
    projectDAO.update(project);
  }

  @Override
  public void delete(Project project) {
    projectDAO.delete(project);
  }

  @Override
  public Project get(Integer id) {
    return projectDAO.get(id);
  }

  @Override
  public Project get(String name) {
    return projectDAO.get(name);
  }

  @Override
  public Project add(Project val) {
    return null;
  }

  @Override
  public List<String> getComments(Project project) {
    return projectDAO.getComments(project);
  }

  @Override
  public List<String> getBlogs(Project project) {
    return projectDAO.getBlogs(project);
  }

  @Override
  public void addComment(String comment, Project project) {
    projectDAO.addComment(comment, project);
  }

  @Override
  public void addBlog(String comment, Project project) {
    projectDAO.addBlog(comment, project);
  }

  @Override
  public List<Project> findFrom(String searchRequest) {
    return projectDAO.findFrom(searchRequest);
  }
}

