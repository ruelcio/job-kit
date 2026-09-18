package ao.JobKit.jobkit.auth.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class RegisterResponse {
    private UUID            id;
    private String          name;
    private String          email;
    private LocalDateTime   createdAt;

    public RegisterResponse(UUID id, String name, String email, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }
}
