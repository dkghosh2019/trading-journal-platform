package com.dkghosh.tradingjournal.controller;

import com.dkghosh.tradingjournal.dto.TradeRequestDTO;
import com.dkghosh.tradingjournal.dto.TradeResponseDTO;
import com.dkghosh.tradingjournal.service.TradeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trades")
@RequiredArgsConstructor
public class TradeController {
    private final TradeService tradeService;

    @PostMapping
    public ResponseEntity<TradeResponseDTO> createTrade(
            @Valid @RequestBody TradeRequestDTO tradeRequestDTO
    ){
        TradeResponseDTO createdTrade= tradeService.createTrade(tradeRequestDTO);
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdTrade);

    }

    @GetMapping
    public ResponseEntity<List<TradeResponseDTO>> getAllTrades(){
        return ResponseEntity.ok(tradeService.getAllTrades());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<TradeResponseDTO> getTradeById(@PathVariable Long id){
        return ResponseEntity.ok(tradeService.getTradeById(id));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<TradeResponseDTO> updateTrade
            (
                    @PathVariable Long id,
                    @Valid @RequestBody TradeRequestDTO tradeRequestDTO
            ){
        return ResponseEntity.ok(tradeService.updateTrade(id, tradeRequestDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteTrade(@PathVariable Long id){
         tradeService.deleteTrade(id);
    }

}
