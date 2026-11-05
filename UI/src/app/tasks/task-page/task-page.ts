
import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormBuilder,
  FormGroup,
  FormControl,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';
import { TaskService } from '../../services/task.service';
import { Task, TaskRequestDto } from '../../models/task.model';

@Component({
  selector: 'app-task-page',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './task-page.html',
  styleUrl: './task-page.css'
})
export class TaskPage implements OnInit {

  tasks = signal<Task[]>([]);

  taskForm!: FormGroup<{
    title: FormControl<string | null>;
    description: FormControl<string | null>;
  }>;

  saving = false;
  errorMessage = '';
  successMessage = '';

  constructor(
    private fb: FormBuilder,
    private taskService: TaskService
  ) {
    this.taskForm = this.fb.group({
      title: this.fb.control('', [
        Validators.required,
        Validators.maxLength(100)
      ]),
      description: this.fb.control('', [
        Validators.maxLength(500)
      ])
    });
  }

  ngOnInit(): void {
    this.loadTasks();
  }

  loadTasks(): void {
    this.taskService.getTasks().subscribe({
      next: (data) => {
       this.tasks.set(data);
      },
      error: (error) => {
        console.error('Unable to load tasks:', error);
        this.errorMessage = 'Unable to load tasks. Please try again.';
      }
    });
  }

  addTask(): void {

    this.successMessage = '';
    this.errorMessage = '';

    if (this.taskForm.invalid) {
      this.taskForm.markAllAsTouched();
      return;
    }

    const title = this.taskForm.value.title?.trim() || '';
    const description =
      this.taskForm.value.description?.trim() || '';

    if (!title) {
      this.errorMessage = 'Title is required.';
      return;
    }

    const request: TaskRequestDto = {
      title,
      description: description || undefined
    };

    this.saving = true;

    this.taskService.saveTask(request).subscribe({

      next: (createdTask) => {

        // Add the newly created task immediately to the UI.
        this.tasks.update(currentTasks => [
            createdTask,
            ...currentTasks
        ]);


        this.successMessage = 'Task created successfully!';

        this.taskForm.reset();

        this.saving = false;
      },

      error: (error) => {
        console.error('Unable to create task:', error);

        this.errorMessage = 'Unable to create task. Please try again.';

        this.saving = false;
      }

    });
  }
}
