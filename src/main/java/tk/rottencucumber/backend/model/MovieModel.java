package tk.rottencucumber.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name="movies")
public class MovieModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "slug", nullable = false, unique = true)
    private String slug;
    @Column(name = "summary")
    private String summary;
    @Column(name = "preview", nullable = false)
    private String preview;
    @Lob
    @Column(name = "image")
    private Blob image;
    @Column(name = "type")
    private String type;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable
    Set<GenreModel> genres;
    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private LanguageModel language;
    @Column(name = "release_date", nullable = false)
    private LocalDate release;
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable
    Set<ActorModel> actors;
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable
    Set<DirectorModel> directors;
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable
    Set<WriterModel> writers;
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable
    Set<PlatformModel> platforms;

    //Reverse relations
    @OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE)
    private Set<ReviewModel> reviews;
}