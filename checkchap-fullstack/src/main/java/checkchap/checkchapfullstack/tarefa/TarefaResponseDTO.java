package checkchap.checkchapfullstack.tarefa;

import java.util.Date;

public record TarefaResponseDTO(Long id, String titulo, Date dataModificacao) {
    public TarefaResponseDTO(Tarefa tarefa) {
        this(tarefa.getId(), tarefa.getTitulo(), tarefa.getDataModificacao());
    }
}
