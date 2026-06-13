export interface Order {
  account: string;
  symbol: string;
  actionType: 'Buy' | 'Sell' | 'Cover' | string;
  orderType: 'Market' | 'Limit' | string;
  tif: string;
  totalQty: number;
  qtyFilled: number;
  qtyRemaining: number;
  stopPrice: number;
  limitPrice: number;
  updateDateTime: string;
  comment?: string;
}