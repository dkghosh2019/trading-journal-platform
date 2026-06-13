export type AssetType = 'STOCK' | 'FUTURES' | 'OPTIONS' | 'FOREX' | 'CRYPTO';
export type TradeDirection = 'LONG' | 'SHORT';
export type TradeResult = 'WIN' | 'LOSS' | 'BREAKEVEN';
export type TradeEmotion = 'CALM' | 'FEARFUL' | 'GREEDY' | 'FOMO' | 'REVENGE' | 'DISCIPLINED' | 'IMPULSIVE';

export interface Trade {
  id: number;

  brokerName: string;      // Propshop Pro, Apex, Webull, Schwab
  accountId: string;       // 7407-25K-ST-EOD-DT-L
  accountSize?: string;    // 25K EOD, 50K PA, Cash, IRA

  symbol: string;
  assetType: AssetType;
  direction: TradeDirection;

  entryTime: string;
  exitTime?: string;

  entryPrice: number;
  exitPrice?: number;
  quantity: number;

  stopLoss?: number;
  targetPrice?: number;
  realizedPnL?: number;

  setup: string;
  result: TradeResult;
  emotion: TradeEmotion;
  notes: string;
}