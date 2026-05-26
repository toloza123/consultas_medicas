package servicio;

import modelo.Usuario;
import java.util.List;
import java.util.Optional;

public interface IUsuarioServicio {
    void registrar(Usuario usuario);
    Optional<Usuario> buscarPorCorreo(String correo);
    boolean existeCorreo(String correo);
    List<Usuario> listarUsuarios();
}