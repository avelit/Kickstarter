package ua.goit.gojava32.kickstarter.service;

import ua.goit.gojava32.kickstarter.dao.ProjectDAO;
import ua.goit.gojava32.kickstarter.dao.ProjectDAOImpl;
import ua.goit.gojava32.kickstarter.model.Project;

public class ProjectServiceImpl implements ProjectService {

    private ProjectDAO projectDAO = new ProjectDAOImpl();

    @Override
    public void add(Project project) {
        projectDAO.add(project);
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
}
