Assuming that:

- A task's name is unique; two or more tasks cannot have the same name.

| Classes    | Methods                                     | Scenario                                         | Outputs                                  |
|------------|---------------------------------------------|--------------------------------------------------|------------------------------------------|
| `TodoList` | `getTask(String id)`                        | task with the given id exists                    | the task with the corresponding given id |
|            |                                             | task with the given id does not exist            | null                                     |
|            | `updateTask(String id, String newTaskName)` | successfully updated task                        | true                                     |
|            |                                             | task with the given id does not exit/other error | false                                    |
