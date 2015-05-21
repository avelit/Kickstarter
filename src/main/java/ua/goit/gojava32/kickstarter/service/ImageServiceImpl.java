package ua.goit.gojava32.kickstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.gojava32.kickstarter.dao.ImageDAO;
import ua.goit.gojava32.kickstarter.model.Image;

@Transactional
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageDAO imageDAO;

    @Override
    public Image update(Image val) {
        return imageDAO.update(val);
    }

    @Override
    public Image delete(Image val) {
        return imageDAO.delete(val);
    }

    @Override
    public Image get(Integer id) {
        return imageDAO.get(id);
    }

    @Override
    public Image add(Image val) {
        return imageDAO.add(val);
    }
}
