package md.zorych.social.services.interfaces;

import md.zorych.social.models.Photos;
import md.zorych.social.models.User;
import md.zorych.social.models.Photos;

import java.util.List;

/**
 * Created by adm on 19.01.2016.
 */
public interface UserPhotosService {

    public List<Photos> getPhotos(int userId);
    public  void addPhoto(String path,int userId);
    public void  deletePhoto(Photos photo);

}
