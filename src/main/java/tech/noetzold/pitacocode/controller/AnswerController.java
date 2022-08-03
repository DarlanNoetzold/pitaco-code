package tech.noetzold.pitacocode.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.noetzold.pitacocode.model.Answer;
import tech.noetzold.pitacocode.service.AnswerService;
import tech.noetzold.pitacocode.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @Autowired
    PostService postService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @Transactional
    public ResponseEntity<Collection<Answer>> getAll(HttpServletRequest request, HttpServletResponse response) {
        return new ResponseEntity<Collection<Answer>>(answerService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @Transactional
    public ResponseEntity<Answer> getImagemById(@PathVariable("id") long id) {

        Answer answer = answerService.findById(id).get();

        return new ResponseEntity<Answer>(answer, HttpStatus.OK);
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Answer> save(@RequestBody Answer answer) {
        try {
            answer.setPost(postService.findById(answer.getPost().getId()).get());
            answer = answerService.save(answer);
            return new ResponseEntity<Answer>(answer, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Answer>(answer, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
