package com.dkghosh.tradingjournal.controller;

import com.dkghosh.tradingjournal.dto.TradeRequestDTO;
import com.dkghosh.tradingjournal.dto.TradeResponseDTO;
import com.dkghosh.tradingjournal.service.TradeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trades")
@RequiredArgsConstructor
@Tag(
        name = "Trades",
        description = "Operations for creating, updating, retrieving, and deleting trades"
)
public class TradeController {

    private final TradeService tradeService;

    @Operation(
            summary = "Create a trade",
            description = "Creates a new trade journal entry"
    )
    @PostMapping
    public ResponseEntity<TradeResponseDTO> createTrade(
            @Valid @RequestBody TradeRequestDTO tradeRequestDTO
    ) {

        TradeResponseDTO createdTrade =
                tradeService.createTrade(tradeRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdTrade);
    }

    @Operation(
            summary = "Get all trades",
            description = "Returns all trade journal entries"
    )
    @GetMapping
    public ResponseEntity<List<TradeResponseDTO>> getAllTrades() {
        return ResponseEntity.ok(tradeService.getAllTrades());
    }

    @Operation(
            summary = "Get trade by ID",
            description = "Returns a specific trade journal entry"
    )
    @GetMapping("/{id}")
    public ResponseEntity<TradeResponseDTO> getTradeById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                tradeService.getTradeById(id)
        );
    }

    @Operation(
            summary = "Update trade",
            description = "Updates an existing trade journal entry"
    )
    @PutMapping("/{id}")
    public ResponseEntity<TradeResponseDTO> updateTrade(
            @PathVariable Long id,
            @Valid @RequestBody TradeRequestDTO tradeRequestDTO
    ) {
        return ResponseEntity.ok(
                tradeService.updateTrade(id, tradeRequestDTO)
        );
    }

    @Operation(
            summary = "Delete trade",
            description = "Deletes a trade journal entry"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrade(@PathVariable Long id) {
        tradeService.deleteTrade(id);
    }
}