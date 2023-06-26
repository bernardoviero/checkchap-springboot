package checkchap.checkchapfullstack.item;

import checkchap.checkchapfullstack.tarefa.Tarefa;

import java.util.Date;

public record ItemRequestDTO(String item, Date dataModificacao, int Situacao) {
    public ItemRequestDTO(Item item){
        this(item.getItem(), item.getDataModificacao(), item.getSituacao());
    }
}
