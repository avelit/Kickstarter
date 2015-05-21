package ua.goit.gojava32.kickstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.gojava32.kickstarter.dao.BlogPostDAO;
import ua.goit.gojava32.kickstarter.model.BlogPost;
@Transactional
@Service
public class BlogPostServiceImpl implements BlogPostService {

  @Autowired
  private BlogPostDAO blogPostDAO;

  @Override
  public void addProjectBlog(BlogPost blogPost) {
    blogPostDAO.add(blogPost);
  }
}
