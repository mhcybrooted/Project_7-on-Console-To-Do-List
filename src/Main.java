import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine().trim();

            if (command.equals("a")) {
                System.out.print("Message: ");
                String message = scanner.nextLine().trim();
                System.out.print("Date: ");
                String date = scanner.nextLine().trim();
                taskManager.addTask(message, date);
            } else if (command.startsWith("v")) {
                String param = command.substring(1);
                if (param.matches("\\d+")) {
                    long id = Long.parseLong(param);
                    taskManager.viewTaskById(id);
                } else {
                    taskManager.viewTasksByDate(param);
                }
            } else if (command.startsWith("d")) {
                String param = command.substring(1);
                if (param.matches("\\d+")) {
                    long id = Long.parseLong(param);
                    taskManager.deleteTask(id);
                } else {
                    System.out.println("Invalid delete command. Use d<id>");
                }
            } else {
                System.out.println("Invalid command. Use: a, v<id>, v<date>, d<id>");
            }
        }
    }
}
