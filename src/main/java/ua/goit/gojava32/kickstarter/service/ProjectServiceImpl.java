package ua.goit.gojava32.kickstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.gojava32.kickstarter.dao.BlogPostDAO;
import ua.goit.gojava32.kickstarter.dao.CommentDAO;
import ua.goit.gojava32.kickstarter.dao.ProjectDAO;
import ua.goit.gojava32.kickstarter.factory.FactoryModel;
import ua.goit.gojava32.kickstarter.model.*;

import java.util.List;
@Transactional
@Service
public class ProjectServiceImpl implements ProjectService {

  @Autowired
  private ProjectDAO projectDAO;
  @Autowired
  private CommentDAO commentDAO;
  @Autowired
  private BlogPostDAO blogPostDAO;

  @Override
  public Project add(String name, String description, Category category) {
    Project project = FactoryModel.createProject(name, category, description);

    return  projectDAO.add(project);
  }

  @Override
  public Project update(Project project) {
    projectDAO.update(project);
    return project;
  }

  @Override
  public Project delete(Project project) {
    projectDAO.delete(project);
    return project;
  }

  @Override
  public Project get(Integer id) {
    return projectDAO.get(id);
  }


  @Override
  public Project add(Project val) {
    return  projectDAO.add(val);
  }


  @Override
  public List<Project> findFrom(String searchRequest) {
    return projectDAO.findFrom(searchRequest);
  }

  @Override
  public List<Comment> getProjectComments(Project project) {
    return commentDAO.getByProject(project);
  }

  @Override
  public List<BlogPost> getProjectBlogPosts(Project project) {
    return blogPostDAO.getByProject(project);
  }

  @Override
  public List<Project> findAllProjects(User user) {
    return projectDAO.findAllProjects(user);
  }
}

