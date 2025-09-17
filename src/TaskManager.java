import java.util.*;

public class TaskManager {
    private Set<Task> tasks;
    private Map<Long, Task> taskById;
    private Map<String, List<Task>> tasksByDate;
    private long nextId;

    public TaskManager() {
        tasks = new HashSet<>();
        taskById = new HashMap<>();
        tasksByDate = new HashMap<>();
        nextId = 101;
    }

    public void addTask(String message, String date) {
        Task task = new Task(nextId++, message, date);
        tasks.add(task);
        taskById.put(task.getId(), task);
        tasksByDate.computeIfAbsent(date, k -> new ArrayList<>()).add(task);
        showAllTasks();
    }

    public void viewTaskById(long id) {
        Task task = taskById.get(id);
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    public void viewTasksByDate(String date) {
        List<Task> dateTasks = tasksByDate.get(date);
        if (dateTasks != null && !dateTasks.isEmpty()) {
            for (Task task : dateTasks) {
                System.out.println(task);
            }
        } else {
            System.out.println("No tasks found for date " + date);
        }
    }

    public void deleteTask(long id) {
        Task task = taskById.remove(id);
        if (task != null) {
            tasks.remove(task);
            List<Task> dateTasks = tasksByDate.get(task.getDate());
            if (dateTasks != null) {
                dateTasks.remove(task);
                if (dateTasks.isEmpty()) {
                    tasksByDate.remove(task.getDate());
                }
            }
            System.out.println("Task deleted successfully.");
            showAllTasks();
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    public void showAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("All tasks:");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}
