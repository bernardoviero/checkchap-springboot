package checkchap.checkchapfullstack.url;

import java.util.Date;

public record UrlRequestDTO(String nome_url, Date data_criacao){
    public UrlRequestDTO(Url url){
        this(url.getNome(), url.getData_criacao());
    }
}
