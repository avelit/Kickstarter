package ua.goit.gojava32.kickstarter.service;

import org.springframework.stereotype.Component;
import ua.goit.gojava32.kickstarter.dao.BlogPostDAO;
import ua.goit.gojava32.kickstarter.dao.BlogPostDAOImpl;
import ua.goit.gojava32.kickstarter.model.BlogPost;

@Component
public class BlogPostServiceImpl implements BlogPostService {
  private BlogPostDAO blogPostDAO = new BlogPostDAOImpl();

  @Override
  public void addProjectBlog(BlogPost blogPost) {
    blogPostDAO.add(blogPost);
  }
}
