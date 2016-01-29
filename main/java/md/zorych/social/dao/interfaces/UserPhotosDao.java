package md.zorych.social.dao.interfaces;

import md.zorych.social.models.Photos;
import md.zorych.social.models.User;
import md.zorych.social.models.Photos;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by adm on 19.01.2016.
 */
public interface UserPhotosDao {

    public List<Photos> getPhotos(int user);
    public  void addPhoto(String path, int userId);
    public void  deletePhoto(Photos photo);
}
