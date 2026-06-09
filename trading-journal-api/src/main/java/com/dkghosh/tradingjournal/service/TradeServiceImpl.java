package com.dkghosh.tradingjournal.service;

import com.dkghosh.tradingjournal.dto.TradeRequestDTO;
import com.dkghosh.tradingjournal.dto.TradeResponseDTO;
import com.dkghosh.tradingjournal.entity.Trade;
import com.dkghosh.tradingjournal.mapper.TradeMapper;
import com.dkghosh.tradingjournal.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TradeServiceImpl implements TradeService {

    private final TradeRepository tradeRepository;
    private final TradeMapper tradeMapper;

    @Override
    public TradeResponseDTO createTrade(TradeRequestDTO request) {
        Trade trade = tradeMapper.toEntity(request);
        Trade savedTrade = tradeRepository.save(trade);
        return tradeMapper.toResponseDTO(savedTrade);
    }

    @Override
    public List<TradeResponseDTO> getAllTrades() {
        return tradeRepository.findAll()
                .stream()
                .map(tradeMapper::toResponseDTO)
                .toList();
    }

    @Override
    public TradeResponseDTO getTradeById(Long id) {
        Trade trade = findTradeById(id);
        return tradeMapper.toResponseDTO(trade);
    }

    @Override
    public TradeResponseDTO updateTrade(Long id, TradeRequestDTO request) {
        Trade trade = findTradeById(id);
        tradeMapper.updateEntityFromDTO(request, trade);

        Trade updatedTrade = tradeRepository.save(trade);
        return tradeMapper.toResponseDTO(updatedTrade);
    }

    @Override
    public void deleteTrade(Long id) {
        Trade trade = findTradeById(id);
        tradeRepository.delete(trade);
    }

    private Trade findTradeById(Long id) {
        return tradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trade not found with id: " + id));
    }
}