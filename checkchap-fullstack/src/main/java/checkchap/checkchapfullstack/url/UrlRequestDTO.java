package checkchap.checkchapfullstack.url;

import java.util.Date;

public record UrlRequestDTO(String nome, Date dataCriacao){
    public UrlRequestDTO(Url url){
        this(url.getNome(), url.getDataCriacao());
    }
}
