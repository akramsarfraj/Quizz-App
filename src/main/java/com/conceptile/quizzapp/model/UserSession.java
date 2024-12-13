package com.conceptile.quizzapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String user_name;
    private String session_Id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSession_Id() {
        return session_Id;
    }

    public void setSession_Id(String session_Id) {
        this.session_Id = session_Id;
    }


}
