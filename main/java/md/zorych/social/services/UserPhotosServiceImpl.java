package md.zorych.social.services;

import md.zorych.social.dao.interfaces.UserPhotosDao;
import md.zorych.social.models.Photos;
import md.zorych.social.models.User;
import md.zorych.social.models.Photos;
import md.zorych.social.services.interfaces.UserPhotosService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by adm on 19.01.2016.
 */
public class UserPhotosServiceImpl implements UserPhotosService {

    @Autowired
    UserPhotosDao userPhotosDao;

    public List<Photos> getPhotos(int userId) {
        return null;
    }

    public void addPhoto(String path, int userId) {
    userPhotosDao.addPhoto(path, userId);
    }

    public void deletePhoto(Photos photo) {

    }
}
