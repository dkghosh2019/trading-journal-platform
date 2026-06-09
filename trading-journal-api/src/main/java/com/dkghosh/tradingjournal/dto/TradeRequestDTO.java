package com.dkghosh.tradingjournal.dto;

import com.dkghosh.tradingjournal.entity.AssetType;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TradeRequestDTO {

    private String symbol;

    private AssetType assetType;

    private String setup;

    private OffsetDateTime entryTime;

    private OffsetDateTime exitTime;

    private BigDecimal entryPrice;

    private BigDecimal stopLoss;

    private BigDecimal targetPrice;

    private BigDecimal exitPrice;

    private Integer quantity;

    private String result;

    private String emotion;

    private String notes;
}