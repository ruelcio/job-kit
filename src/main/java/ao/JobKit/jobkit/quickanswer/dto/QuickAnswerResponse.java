package ao.JobKit.jobkit.quickanswer.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class QuickAnswerResponse {
    private UUID            id;
    private String          question;
    private String          content;
    private LocalDateTime   createdAt;

    public QuickAnswerResponse(UUID id, String question, String content, LocalDateTime createdAt) {
        this.id = id;
        this.question = question;
        this.content = content;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return this.id;
    }

    public String getQuestion() {
        return this.question;
    }

    public String getContent() {
        return this.content;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }
}