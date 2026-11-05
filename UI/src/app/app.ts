import { Component } from '@angular/core';
import { TaskPage } from './tasks/task-page/task-page';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [TaskPage],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {}