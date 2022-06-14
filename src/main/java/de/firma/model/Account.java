package de.firma.model;

public class Account {
    private String id;
    private String name;
    private String nickname;
    private String logindate;

   public Account(){
   }

    public Account(String id, String name, String nickname, String logindate) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.logindate = logindate;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLogindate() {
        return logindate;
    }

    public void setLogindate(String logindate) {
        this.logindate = logindate;
    }
}
