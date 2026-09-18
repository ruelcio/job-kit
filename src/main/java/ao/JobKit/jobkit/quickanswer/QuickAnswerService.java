package ao.JobKit.jobkit.quickanswer;

import org.springframework.stereotype.Service;

import ao.JobKit.jobkit.quickanswer.dto.QuickAnswerRequest;

@Service 
public class QuickAnswerService {
    private final QuickAnswerRepository   quickAnswerRepository;

    public QuickAnswerService(QuickAnswerRepository quickAnswerRepository) {
        this.quickAnswerRepository = quickAnswerRepository;
    }

    public QuickAnswer  addQuickAnswer(QuickAnswerRequest quickAnswerRequest) {
        QuickAnswer quickAnswer = new QuickAnswer(quickAnswerRequest.getQuestion(), quickAnswerRequest.getContent());

        return quickAnswerRepository.save(quickAnswer);
    }
}
