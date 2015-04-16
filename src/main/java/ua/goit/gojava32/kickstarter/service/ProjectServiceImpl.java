package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.model.Project;
import java.util.ArrayList;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private List<Project> projects = new ArrayList<Project>();

    @Override
    public Project add(Project project) {
        projects.add(project);
        return project;
    }

    @Override
    public Project update(Project project) {
        return project;
    }

    @Override
    public Project delete(Project project) {
        projects.remove(project);
        return project;
    }

    @Override
    public Project get(Integer id) {
        return projects.get(id);
    }
}
