package ua.goit.gojava32.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.goit.gojava32.kickstarter.model.Comment;
import ua.goit.gojava32.kickstarter.model.Project;
import ua.goit.gojava32.kickstarter.service.CommentService;
import ua.goit.gojava32.kickstarter.service.ProjectService;

import java.util.Date;

@org.springframework.stereotype.Controller
public class CommentController {
  @Autowired
  private CommentService commentService;
  @Autowired
  private ProjectService projectService;

  @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
  @ResponseBody
  public ModelAndView addComment(
      @RequestParam("project_id") String project_id,
      @RequestParam("text") String text){

    Project project = projectService.get(Integer.parseInt(project_id));

    Comment newComment = new Comment();
    newComment.setText(text);
    newComment.setProject(project);
    newComment.setCreated(new Date());
    commentService.add(newComment);
    ModelAndView vm = new ModelAndView("redirect:/project/" + project.getId()+"#comments");

    return vm;
  }
}
