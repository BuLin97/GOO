package com.yjxxt.pojo;

import java.util.Objects;

/**
 * @author : guojing
 * @date : 17:57 2022/8/15
 */
public class User {
    // 主键
    private Integer id;
    // 用户名
    private String userName;
    // 密码
    private  String userPwd;
    // 昵称
    private String nick;
    // 心情
    private String mood;
    // 头像
    private String head;

    public User(Integer id, String userName, String userPwd, String nick, String mood, String head) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.nick = nick;
        this.mood = mood;
        this.head = head;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", nick='" + nick + '\'' +
                ", mood='" + mood + '\'' +
                ", head='" + head + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
