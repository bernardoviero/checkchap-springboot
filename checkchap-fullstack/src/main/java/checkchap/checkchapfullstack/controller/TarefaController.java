package checkchap.checkchapfullstack.controller;

import checkchap.checkchapfullstack.item.Item;
import checkchap.checkchapfullstack.tarefa.Tarefa;
import checkchap.checkchapfullstack.tarefa.TarefaRepository;
import checkchap.checkchapfullstack.url.Url;
import checkchap.checkchapfullstack.url.UrlRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;
    @Autowired
    private UrlRepository urlRepository;

    @GetMapping("/{nome}")
    public String exibirTarefas(@PathVariable("nome") String nome, Model model, HttpSession session) {
        model.addAttribute("nome", nome);
        Url url = urlRepository.findUrlByNome(nome);
        Tarefa tarefa = tarefaRepository.findTarefaByIdUrl(url.getId());
        if (tarefa == null) {
            tarefa = criarTarefa(url.getId());
        }
        model.addAttribute("tituloTarefa", tarefa.getTitulo());
        model.addAttribute("id", tarefa.getId());
        session.setAttribute("url", url);
        return "tarefa";
    }


    public Tarefa criarTarefa(Long idUrl){
        // estancia o objeto URL para poder atribuir o relacionamento  com tarefa
        Url url = new Url();
        url.setId(idUrl);
        // cria a tarefa relacionada com essa URL
        Tarefa tarefa = new Tarefa();
        tarefa.setUrl(url);
        tarefa.setTitulo("Novo Titulo");
        tarefa.setDataModificacao(new java.util.Date());
        tarefaRepository.save(tarefa);

        return tarefa;
    }

    @PostMapping("/tarefa/{id}")
    public String atualizaTitulo(@PathVariable("id") Long id, @RequestParam("titulo") String novoTitulo, Model model) {
        Tarefa tarefa = tarefaRepository.findTarefaById(id);
        tarefa.setTitulo(novoTitulo);
        tarefa.setDataModificacao(new java.util.Date());
        tarefaRepository.save(tarefa);
        Tarefa tarefaAtualizada = tarefaRepository.findTarefaById(id);
        model.addAttribute("tituloTarefa", tarefaAtualizada.getTitulo());

        return "redirect:/tarefa/" + tarefa.getUrl().getNome();
    }

    @GetMapping("/tarefa/**")
    public String redirecionarTarefa(HttpServletRequest request) {
        String path = request.getRequestURI().substring(request.getContextPath().length());
        String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
        return "redirect:" + baseUrl + path.replace("/tarefa", "");
    }

}
