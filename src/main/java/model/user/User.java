package model.user;

//import com.google.gson.annotations.SerializedName;

/**
 * Created by steve on 2015/9/13.
 */
public class User {

//    @SerializedName("id")
    private String id;

//    @SerializedName("name")
    private String name;

//    @SerializedName("email")
    private String email;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
