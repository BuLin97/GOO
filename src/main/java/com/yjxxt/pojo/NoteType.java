package com.yjxxt.pojo;

public class NoteType {
    private Integer id;
    private String typeName;
    private Integer userId;


    @Override
    public String toString() {
        return "NoteType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", userId=" + userId +
                '}';
    }

    public NoteType(Integer id, String typeName, Integer userId) {
        this.id = id;
        this.typeName = typeName;
        this.userId = userId;
    }

    public NoteType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
