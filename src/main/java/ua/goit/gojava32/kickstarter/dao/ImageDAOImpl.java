package ua.goit.gojava32.kickstarter.dao;

import org.springframework.stereotype.Repository;
import ua.goit.gojava32.kickstarter.model.Image;

@Repository
public class ImageDAOImpl extends AbstractDAO<Image> implements ImageDAO {

    ImageDAOImpl() {
        super(Image.class);
    }
}
