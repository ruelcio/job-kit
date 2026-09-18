package ao.JobKit.jobkit.quickanswer;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import ao.JobKit.jobkit.auth.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "quick_answers")
public class QuickAnswer {
    @Id
    @UuidGenerator
    private UUID            id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User            user;

    private String          question;
    private String          content;
    private LocalDateTime   createdAt;
    private LocalDateTime   updatedAt;

    public QuickAnswer(String question, String content) {
        this.question = question;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    protected QuickAnswer() {

    }

    public UUID     getId() {
        return this.id;
    }

    public String   getQuestion() {
        return this.question;
    }

    public String   getContent() {
        return this.content;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }
}
