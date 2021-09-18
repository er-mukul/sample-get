package com.tg.tarabutget.entity;

import com.tg.tarabutget.enums.MarketingPreference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(name = "userName",unique = true)
    private String userName;

    @NotNull
    @NotEmpty
    @Column(name = "customerName")
    private String customerName;

    @NotNull
    @Column(name = "marketingPreference")
    @Enumerated(EnumType.STRING)
    private MarketingPreference marketingPreference;

}
