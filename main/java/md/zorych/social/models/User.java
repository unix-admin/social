package md.zorych.social.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.UniqueConstraint;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by adm on 16.01.2016.
 */
public class User extends Object{

    private int friendshipRequestCount;
    private  Photos userPhoto;
    private int id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date_birth;
    @Email(message="E-mail not valid")
    private String e_mail;
    private String name;
    private String surname;
    private  int city_id;
    private String avatar;
    private Set<UserRoles> userRole = new HashSet<UserRoles>(0);
    private Set<UserWall> userWall = new HashSet<UserWall>(0);
    private Set<Photos> userPhotos = new HashSet<Photos>(0);
    private Set<Friendship> friends = new HashSet<Friendship>(0);
    private Set<FriendshipRequests> friendshipRequests = new HashSet<FriendshipRequests>(0);

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(Date date_birth) {
        this.date_birth = date_birth;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Set<UserRoles> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRoles> userRole) {
        this.userRole = userRole;
    }

    public Set<UserWall> getUserWall() {
        return userWall;
    }

    public void setUserWall(Set<UserWall> userWall) {
        this.userWall = userWall;
    }

    public Set<Photos> getUserPhotos() {
        return userPhotos;
    }

    public void setUserPhotos(Set<Photos> userPhotos) {
        this.userPhotos = userPhotos;
    }

    public Set<Friendship> getFriends() {
        return friends;
    }

    public void setFriends(Set<Friendship> friends) {
        this.friends = friends;
    }

    public Photos getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(Photos userPhoto) {
        this.userPhoto = userPhoto;
    }

    public int getFriendshipRequestCount() {
        return friendshipRequestCount;
    }

    public void setFriendshipRequestCount(int friendshipRequestCount) {
        this.friendshipRequestCount = friendshipRequestCount;
    }

    public Set<FriendshipRequests> getFriendshipRequests() {
        return friendshipRequests;
    }

    public void setFriendshipRequests(Set<FriendshipRequests> friendshipRequests) {
        this.friendshipRequests = friendshipRequests;
    }
}
