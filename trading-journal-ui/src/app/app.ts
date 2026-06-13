
import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TradeList } from './components/trade-list/trade-list';
import { TradeForm } from './components/trade-form/trade-form';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, TradeList, TradeForm],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Trading Journal');
}