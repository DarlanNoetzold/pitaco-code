package tech.noetzold.pitacocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.noetzold.pitacocode.model.Post;
import tech.noetzold.pitacocode.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @Transactional
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Post>> getAll(HttpServletRequest request, HttpServletResponse response, Pageable pageable) {
        return new ResponseEntity<>(postService.findAll(pageable), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> getAlertaId(@PathVariable("id") long id) {

        Post post = postService.findById(id).get();

        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/usuario/{usuario}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Post>> getPostUsuario(@PathVariable("usuario") String usuario) {

        List<Post> posts = postService.findAllByUsuario(usuario);

        return new ResponseEntity<Collection<Post>>(posts, HttpStatus.OK);
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Post> save(@RequestBody Post post, HttpServletRequest request, HttpServletResponse response) {
        try {
            post.setDate_register(Calendar.getInstance());
            post = postService.save(post);
            return new ResponseEntity<Post>(post, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Post>(post, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @GetMapping("remover/{id}")
    public String remover(@PathVariable("id") Long id) {
        postService.deleteById(id);
        return "redirect:/home";
    }

}
