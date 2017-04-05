package xyz.ivyxjc.bean;

/**
 * Created by jc on 3/7/2017.
 */


public class User {
    private int id;
    private String name;
    private String password;



//    salt使用username比较不好, 真实情况下, 应该使用更为复杂的salt
    public String getCredentialSalt() {
        return name;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}