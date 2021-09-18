package com.tg.tarabutget.dto;

import com.tg.tarabutget.enums.MarketingPreference;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String userName;
    private String customerName;
    private MarketingPreference marketingPreference;
}
