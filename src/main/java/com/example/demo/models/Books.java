package com.example.demo.models;

import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;
    private String book_name;
    private float book_price;
    private String book_dics;
    private String book_picture;
    private Integer book_quantity;
    private float book_discount;
    private OffsetDateTime create_at;
    private OffsetDateTime update_at;
    private Integer author_id;
    private Integer topic_id;

    public void setBook(Books book) {
        this.book_name = book.getBook_name();
        this.book_dics = book.getBook_dics();
        this.book_price = book.getBook_price();
        this.book_quantity = book.getBook_quantity();
        this.book_discount = book.getBook_discount();
        this.author_id = book.getAuthor_id();
        this.topic_id = book.getTopic_id();
    }

    @PrePersist
    protected void onCreate() {
        create_at = OffsetDateTime.now();
        update_at = OffsetDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        update_at = OffsetDateTime.now();
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public float getBook_price() {
        return book_price;
    }

    public void setBook_price(float book_price) {
        this.book_price = book_price;
    }

    public String getBook_dics() {
        return book_dics;
    }

    public void setBook_dics(String book_dics) {
        this.book_dics = book_dics;
    }

    public String getBook_picture() {
        return book_picture;
    }

    public void setBook_picture(String book_picture) {
        this.book_picture = book_picture;
    }

    public Integer getBook_quantity() {
        return book_quantity;
    }

    public void setBook_quantity(Integer book_quantity) {
        this.book_quantity = book_quantity;
    }

    public float getBook_discount() {
        return book_discount;
    }

    public void setBook_discount(float book_discount) {
        this.book_discount = book_discount;
    }

    public OffsetDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(OffsetDateTime create_at) {
        this.create_at = create_at;
    }

    public OffsetDateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(OffsetDateTime update_at) {
        this.update_at = update_at;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public Integer getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Integer topic_id) {
        this.topic_id = topic_id;
    }
}
