package checkchap.checkchapfullstack.controller;

import checkchap.checkchapfullstack.url.Url;
import checkchap.checkchapfullstack.url.UrlRepository;
import jakarta.servlet.http.HttpSession;
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
    public String criarUrl(@RequestParam("nome") String nome, Model model, HttpSession session) {
        Url url = urlRepository.findUrlByNome(nome);
        if (url == null) {
            url = new Url();
            url.setNome(nome);
            url.setDataCriacao(new java.util.Date());
            urlRepository.save(url);
        }
        // passando atributo para acessar pelo arquivo html
        model.addAttribute("url", url);
        // Armazena o ID da URL na sessão
        session.setAttribute("urlId", url.getId());
        return "redirect:/tarefa/" + nome;
    }
}