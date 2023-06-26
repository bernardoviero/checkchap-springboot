package checkchap.checkchapfullstack.tarefa;


import java.util.Date;

public record TarefaRequestDTO(String titulo, Date dataModificacao) {
    public TarefaRequestDTO(Tarefa tarefa){
        this(tarefa.getTitulo(), tarefa.getDataModificacao());
    }
}
