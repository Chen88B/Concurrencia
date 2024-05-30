public class Main {
    public static void main(String[] args) {
        AnimalHospital hospital = new AnimalHospital();
        hospital.addAnimal(new Cat("Whiskers"));
        hospital.addAnimal(new Dog("Rover"));

        AnimalDia animalDia = new AnimalDia(hospital);
        animalDia.startDailyRoutine();
    }
}
