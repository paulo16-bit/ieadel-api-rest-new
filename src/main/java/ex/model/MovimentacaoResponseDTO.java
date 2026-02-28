package ex.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record MovimentacaoResponseDTO(
    Long id,
    String descricao,
    BigDecimal valor,
    LocalDate data,
    TipoMovimentacao tipo,
    Long idUsuario,
    String nomeUsuario,
    Long idCongregacao,
    LocalDateTime dataRegistro
) {
    public static MovimentacaoResponseDTO fromMovimentacao(Movimentacao movimentacao) {
        return new MovimentacaoResponseDTO(
            movimentacao.getId(),
            movimentacao.getDescricao(),
            movimentacao.getValor(),
            movimentacao.getData(),
            movimentacao.getTipo(),
            movimentacao.getUsuario() != null ? movimentacao.getUsuario().getId() : null,
            movimentacao.getUsuario() != null ? movimentacao.getUsuario().getNome() : null,
            movimentacao.getCongregacao().getIdCongregacao(),
            movimentacao.getDataRegistro()
        );
    }
}