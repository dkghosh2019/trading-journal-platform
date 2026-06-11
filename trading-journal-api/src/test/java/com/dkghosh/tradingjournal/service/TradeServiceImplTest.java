package com.dkghosh.tradingjournal.service;

import com.dkghosh.tradingjournal.dto.TradeRequestDTO;
import com.dkghosh.tradingjournal.dto.TradeResponseDTO;
import com.dkghosh.tradingjournal.entity.AssetType;
import com.dkghosh.tradingjournal.entity.Trade;
import com.dkghosh.tradingjournal.mapper.TradeMapper;
import com.dkghosh.tradingjournal.repository.TradeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TradeServiceImplTest {

    @Mock
    private TradeRepository tradeRepository;

    @Mock
    private TradeMapper tradeMapper;

    @InjectMocks
    private TradeServiceImpl tradeService;

    @Test
    void createTrade_shouldReturnCreatedTrade() {
        TradeRequestDTO request = buildRequest();
        Trade trade = buildTrade();
        Trade savedTrade = buildTrade();
        savedTrade.setId(1L);

        TradeResponseDTO response = buildResponse();

        when(tradeMapper.toEntity(request)).thenReturn(trade);
        when(tradeRepository.save(trade)).thenReturn(savedTrade);
        when(tradeMapper.toResponseDTO(savedTrade)).thenReturn(response);

        TradeResponseDTO result = tradeService.createTrade(request);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("META", result.getSymbol());

        verify(tradeMapper).toEntity(request);
        verify(tradeRepository).save(trade);
        verify(tradeMapper).toResponseDTO(savedTrade);
    }

    @Test
    void getAllTrades_shouldReturnTradeList() {
        Trade trade = buildTrade();
        trade.setId(1L);

        TradeResponseDTO response = buildResponse();

        when(tradeRepository.findAll()).thenReturn(List.of(trade));
        when(tradeMapper.toResponseDTO(trade)).thenReturn(response);

        List<TradeResponseDTO> result = tradeService.getAllTrades();

        assertEquals(1, result.size());
        assertEquals("META", result.get(0).getSymbol());

        verify(tradeRepository).findAll();
        verify(tradeMapper).toResponseDTO(trade);
    }

    @Test
    void getTradeById_shouldReturnTrade_whenTradeExists() {
        Trade trade = buildTrade();
        trade.setId(1L);

        TradeResponseDTO response = buildResponse();

        when(tradeRepository.findById(1L)).thenReturn(Optional.of(trade));
        when(tradeMapper.toResponseDTO(trade)).thenReturn(response);

        TradeResponseDTO result = tradeService.getTradeById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());

        verify(tradeRepository).findById(1L);
        verify(tradeMapper).toResponseDTO(trade);
    }

    @Test
    void updateTrade_shouldReturnUpdatedTrade() {
        TradeRequestDTO request = buildRequest();

        Trade existingTrade = buildTrade();
        existingTrade.setId(1L);

        Trade updatedTrade = buildTrade();
        updatedTrade.setId(1L);

        TradeResponseDTO response = buildResponse();

        when(tradeRepository.findById(1L)).thenReturn(Optional.of(existingTrade));
        doNothing().when(tradeMapper).updateEntityFromDTO(request, existingTrade);
        when(tradeRepository.save(existingTrade)).thenReturn(updatedTrade);
        when(tradeMapper.toResponseDTO(updatedTrade)).thenReturn(response);

        TradeResponseDTO result = tradeService.updateTrade(1L, request);

        assertNotNull(result);
        assertEquals(1L, result.getId());

        verify(tradeRepository).findById(1L);
        verify(tradeMapper).updateEntityFromDTO(request, existingTrade);
        verify(tradeRepository).save(existingTrade);
        verify(tradeMapper).toResponseDTO(updatedTrade);
    }

    @Test
    void deleteTrade_shouldDeleteTrade_whenTradeExists() {
        Trade trade = buildTrade();
        trade.setId(1L);

        when(tradeRepository.findById(1L)).thenReturn(Optional.of(trade));

        tradeService.deleteTrade(1L);

        verify(tradeRepository).findById(1L);
        verify(tradeRepository).delete(trade);
    }

    private TradeRequestDTO buildRequest() {
        return TradeRequestDTO.builder()
                .symbol("META")
                .assetType(AssetType.STOCK)
                .setup("Breakout")
                .entryTime(OffsetDateTime.parse("2026-06-10T09:45:00-04:00"))
                .exitTime(OffsetDateTime.parse("2026-06-10T10:15:00-04:00"))
                .entryPrice(new BigDecimal("742.50"))
                .stopLoss(new BigDecimal("738.00"))
                .targetPrice(new BigDecimal("750.00"))
                .exitPrice(new BigDecimal("748.25"))
                .quantity(10)
                .result("WIN")
                .emotion("CALM")
                .notes("Clean breakout trade.")
                .build();
    }

    private Trade buildTrade() {
        return Trade.builder()
                .symbol("META")
                .assetType(AssetType.STOCK)
                .setup("Breakout")
                .entryTime(OffsetDateTime.parse("2026-06-10T09:45:00-04:00"))
                .exitTime(OffsetDateTime.parse("2026-06-10T10:15:00-04:00"))
                .entryPrice(new BigDecimal("742.50"))
                .stopLoss(new BigDecimal("738.00"))
                .targetPrice(new BigDecimal("750.00"))
                .exitPrice(new BigDecimal("748.25"))
                .quantity(10)
                .result("WIN")
                .emotion("CALM")
                .notes("Clean breakout trade.")
                .build();
    }

    private TradeResponseDTO buildResponse() {
        return TradeResponseDTO.builder()
                .id(1L)
                .symbol("META")
                .assetType(AssetType.STOCK)
                .setup("Breakout")
                .entryTime(OffsetDateTime.parse("2026-06-10T09:45:00-04:00"))
                .exitTime(OffsetDateTime.parse("2026-06-10T10:15:00-04:00"))
                .entryPrice(new BigDecimal("742.50"))
                .stopLoss(new BigDecimal("738.00"))
                .targetPrice(new BigDecimal("750.00"))
                .exitPrice(new BigDecimal("748.25"))
                .quantity(10)
                .result("WIN")
                .emotion("CALM")
                .notes("Clean breakout trade.")
                .build();
    }
}