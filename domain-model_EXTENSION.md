Assuming that:

- A task's name is unique; two or more tasks cannot have the same name.
- A task's ID is just an incrementing number. So first task will have id=0, second one will have id=1, etc.

| Classes    | Methods                                     | Scenario                                         | Outputs                                  |
|------------|---------------------------------------------|--------------------------------------------------|------------------------------------------|
| `TodoList` | `getTaskById(int id)`                       | task with the given id exists                    | the task with the corresponding given id |
|            |                                             | task with the given id does not exist            | null                                     |
|            | `updateTask(String id, String newTaskName)` | successfully updated task                        | true                                     |
|            |                                             | task with the given id does not exit/other error | false                                    |
