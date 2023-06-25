package checkchap.checkchapfullstack.controller;

import checkchap.checkchapfullstack.url.Url;
import checkchap.checkchapfullstack.url.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/")
public class UrlController {

    @Autowired
    private UrlRepository urlRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/url")
    public String criarUrl(@RequestParam("nomeUrl") String nomeUrl, Model model) {
        Url url = urlRepository.findUrlByNome(nomeUrl);
        if (url == null) {
            url = new Url();
            url.setNome(nomeUrl);
            url.setData_criacao(new java.util.Date());
            urlRepository.save(url);
        }
        System.out.println("Redirecionado para: " + url.getNome());

        // Defina o atributo "url" no modelo para acessá-lo no arquivo HTML
        model.addAttribute("url", url);

        // Retorna o nome do arquivo HTML a ser renderizado pelo Thymeleaf
        return "redirect:/tarefa/" + nomeUrl;
    }
}