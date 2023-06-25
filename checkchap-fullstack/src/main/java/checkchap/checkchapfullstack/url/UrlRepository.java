package checkchap.checkchapfullstack.url;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Url findUrlByNome(String nome);
}