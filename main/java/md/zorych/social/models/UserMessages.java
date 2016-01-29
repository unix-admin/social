package md.zorych.social.models;

import java.util.Date;

/**
 * Created by adm on 19.01.2016.
 */
public class UserMessages {
    int id;
    Date data;
    int from_user_id;
    int to_user_id;
    String message_text;
}
