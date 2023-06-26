package checkchap.checkchapfullstack.item;

import checkchap.checkchapfullstack.tarefa.Tarefa;
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
@Table(name = "item")
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item")
    private String item;

    @OneToOne
    @JoinColumn(name = "idTarefa")
    private Tarefa tarefa;

    @Column(name = "dataModificacao")
    private Date dataModificacao;

    @Column(name = "situacao")
    private int situacao;

    @Column(name = "excluido")
    private int excluido;
}
