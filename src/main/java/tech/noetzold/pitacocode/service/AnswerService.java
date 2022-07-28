package tech.noetzold.pitacocode.service;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.noetzold.pitacocode.model.Answer;

public interface AnswerService extends JpaRepository<Answer, Long> {
}
