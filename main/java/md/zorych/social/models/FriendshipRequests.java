package md.zorych.social.models;

/**
 * Created by adm on 19.01.2016.
 */
public class FriendshipRequests {
    private Integer id;
    private Integer from_user_id;
    private Integer to_user_id;
    private User fromUser;
    private User toUrer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFrom_user_id() {
        return from_user_id;
    }

    public void setFrom_user_id(Integer from_user_id) {
        this.from_user_id = from_user_id;
    }

    public Integer getTo_user_id() {
        return to_user_id;
    }

    public void setTo_user_id(Integer to_user_id) {
        this.to_user_id = to_user_id;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUrer() {
        return toUrer;
    }

    public void setToUrer(User toUrer) {
        this.toUrer = toUrer;
    }
}
