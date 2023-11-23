import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static List<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runTaskManager();
    }

    private static void runTaskManager() {
        String userInput;

        while (true) {
            System.out.println("Main Menu");
            System.out.println();
            System.out.println("1. Display to-do list");
            System.out.println("2. Add item to list");
            System.out.println("3. Remove item from list");
            System.out.println("4. Exit the program");
            System.out.println();
            System.out.print("Enter choice: ");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    listTasks();
                    break;
                case "2":
                    addTask();
                    break;
                case "3":
                    deleteTask();
                    break;
                case "4":
                    exitTaskManager();
                    break;
                default:
                    System.out.println(
                            "Invalid choice. Please enter a valid number (1-4).");
            }
        }
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            System.out.println();
        } else {
            System.out.println("Tasks:\n");
            System.out.println();
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void addTask() {
        System.out.println("Please enter the task: ");
        System.out.println();
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added: " + task);
        System.out.println();
    }

    private static void deleteTask() {
        System.out.println("Please enter the number of the task to delete: ");
        System.out.println();

        try {
            int taskNumber = Integer.parseInt(scanner.nextLine());
            if (isValidTaskNumber(taskNumber)) {
                String deletedTask = tasks.remove(taskNumber - 1);
                System.out.println("Task deleted: " + deletedTask);
                System.out.println();
            } else {
                System.out.println("Invalid task number. Please enter a valid number.");
                System.out.println();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            System.out.println();
        }
    }

    private static boolean isValidTaskNumber(int taskNumber) {
        return taskNumber >= 1 && taskNumber <= tasks.size();
    }

    private static void exitTaskManager() {
        System.out.println("Goodbye!");
        System.out.println();
        scanner.close();
        System.exit(0);
    }
}
