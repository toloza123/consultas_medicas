package controlador;

import modelo.Usuario;
import servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class DashboardControlador {

    @Autowired
    private IUsuarioServicio usuarioServicio;

    @GetMapping("/dashboard")
    public String dashboard(Authentication auth, Model model) {
        if (auth != null) {
            Optional<Usuario> usuario = usuarioServicio.buscarPorCorreo(auth.getName());
            usuario.ifPresent(u -> model.addAttribute("usuarioActual", u));
        }
        return "dashboard";
    }
}