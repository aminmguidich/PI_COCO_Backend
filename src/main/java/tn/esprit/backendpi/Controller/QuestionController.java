package tn.esprit.backendpi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.Question;
import tn.esprit.backendpi.Service.Classes.ChatGPTService;
import tn.esprit.backendpi.Service.Classes.QuestionGenerationService;
import tn.esprit.backendpi.Service.Classes.QuestionService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private ChatGPTService chatGPTService;
    private final QuestionGenerationService questionGenerationService;

    @Autowired // Ajoutez cette annotation pour injecter le service via le constructeur
    public QuestionController(QuestionGenerationService questionGenerationService) {
        this.questionGenerationService = questionGenerationService;
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.getAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }


    @GetMapping("/generateQuestions")
    public ResponseEntity<List<String>> generateQuestions(
            @RequestParam String theme,
            @RequestParam int numQuestions,
            @RequestParam String model
    ) {
        try {
            List<String> generatedQuestions = chatGPTService.generateQuestions(theme, numQuestions, model);
            return new ResponseEntity<>(generatedQuestions, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        Question createdQuestion = questionService.createQuestion(question);
        return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable("id") Long id) {
        Question question = questionService.getQuestionById(id);
        if (question != null) {
            return new ResponseEntity<>(question, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable("id") Long id, @RequestBody Question question) {
        Question updatedQuestion = questionService.updateQuestion(id, question);
        if (updatedQuestion != null) {
            return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable("id") Long id) {
        questionService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
