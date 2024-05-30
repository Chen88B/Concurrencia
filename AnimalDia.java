import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AnimalDia {
    private final AnimalHospital hospital;

    public AnimalDia(AnimalHospital hospital) {
        this.hospital = hospital;
    }

    public void startDailyRoutine() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Tarea para alimentar a los animales
        Runnable feedAnimalsTask = () -> {
            for (Animal animal : hospital.getAnimals()) {
                System.out.println("Feeding " + animal.getName());
                try {
                    Thread.sleep(500); // Simulate time taken to feed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Tarea para realizar chequeos médicos
        Runnable checkAnimalsTask = () -> {
            for (Animal animal : hospital.getAnimals()) {
                System.out.println("Checking " + animal.getName());
                try {
                    Thread.sleep(300); // Simulate time taken for a check-up
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Tarea para imprimir los animales y sus sonidos
        Runnable printAnimalsTask = () -> {
            hospital.printAnimals();
        };

        executor.submit(feedAnimalsTask);
        executor.submit(checkAnimalsTask);
        executor.submit(printAnimalsTask);

        executor.shutdown();
    }
}