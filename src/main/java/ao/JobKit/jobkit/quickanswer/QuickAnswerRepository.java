package ao.JobKit.jobkit.quickanswer;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuickAnswerRepository extends JpaRepository<QuickAnswer, UUID> {
    
}
