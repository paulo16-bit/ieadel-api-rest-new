package ex.service;

import ex.model.Usuario;
import ex.model.UsuarioResponseDTO;
import ex.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioResponseDTO> buscarUsuariosPorNomeNaCongregacao(String nome) {
        Usuario usuarioLogado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long idCongregacao = usuarioLogado.getCongregacao().getIdCongregacao();

        return usuarioRepository.findByNomeContainingIgnoreCaseAndCongregacao(nome, idCongregacao)
                .stream()
                .map(UsuarioResponseDTO::fromUsuario)
                .toList();
    }
}
