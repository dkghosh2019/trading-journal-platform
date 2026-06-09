package com.dkghosh.tradingjournal.service;

import com.dkghosh.tradingjournal.dto.TradeRequestDTO;
import com.dkghosh.tradingjournal.dto.TradeResponseDTO;

import java.util.List;

public interface TradeService {

    TradeResponseDTO createTrade(TradeRequestDTO tradeRequestDTO);

    List<TradeResponseDTO> getAllTrades();

    TradeResponseDTO getTradeById(Long id);

    TradeResponseDTO updateTrade(Long id, TradeRequestDTO tradeRequestDTO);

    void deleteTrade(Long id);
}