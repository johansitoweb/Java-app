import java.util.ArrayList;  
import java.util.Scanner;  

public class TaskManager {  
    private ArrayList<String> tasks;  
    private Scanner scanner;  

    public TaskManager() {  
        tasks = new ArrayList<>();  
        scanner = new Scanner(System.in);  
    }  

    public void showMenu() {  
        System.out.println("=== Gestor de Tareas ===");  
        System.out.println("1. Agregar tarea");  
        System.out.println("2. Mostrar tareas");  
        System.out.println("3. Eliminar tarea");  
        System.out.println("4. Salir");  
        System.out.print("Selecciona una opción: ");  
    }  

    public void addTask() {  
        System.out.print("Ingresa la tarea: ");  
        String task = scanner.nextLine();  
        tasks.add(task);  
        System.out.println("Tarea agregada: " + task);  
    }  

    public void showTasks() {  
        if (tasks.isEmpty()) {  
            System.out.println("No hay tareas en la lista.");  
        } else {  
            System.out.println("=== Lista de Tareas ===");  
            for (int i = 0; i < tasks.size(); i++) {  
                System.out.println((i + 1) + ". " + tasks.get(i));  
            }  
        }  
    }  

    public void removeTask() {  
        showTasks();  
        System.out.print("Ingresa el número de la tarea a eliminar: ");  
        int taskNumber = scanner.nextInt();  
        scanner.nextLine(); // Consumiendo el salto de línea  
        if (taskNumber > 0 && taskNumber <= tasks.size()) {  
            String removedTask = tasks.remove(taskNumber - 1);  
            System.out.println("Tarea eliminada: " + removedTask);  
        } else {  
            System.out.println("Número de tarea inválido.");  
        }  
    }  

    public void start() {  
        boolean running = true;  

        while (running) {  
            showMenu();  
            int option = scanner.nextInt();  
            scanner.nextLine(); // Consumiendo el salto de línea  

            switch (option) {  
                case 1:  
                    addTask();  
                    break;  
                case 2:  
                    showTasks();  
                    break;  
                case 3:  
                    removeTask();  
                    break;  
                case 4:  
                    running = false;  
                    System.out.println("¡Hasta luego!");  
                    break;  
                default:  
                    System.out.println("Opción inválida. Intenta de nuevo.");  
                    break;  
            }  
        }  

        scanner.close();  
    }  

    public static void main(String[] args) {  
        TaskManager taskManager = new TaskManager();  
        taskManager.start();  
    }  
}