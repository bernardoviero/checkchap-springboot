package checkchap.checkchapfullstack.item;

import java.util.Date;

public record ItemResponseDTO(Long id, String item, Date dataModificacao, int situacao) {
    public ItemResponseDTO(Item item) {
        this(item.getId(), item.getItem(), item.getDataModificacao(), item.getSituacao());
    }
}
