package tech.noetzold.pitacocode.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Entity
public class Answer {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @ManyToOne(optional = true)
    @JoinColumn(name="post_id", referencedColumnName = "id", nullable = true)
    private Post post;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_register", nullable = false)
    private Calendar date_register;

    @Type(type="text")
    private String suggestion;

    @NotNull
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Calendar getDate_register() {
        return date_register;
    }

    public void setDate_register(Calendar date_register) {
        this.date_register = date_register;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
}
