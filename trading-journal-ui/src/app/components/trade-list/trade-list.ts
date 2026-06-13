
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Trade } from '../../models/trade';
import { TradeService } from '../../services/trade.service';

@Component({
  selector: 'app-trade-list',
  imports: [CommonModule],
  templateUrl: './trade-list.html',
  styleUrl: './trade-list.css',
})
export class TradeList implements OnInit {

  trades: Trade[] = [];

  constructor(private tradeService: TradeService) {}

  ngOnInit(): void {
    this.trades = this.tradeService.getTrades();
  }
}