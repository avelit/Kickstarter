package ua.goit.gojava32.kickstarter.data;

import ua.goit.gojava32.kickstarter.model.Project;

public interface ProjectDAO {
  Project add(Project project);
  Project update(Project project);
  Project delete(Project project);
  Project get(Integer id);

}
