package ao.JobKit.jobkit.quickanswer.dto;

import jakarta.validation.constraints.NotBlank;

public class QuickAnswerRequest {
    @NotBlank
    String  question;

    @NotBlank 
    String  content;

    public String   getQuestion() {
        return question;
    }
    public String   getContent() {
        return content;
    }

    public void     setQuestion(String question) {
        this.question = question;
    }

    public void     setContent(String content) {
        this.content = content;
    }
}
