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
    private String title;

    @Type(type="text")
    private String code;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_register", nullable = false)
    private Calendar date_register;

    @NotNull
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private ProgrammingLanguage programmingLanguage;

    @Enumerated(EnumType.STRING)
    private TechnologyType technologyType;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate_register(Calendar date_register) {
        this.date_register = date_register;
    }

    public Calendar getDate_register() {
        return date_register;
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public TechnologyType getTechnologyType() {
        return technologyType;
    }

    public void setTechnologyType(TechnologyType technologyType) {
        this.technologyType = technologyType;
    }
}
