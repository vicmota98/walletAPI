package com.victoria.wallet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "wallet_items")
@NoArgsConstructor
@AllArgsConstructor
public class WalletItem implements Serializable {

    private static final long serialVersionUID = -1923980128309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "wallet", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Wallet wallet;
    @NotNull
    private Date date;
    @NotNull
    private String type;
    @NotNull
    private String description;
    private BigDecimal value;

}
