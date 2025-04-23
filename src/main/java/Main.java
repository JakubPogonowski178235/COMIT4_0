import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try {
            Service s = new Service();
            Scanner scanner = new Scanner(System.in);
            boolean isRunning = true;

            while (isRunning) {
                System.out.println("\nWybierz operację:");
                System.out.println("1 - Dodaj nowego studenta");
                System.out.println("2 - Wypisz wszystkich studentów");
                System.out.println("3 - Zakończ program");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Konsumpcja znaku nowej linii

                switch (choice) {
                    case 1:
                        System.out.println("Podaj imię i wiek oddzielając spacją:");
                        String input = scanner.nextLine();
                        String[] parts = input.split(" ");
                        String name = parts[0];
                        int age = Integer.parseInt(parts[1]);
                        s.addStudent(new Student(name, age));
                        break;
                    case 2:
                        var students = s.getStudents();
                        System.out.println("\nLista studentów:");
                        for (Student current : students) {
                            System.out.println(current.ToString());
                        }
                        break;
                    case 3:
                        System.out.println("Kończenie programu...");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Nieprawidłowy wybór, spróbuj ponownie.");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Wystąpił błąd: " + e.getMessage());
        }
    }
}
