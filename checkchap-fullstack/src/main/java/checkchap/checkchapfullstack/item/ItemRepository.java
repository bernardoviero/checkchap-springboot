package checkchap.checkchapfullstack.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository  extends JpaRepository<Item, Long> {
    @Query("SELECT i FROM Item i WHERE i.tarefa.id = :idTarefa")
    List<Item> findItemsByTarefaId(Long idTarefa);

    Item findItemById(Long id);
}
