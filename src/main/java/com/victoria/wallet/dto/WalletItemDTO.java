package com.victoria.wallet.dto;

import com.victoria.wallet.util.enums.TypeEnum;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class WalletItemDTO {

    private Long id;

    @NotNull(message = "Insira o id da carteira")
    private Long wallet;

    @NotNull(message = "Insira a data")
    private Date date;

    @NotNull(message = "Insira o tipo")
    @Pattern(regexp = "^(ENTRADA|SAÍDA)$", message = "Para o tipo apenas são aceitos os valores ENTRADA ou SAÍDA")
    private TypeEnum type;

    @NotNull(message = "Insira a descrição")
    @Length(min = 5, message = "A descrição deve ter no mínimo 5 caracteres")
    private String description;

    @NotNull(message = "Insira o valor")
    private BigDecimal value;
}
