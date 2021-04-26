package com.victoria.wallet.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;
    @NotNull
    @Length(min=3, max= 70, message = "O nome deve ter entre 3 a 70 caracteres")
    private String name;

    @Email(message="Email inválido")
    private String email;
    @NotNull
    @Length(min=6,message = "A senha deve conter no mínimo 6 caracteres.")
    private String password;

}
