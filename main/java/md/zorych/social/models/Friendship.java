package md.zorych.social.models;

/**
 * Created by adm on 19.01.2016.
 */

public class Friendship {

        private md.zorych.social.models.User user;
        private md.zorych.social.models.User friend;

        private int id;
        private int user_id;
        private int friend_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(int friend_id) {
        this.friend_id = friend_id;
    }

    public md.zorych.social.models.User getUser() {
        return user;
    }

    public void setUser(md.zorych.social.models.User user) {
        this.user = user;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }
}
