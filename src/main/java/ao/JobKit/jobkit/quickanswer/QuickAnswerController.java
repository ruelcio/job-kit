package ao.JobKit.jobkit.quickanswer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.JobKit.jobkit.quickanswer.dto.QuickAnswerRequest;
import ao.JobKit.jobkit.quickanswer.dto.QuickAnswerResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/quick-answers")
public class QuickAnswerController {
    private final QuickAnswerService quickAnswerService;

    public QuickAnswerController(QuickAnswerService quickAnswerService) {
        this.quickAnswerService = quickAnswerService;
    }

    @PostMapping
    public ResponseEntity<QuickAnswerResponse>   addQuickAnswer(@Valid @RequestBody QuickAnswerRequest quickAnswerRequest) {
        QuickAnswer quickAnswer = quickAnswerService.addQuickAnswer(quickAnswerRequest);

        return ResponseEntity
            .status(201)
            .body(new QuickAnswerResponse(
                quickAnswer.getId(),
                quickAnswer.getQuestion(),
                quickAnswer.getContent(),
                quickAnswer.getCreatedAt()
            )
        );
    }
}
