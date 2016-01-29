package md.zorych.social.dao;

import md.zorych.social.dao.interfaces.UserPhotosDao;
import md.zorych.social.models.Photos;
import md.zorych.social.models.User;
import md.zorych.social.models.Photos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by adm on 19.01.2016.
 */
public class UserPhotosDaoImpl implements UserPhotosDao{



    private SessionFactory sessionFactory;

    public UserPhotosDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    public List<Photos> getPhotos(int userId) {
        return null;
    }
    @Transactional
    public void addPhoto(String path, int userId    ) {
        Photos photo = new Photos();
        photo.setUser_id(userId);
        photo.setPath(path);
        Session session = sessionFactory.getCurrentSession();
        session.save(photo);


    }
    @Transactional
    public void deletePhoto(Photos photo) {

    }
}
