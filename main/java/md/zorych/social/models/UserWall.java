package md.zorych.social.models;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by adm on 19.01.2016.
 */
public class UserWall {
    private int id;
    private int user_id;
    @NotEmpty
    private String message_text;

    public String getMessage_text() {
        return message_text;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
