Assuming that:

- A task's name is unique; two or more tasks cannot have the same name.

| Classes    | Methods                         | Scenario                                                            | Outputs                                 |
|------------|---------------------------------|---------------------------------------------------------------------|-----------------------------------------|
| `TodoList` | `add(Task task)`                | Add success                                                         | true                                    |
|            |                                 | Other fail to add                                                   | false                                   |
|            | `getAllTasks()`                 | user wants to see all tasks                                         | All tasks                               |
|            | `getCompleteTasks()`            | user wants to see all completed tasks                               | All completed tasks                     |
|            | `getIncompleteTasks()`          | user wants to see all incomplete tasks                              | All incomplete tasks                    |
|            | `getTasksAlphabeticallyAsc()`   | user wants to see all tasks in alphabetically ascending order       | All tasks in alphabetically asc. order  |
|            | `getTasksAlphabeticallyDesc()`  | user wants to see all tasks in alphabetically descending order      | All tasks in alphabetically desc. order |
|            | `getTask(Task task)`            | user wants to view the given task and it exists                     | the task                                |
|            |                                 | given task by user does not exist                                   | null                                    |
|            | `removeTask(Task task)`         | user wants to remove the given task and it successfully got removed | true                                    |
|            |                                 | given task by user does not exist                                   | false                                   |
|            | `setTasksComplete(Task task)`   | given task set to "complete" and the operation was successful       | true                                    |
|            |                                 | given task does not exist/other fail                                | false                                   |
|            | `setTasksIncomplete(Task task)` | given task set to "incomplete"                                      | true                                    |
|            |                                 | given task does not exist/other fail                                | false                                   |
| `Task`     | `setComplete()`                 | this task is set completed                                          | -                                       |
|            | `setIncomplete()`               | this task is set to incomplete                                      | -                                       |
