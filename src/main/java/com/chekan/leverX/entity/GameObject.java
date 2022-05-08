package com.chekan.leverX.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "game_object")
public class GameObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    @Size(min = 2, max = 50, message = "Title length must be between 2 and 50 characters")
    private String title;

    @Column(name = "text")
    @Size(min = 2, message = "Text length must be more than 2 characters")
    private String text;

    @Column(name = "price")
    @Min(value = 1, message = "Price must be greater than zero")
    private double price;

    @Column(name = "is_approved")
    private boolean isApproved;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "game_id")
    @Min(value = 1, message = "Game id must be greater than zero")
    private int game_id;

    @Column(name = "user_id")
    @Min(value = 1, message = "User id must be greater than zero")
    private int user_id;

    public GameObject() {}

    public GameObject(String title, String text, double price, int game, int user) {
        this.title = title;
        this.text = text;
        this.price = price;
        this.game_id = game;
        this.user_id = user;
        this.createdAt = new Date(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GameObject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", price=" + price +
                ", isApproved=" + isApproved +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", game_id=" + game_id +
                ", user_id=" + user_id +
                '}';
    }
}