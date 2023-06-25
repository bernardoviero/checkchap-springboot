package checkchap.checkchapfullstack.url;

import java.util.Date;

public record UrlResponseDTO(Long id, String nome_url, Date data_criacao){
    public UrlResponseDTO(Url url){
        this(url.getId(), url.getNome(), url.getData_criacao());
    }
}
