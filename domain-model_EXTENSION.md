Assuming that:

- A task's ID is just an incrementing number. So first task will have id=1, second one will have id=2, etc.

| Classes    | Methods                                    | Scenario                                              | Outputs                                  |
|------------|--------------------------------------------|-------------------------------------------------------|------------------------------------------|
| `TodoList` | `getTaskById(int id)`                      | task with the given id exists                         | the task with the corresponding given id |
|            |                                            | task with the given id does not exist                 | null                                     |
|            | `updateTask(int id, String newTaskName)`   | successfully updated task                             | true                                     |
|            |                                            | task with the given id does not exit/other error      | false                                    |
|            | `updateTaskStatus(int id, boolean status)` | successfully updated task status                      | true                                     |
| `Task`     | `getCreated()`                             | when wants to see date and time created for this task | date and time this task was created      |

