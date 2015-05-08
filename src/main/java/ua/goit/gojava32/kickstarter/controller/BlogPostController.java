package ua.goit.gojava32.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.gojava32.kickstarter.model.BlogPost;
import ua.goit.gojava32.kickstarter.model.Comment;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.BlogPostService;
import ua.goit.gojava32.kickstarter.service.CommentService;
import ua.goit.gojava32.kickstarter.service.ProjectService;

import java.util.Date;


@org.springframework.stereotype.Controller
public class BlogPostController {

  @Autowired
  private ProjectService projectService;

  @Autowired
  private BlogPostService blogPostService;

  @RequestMapping(value = "/blogpost/add", method = RequestMethod.POST)
  @ResponseBody
  public ModelAndView addBlogPost(
      @RequestParam("project_id") String project_id,
      @RequestParam("text") String text) {

    Project project = projectService.get(Integer.parseInt(project_id));
    BlogPost blogPost = new BlogPost();
    blogPost.setText(text);
    blogPost.setProject(project);
    blogPost.setCreated(new Date());
    blogPostService.addProjectBlog(blogPost);

    ModelAndView vm = new ModelAndView("redirect:/project/" + project.getId() + "#blogposts");

    return vm;


  }
}
