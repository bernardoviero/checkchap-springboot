package checkchap.checkchapfullstack.url;

import java.util.Date;

public record UrlResponseDTO(Long id, String nome, Date dataCriacao){
    public UrlResponseDTO(Url url){
        this(url.getId(), url.getNome(), url.getDataCriacao());
    }
}
