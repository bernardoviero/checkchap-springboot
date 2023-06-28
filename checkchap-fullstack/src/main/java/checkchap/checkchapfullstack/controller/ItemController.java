package checkchap.checkchapfullstack.controller;

import checkchap.checkchapfullstack.item.Item;
import checkchap.checkchapfullstack.item.ItemRepository;
import checkchap.checkchapfullstack.tarefa.Tarefa;
import checkchap.checkchapfullstack.tarefa.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping("/criar/{idTarefa}")
    public String criarItem(@PathVariable("idTarefa") Long idTarefa,@RequestParam("nomeItem") String nomeItem) {
        Tarefa tarefa = tarefaRepository.findTarefaById(idTarefa);
        Item item = new Item();
        item.setItem(nomeItem);
        item.setTarefa(tarefa);
        item.setDataModificacao(new java.util.Date());
        System.out.println("ID DA TAREFA PARA CRIAR: "+item.getTarefa().getId());
        System.out.println("ID do item: "+item.getId());
        itemRepository.save(item);

        return "redirect:/tarefa/" + tarefa.getUrl().getNome();
    }

    @PostMapping("/alterarNome/{idTarefa}/{idItem}")
    public String alterarNome(@PathVariable("idItem") Long idItem,@PathVariable("idTarefa") Long idTarefa,@RequestParam("nomeItem") String nomeItem) {
        Item item = itemRepository.findItemById(idItem);
        item.setItem(nomeItem);
        item.setDataModificacao(new java.util.Date());
        itemRepository.save(item);

        Tarefa tarefa = tarefaRepository.findTarefaById(idTarefa);
        return "redirect:/tarefa/" + tarefa.getUrl().getNome();
    }

    @PostMapping("/alterarSituacao/{idTarefa}/{idItem}")
    public String alterarSituacao(@PathVariable("idTarefa") Long idTarefa, @PathVariable("idItem") Long idItem,@RequestParam("situacao") int situacao) {
        Item item = itemRepository.findItemById(idItem);
        item.setSituacao(situacao);
        item.setDataModificacao(new java.util.Date());
        itemRepository.save(item);

        Tarefa tarefa = tarefaRepository.findTarefaById(idTarefa);
        return "redirect:/tarefa/" + tarefa.getUrl().getNome();
    }

    @PostMapping("/excluir/{idTarefa}/{idItem}")
    public String excluiItem(@PathVariable("idTarefa") Long idTarefa, @PathVariable("idItem") Long idItem) {
        Item item = itemRepository.findItemById(idItem);
        item.setExcluido(1);
        itemRepository.save(item);

        Tarefa tarefa = tarefaRepository.findTarefaById(idTarefa);
        return "redirect:/tarefa/" + tarefa.getUrl().getNome();
    }
}
