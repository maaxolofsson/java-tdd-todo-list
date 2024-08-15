Assuming that:

- A task's name is unique; two or more tasks cannot have the same name.

| Classes    | Methods                         | Scenario                                                            | Outputs                                 |
|------------|---------------------------------|---------------------------------------------------------------------|-----------------------------------------|
| `TodoList` | `add(Task task)`                | Add success                                                         | SUCCESS                                 |
|            |                                 | Task already exists                                                 | TASK_EXISTS                             |
|            |                                 | Other fail to add                                                   | FAIL                                    |
|            | `getAllTasks()`                 | user wants to see all tasks                                         | All tasks                               |
|            | `getCompleteTasks()`            | user wants to see all completed tasks                               | All completed tasks                     |
|            | `getIncompleteTasks()`          | user wants to see all incomplete tasks                              | All incomplete tasks                    |
|            | `getTasksAlphabeticallyAsc()`   | user wants to see all tasks in alphabetically ascending order       | All tasks in alphabetically asc. order  |
|            | `getTasksAlphabeticallyDesc()`  | user wants to see all tasks in alphabetically descending order      | All tasks in alphabetically desc. order |
|            | `getTask(Task task)`            | user wants to view the given task and it exists                     | SUCCESS                                 |
|            |                                 | given task by user does not exist                                   | FAIL                                    |
|            | `removeTask(Task task)`         | user wants to remove the given task and it successfully got removed | SUCCESS                                 |
|            |                                 | given task by user does not exist                                   | FAIL                                    |
|            | `setTasksComplete(Task task)`   | given task set to "complete"                                        | SUCCESS                                 |
|            |                                 | given task does not exist/other fail                                | FAIL                                    |
|            | `setTasksIncomplete(Task task)` | given task set to "incomplete"                                      | SUCCESS                                 |
|            |                                 | given task does not exist/other fail                                | FAIL                                    |
| `Task`     | `setComplete()`                 | this task is set completed                                          | -                                       |
|            | `setIncomplete()`               | this task is set to incomplete                                      | -                                       |
