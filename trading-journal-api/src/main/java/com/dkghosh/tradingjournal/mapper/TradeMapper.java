package com.dkghosh.tradingjournal.mapper;

import com.dkghosh.tradingjournal.dto.TradeRequestDTO;
import com.dkghosh.tradingjournal.dto.TradeResponseDTO;
import com.dkghosh.tradingjournal.entity.Trade;
import org.springframework.stereotype.Component;

@Component
public class TradeMapper {

    public Trade toEntity(TradeRequestDTO request) {
        return Trade.builder()
                .symbol(request.getSymbol())
                .assetType(request.getAssetType())
                .setup(request.getSetup())
                .entryTime(request.getEntryTime())
                .exitTime(request.getExitTime())
                .entryPrice(request.getEntryPrice())
                .stopLoss(request.getStopLoss())
                .targetPrice(request.getTargetPrice())
                .exitPrice(request.getExitPrice())
                .quantity(request.getQuantity())
                .result(request.getResult())
                .emotion(request.getEmotion())
                .notes(request.getNotes())
                .build();
    }

    public TradeResponseDTO toResponseDTO(Trade trade) {
        return TradeResponseDTO.builder()
                .id(trade.getId())
                .symbol(trade.getSymbol())
                .assetType(trade.getAssetType())
                .setup(trade.getSetup())
                .entryTime(trade.getEntryTime())
                .exitTime(trade.getExitTime())
                .entryPrice(trade.getEntryPrice())
                .stopLoss(trade.getStopLoss())
                .targetPrice(trade.getTargetPrice())
                .exitPrice(trade.getExitPrice())
                .quantity(trade.getQuantity())
                .result(trade.getResult())
                .emotion(trade.getEmotion())
                .notes(trade.getNotes())
                .createdAt(trade.getCreatedAt())
                .updatedAt(trade.getUpdatedAt())
                .build();
    }

    public void updateEntityFromDTO(TradeRequestDTO request, Trade trade) {
        trade.setSymbol(request.getSymbol());
        trade.setAssetType(request.getAssetType());
        trade.setSetup(request.getSetup());
        trade.setEntryTime(request.getEntryTime());
        trade.setExitTime(request.getExitTime());
        trade.setEntryPrice(request.getEntryPrice());
        trade.setStopLoss(request.getStopLoss());
        trade.setTargetPrice(request.getTargetPrice());
        trade.setExitPrice(request.getExitPrice());
        trade.setQuantity(request.getQuantity());
        trade.setResult(request.getResult());
        trade.setEmotion(request.getEmotion());
        trade.setNotes(request.getNotes());
    }
}