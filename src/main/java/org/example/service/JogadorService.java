package org.example.service;

import java.util.List;

import org.example.dao.JogadorDao;
import org.example.dto.JogadorRequest;
import org.example.dto.JogadorResponse;
import org.example.exception.ConflitoException;
import org.example.exception.RecursoNaoEncontradoException;
import org.example.model.Jogador;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JogadorService {

    private static final Long NENHUM_ID = -1L;

    private final JogadorDao jogadorDao;

    public JogadorService(JogadorDao jogadorDao) {
        this.jogadorDao = jogadorDao;
    }

    public JogadorResponse insert(JogadorRequest req) {
        String nome = req.nome().trim();

        validarNomeUnico(nome, NENHUM_ID);

        Jogador jogador = new Jogador();

        aplicar(jogador, req, nome);

        return JogadorResponse.de(jogadorDao.insert(jogador));
    }

    public JogadorResponse update(Long id, JogadorRequest req) {
        Jogador jogador = obter(id);

        String nome = req.nome().trim();

        validarNomeUnico(nome, id);

        aplicar(jogador, req, nome);

        return JogadorResponse.de(jogadorDao.update(jogador));
    }

    public void delete(Long id) {
        jogadorDao.delete(obter(id));
    }

    @Transactional(readOnly = true)
    public JogadorResponse selectById(Long id) {
        return JogadorResponse.de(obter(id));
    }

    @Transactional(readOnly = true)
    public List<JogadorResponse> selectAll() {
        return jogadorDao.findAll()
                .stream()
                .map(JogadorResponse::de)
                .toList();
    }

    private Jogador obter(Long id) {
        Validacoes.validarId(id);

        return jogadorDao.findById(id)
                .orElseThrow(() ->
                    new RecursoNaoEncontradoException(
                        "Jogador " + id + " não encontrado"
                    )
                );
    }

    private void validarNomeUnico(String nome, Long ignorarId) {
        if (jogadorDao.existsByNome(nome, ignorarId)) {
            throw new ConflitoException(
                "Já existe um jogador com o nome '" + nome + "'"
            );
        }
    }

    private void aplicar(
            Jogador jogador,
            JogadorRequest req,
            String nome) {

        jogador.setNomeJogador(nome);
        jogador.setNivel(req.nivel());

        jogador.setCla(
            req.cla() == null || req.cla().isBlank()
                ? null
                : req.cla().trim()
        );

        jogador.setClasse(req.classe());
    }
}