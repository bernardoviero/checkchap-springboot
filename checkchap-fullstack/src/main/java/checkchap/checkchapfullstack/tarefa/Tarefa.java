package checkchap.checkchapfullstack.tarefa;

import checkchap.checkchapfullstack.url.Url;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tarefa")
@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @OneToOne
    @JoinColumn(name = "idUrl")
    private Url url;

    @Column(name = "dataModificacao")
    private Date dataModificacao;
}
