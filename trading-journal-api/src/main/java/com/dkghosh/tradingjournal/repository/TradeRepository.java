package com.dkghosh.tradingjournal.repository;

import com.dkghosh.tradingjournal.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Long> {
}