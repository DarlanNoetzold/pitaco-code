package tech.noetzold.pitacocode.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Set;

@Entity
public class Post {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Type(type="text")
    private String code;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    private Set<Answer> answers;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro", nullable = false)
    private Calendar data_cadastro;

    @NotNull
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public Calendar getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Calendar data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
