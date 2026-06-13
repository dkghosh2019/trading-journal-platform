import { Injectable } from '@angular/core';
import { Trade } from '../models/trade';

@Injectable({
  providedIn: 'root'
})
export class TradeService {

  private trades: Trade[] = [
    {
      id: 1,

      brokerName: 'Propshop Pro',
      accountId: '7407-25K-ST-EOD-DT-L',
      accountSize: '25K EOD',

      symbol: 'AAPL',
      assetType: 'STOCK',
      direction: 'LONG',

      entryTime: '2026-06-13T09:35:00',
      exitTime: '2026-06-13T09:52:00',

      entryPrice: 198.25,
      exitPrice: 199.10,
      quantity: 100,

      stopLoss: 197.80,
      targetPrice: 200.00,
      realizedPnL: 85.00,

      setup: 'Opening Range Breakout',
      result: 'WIN',
      emotion: 'DISCIPLINED',
      notes: 'Good entry. Followed trading plan and respected stop.'
    }
  ];

  constructor() { }

  getTrades(): Trade[] {
    return this.trades;
  }
}