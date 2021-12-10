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

    @Column(name = "post_id")
    private int postId;

    public Comment() {
    }

    public Comment(String message, int rate, boolean approved, int postId) {
        this.message = message;
        this.rate = rate;
        this.approved = approved;
        this.postId = postId;
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

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", rate=" + rate +
                ", createdAt=" + createdAt +
                ", approved=" + approved +
                ", postId=" + postId +
                '}';
    }
}