package ua.goit.gojava32.kickstarter.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
import ua.goit.gojava32.kickstarter.dao.*;
import ua.goit.gojava32.kickstarter.factory.FactoryModel;
import ua.goit.gojava32.kickstarter.model.BlogPost;
import ua.goit.gojava32.kickstarter.model.Category;
import ua.goit.gojava32.kickstarter.model.Comment;
import ua.goit.gojava32.kickstarter.model.Project;
@Component
public class ProjectServiceImpl implements ProjectService {

  private ProjectDAO projectDAO = new ProjectDAOImpl();
  private CommentDAO commentDAO = new CommentDAOImpl();
  private BlogPostDAO blogPostDAO = new BlogPostDAOImpl();

  @Override
  public Project add(String name, String description, Category category) {
    Project project = FactoryModel.createProject(name, category, description);

    return  projectDAO.add(project);
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
  public Project add(Project val) {
    return null;
  }


  @Override
  public Set<Project> findFrom(String searchRequest) {
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
}

