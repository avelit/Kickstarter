package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.data.ProjectDAO;
import ua.goit.gojava32.kickstarter.data.ProjectDAOImpl;
import ua.goit.gojava32.kickstarter.model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private ProjectDAO projectDAO = new ProjectDAOImpl();

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
