package tn.esprit.backendpi.Service.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.Question;
import tn.esprit.backendpi.Repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return (List<Question>) questionRepository.findAll();
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question getQuestionById(Long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    public Question updateQuestion(Long questionId, Question updatedQuestion) {
        Question existingQuestion = questionRepository.findById(questionId).orElse(null);
        if (existingQuestion != null) {
            existingQuestion.setText(updatedQuestion.getText());

            // Mettez à jour d'autres champs si nécessaire
            return questionRepository.save(existingQuestion);
        }
        return null;
    }

    public void deleteQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
    }
}
