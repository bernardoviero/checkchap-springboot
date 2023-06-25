package checkchap.checkchapfullstack.controller;

import checkchap.checkchapfullstack.url.UrlRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/")
public class TarefaController {

    @GetMapping("/{nomeUrl}")
    public String exibirTarefas(@PathVariable("nomeUrl") String nomeUrl, Model model) {
        model.addAttribute("nomeUrl", nomeUrl);
        return "tarefa";
    }

    @GetMapping("/tarefa/**")
    public String redirecionarTarefa(HttpServletRequest request) {
        String path = request.getRequestURI().substring(request.getContextPath().length());
        return "redirect:" + path.replace("/tarefa", "");
    }
}
