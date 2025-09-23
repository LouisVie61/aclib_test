package com.aclib.aclib_deploy.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "aclib_loans")
@Getter
@Setter
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loansId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "book_id", referencedColumnName = "id_selfLink", columnDefinition = "VARCHAR(255) NOT NULL")
    private Book book;

    @Column(nullable = false)
    private String idSelfLink;

    @Column(name = "Book_title", nullable = false)
    private String bookTitle;

    @Column(nullable = false)
    private LocalDateTime borrowDate;

    public Loans(long l, LocalDateTime localDateTime, Object o, int i, Object o1, LoanStatus loanStatus) {}

    public Loans() {}

    public enum LoanStatus {
        ACTIVE,
        RETURNED,
        OVERDUE,
        LOST
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LoanStatus loanStatus = LoanStatus.ACTIVE;

    @Column()
    private LocalDateTime returnDate;

    @Column(nullable = false)
    private LocalDateTime dueDate;

    private int renewalCount = 0;

    private LocalDateTime notificationSentDate;
}
