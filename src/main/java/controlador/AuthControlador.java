package controlador;

import modelo.Usuario;
import servicio.IUsuarioServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthControlador {

    @Autowired
    private IUsuarioServicio usuarioServicio;

    /** Página de login */
    @GetMapping("/login")
    public String loginForm() {
        return "auth/login";
    }

    /** Formulario de registro */
    @GetMapping("/registro")
    public String registroForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "auth/registro";
    }

    /** Procesar registro */
    @PostMapping("/registro")
    public String registrar(@Valid @ModelAttribute("usuario") Usuario usuario,
                            BindingResult result,
                            RedirectAttributes attr,
                            Model model) {

        // Validaciones del formulario
        if (result.hasErrors()) {
            return "auth/registro";
        }

        // Verificar correo duplicado
        if (usuarioServicio.existeCorreo(usuario.getCorreo())) {
            model.addAttribute("errorCorreo", "Este correo ya está registrado.");
            return "auth/registro";
        }

        // Guardar con contraseña cifrada
        usuarioServicio.registrar(usuario);

        attr.addFlashAttribute("mensajeExito",
                "¡Registro exitoso! Ya puedes iniciar sesión.");
        return "redirect:/auth/login";
    }
}