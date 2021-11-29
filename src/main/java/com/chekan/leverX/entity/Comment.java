package com.chekan.leverX.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "message")
    private String message;

    @Column(name = "rate")
    private int rate;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "approved")
    private boolean approved;

    @ManyToOne
    @JoinColumn(name="post_id", nullable=false)
    private GameObject post;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="author_id", nullable=false)
    private User author;

    public Comment() {}

    public Comment(String message, int rate, GameObject post, User author) {
        this.message = message;
        this.rate = rate;
        this.post = post;
        this.author = author;
        this.createdAt = new Date(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public GameObject getPost() {
        return post;
    }

    public void setPost(GameObject post) {
        this.post = post;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", rate=" + rate +
                ", createdAt=" + createdAt +
                ", approved=" + approved +
                ", post=" + post +
                ", author=" + author +
                '}';
    }
}