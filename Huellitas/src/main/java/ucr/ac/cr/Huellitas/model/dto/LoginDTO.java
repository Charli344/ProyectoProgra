package ucr.ac.cr.Huellitas.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginDTO {
    @Email(message = "Correo incorrecto")
    @NotBlank(message = "El correo no puede quedar en blanco")
    private String email;
    @NotBlank(message = "La contraseña no puede quedar en blanco")
    private String password;

    public LoginDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
