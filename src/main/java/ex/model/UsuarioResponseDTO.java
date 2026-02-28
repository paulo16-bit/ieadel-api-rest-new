package ex.model;

public record UsuarioResponseDTO(Long id, String nome, String email, Perfil perfil, Long idCongregacao) {
    public static UsuarioResponseDTO fromUsuario(Usuario usuario) {
        return new UsuarioResponseDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getPerfil(),
            usuario.getCongregacao() != null ? usuario.getCongregacao().getIdCongregacao() : null
        );
    }
}