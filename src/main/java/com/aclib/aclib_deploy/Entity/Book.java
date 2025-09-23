package com.aclib.aclib_deploy.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "aclib_book",
        uniqueConstraints = @UniqueConstraint(columnNames = "id_selfLink"))
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Lob
    @Column(name = "thumnail", columnDefinition = "TEXT")
    private String thumbnail;

    @Column(name = "id_selfLink", columnDefinition = "VARCHAR(255) NOT NULL")
    private String idSelfLink;

    @Column(name = "SelfLink", nullable = false)
    private String selfLink;

    @Column(name = "publishdate")
    private String publishDate;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "added_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;

    @Column
    private String category;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private int pageCount;

    @Column(name = "copy_count", nullable = false)
    private int copy = 0;

    /**
     * always set date when saving new book and printing with tag recently add maybe.
     */
    @PrePersist
    protected void onCreate() {
        addedDate = new Date();
    }
}

