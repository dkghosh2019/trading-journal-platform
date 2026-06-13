import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { TradeService } from '../../services/trade.service';
import { Trade } from '../../models/trade';

@Component({
  selector: 'app-trade-form',
  imports: [CommonModule, FormsModule],
  templateUrl: './trade-form.html',
  styleUrl: './trade-form.css'
})
export class TradeForm {

  trade = {
    brokerName: 'Propshop Pro',
    accountId: '7407-25K-ST-EOD-DT-L',
    accountSize: '25K EOD',
    symbol: '',
    assetType: 'STOCK',
    direction: 'LONG',
    entryPrice: 0,
    exitPrice: 0,
    quantity: 0,
    emotion: 'CALM',
    setup: '',
    notes: ''
  };

  constructor(private tradeService: TradeService) {}

  saveTrade() {
    const realizedPnL =
      this.trade.direction === 'LONG'
        ? (this.trade.exitPrice - this.trade.entryPrice) * this.trade.quantity
        : (this.trade.entryPrice - this.trade.exitPrice) * this.trade.quantity;

    const newTrade: Trade = {
      id: Date.now(),
      brokerName: this.trade.brokerName,
      accountId: this.trade.accountId,
      accountSize: this.trade.accountSize,
      symbol: this.trade.symbol.toUpperCase(),
      assetType: this.trade.assetType as Trade['assetType'],
      direction: this.trade.direction as Trade['direction'],
      entryTime: new Date().toISOString(),
      exitTime: new Date().toISOString(),
      entryPrice: this.trade.entryPrice,
      exitPrice: this.trade.exitPrice,
      quantity: this.trade.quantity,
      realizedPnL,
      setup: this.trade.setup,
      result: realizedPnL > 0 ? 'WIN' : realizedPnL < 0 ? 'LOSS' : 'BREAKEVEN',
      emotion: this.trade.emotion as Trade['emotion'],
      notes: this.trade.notes
    };

    this.tradeService.addTrade(newTrade);

    this.trade = {
      brokerName: 'Propshop Pro',
      accountId: '7407-25K-ST-EOD-DT-L',
      accountSize: '25K EOD',
      symbol: '',
      assetType: 'STOCK',
      direction: 'LONG',
      entryPrice: 0,
      exitPrice: 0,
      quantity: 0,
      emotion: 'CALM',
      setup: '',
      notes: ''
    };
  }
}