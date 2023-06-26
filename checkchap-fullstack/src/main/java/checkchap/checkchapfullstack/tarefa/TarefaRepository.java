package checkchap.checkchapfullstack.tarefa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TarefaRepository  extends JpaRepository<Tarefa, Long> {
    @Query("SELECT t FROM Tarefa t WHERE t.url.id = :idUrl")
    Tarefa findTarefaByIdUrl(Long idUrl);

    Tarefa findTarefaById(Long id);

    @Query("SELECT t FROM Tarefa t WHERE t.url.nome = :nomeUrl")
    Tarefa findByUrlNome(String nomeUrl);
}
