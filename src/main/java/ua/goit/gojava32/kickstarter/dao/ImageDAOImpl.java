package ua.goit.gojava32.kickstarter.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.goit.gojava32.kickstarter.model.Image;
import ua.goit.gojava32.kickstarter.model.Project;

import java.util.List;

@Repository
public class ImageDAOImpl extends AbstractDAO<Image> implements ImageDAO {

  @Autowired
  private ProjectDAO projectDAO;

  ImageDAOImpl() {
    super(Image.class);
  }

  @Override
  public Image getByProjectId(int id) {
    Project project = projectDAO.get(id);
    Session session = getSession();
    Query query = session.createQuery("FROM Image WHERE project = :project");
    query.setParameter("project", project);
    List<Image> list = query.list();
    if (list.isEmpty()) {
      return null;
    } else {
      return list.get(0);
    }
  }
}
