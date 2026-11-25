package org.example.service;

import org.example.dao.ItemDao;
import org.example.dao.JogadorDao;
import org.example.dto.ItemRequest;
import org.example.dto.ItemResponse;
import org.example.exception.ConflitoException;
import org.example.exception.RecursoNaoEncontradoException;
import org.example.model.Item;
import org.example.model.Jogador;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemService {

    private static final Long NENHUM_ID = -1L;

    private final ItemDao itemDao;
    private final JogadorDao jogadorDao;

    public ItemService(ItemDao itemDao, JogadorDao jogadorDao) {
        this.itemDao = itemDao;
        this.jogadorDao = jogadorDao;
    }

    public ItemResponse insert(ItemRequest req) {
        Jogador jogador = obterJogador(req.jogadorId());
        String nome = req.nome().trim();
        validarNomeUnico(nome, jogador, NENHUM_ID);
        Item item = new Item();
        aplicar(item, req, jogador, nome);
        return ItemResponse.de(itemDao.insert(item));
    }

    public ItemResponse update(Long id, ItemRequest req) {
        Item item = obter(id);
        Jogador jogador = obterJogador(req.jogadorId());
        String nome = req.nome().trim();
        validarNomeUnico(nome, jogador, id);
        aplicar(item, req, jogador, nome);
        return ItemResponse.de(itemDao.update(item));
    }

    public void delete(Long id) {
        Item item = obter(id);
        item.getJogador().removerItem(item); // mantém os dois lados da associação coerentes
        itemDao.delete(item);
    }

    @Transactional(readOnly = true)
    public ItemResponse selectById(Long id) {
        return ItemResponse.de(obter(id));
    }

    @Transactional(readOnly = true)
    public List<ItemResponse> selectAll() {
        return itemDao.findAll().stream().map(ItemResponse::de).toList();
    }

    private Item obter(Long id) {
        Validacoes.validarId(id);
        return itemDao.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Item " + id + " não encontrado"));
    }

    private Jogador obterJogador(Long jogadorId) {
        Validacoes.validarId(jogadorId);
        return jogadorDao.findById(jogadorId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Jogador " + jogadorId + " não encontrado"));
    }

    private void validarNomeUnico(String nome, Jogador jogador, Long ignorarId) {
        if (itemDao.existsByNomeAndJogador(nome, jogador.getId(), ignorarId)) {
            throw new ConflitoException("O jogador " + jogador.getId()
                    + " já possui um item com o nome '" + nome + "'");
        }
    }

    private void aplicar(Item item, ItemRequest req, Jogador novoDono, String nome) {
        item.setNomeItem(nome);
        item.setRaridade(req.raridade());
        item.setQuantidade(req.quantidade());
        Jogador atual = item.getJogador();
        if (atual == null) {
            novoDono.adicionarItem(item);
        } else if (!atual.getId().equals(novoDono.getId())) {
            atual.removerItem(item);
            novoDono.adicionarItem(item);
        }
    }
}
