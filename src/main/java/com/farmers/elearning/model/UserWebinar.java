package com.farmers.elearning.model;

import jakarta.persistence.*;

@Entity
public class UserWebinar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "webinar_id")
    private Webinar webinar;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Webinar getWebinar() {
        return webinar;
    }
    public void setWebinar(Webinar webinar) {
        this.webinar = webinar;
    }
}
