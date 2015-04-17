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
        return projectDAO.add(project);
    }

    @Override
    public Project update(Project project) {
        return projectDAO.update(project);
    }

    @Override
    public Project delete(Project project) {
        return projectDAO.delete(project);
    }

    @Override
    public Project get(Integer id) {
        return projectDAO.get(id);
    }
}
