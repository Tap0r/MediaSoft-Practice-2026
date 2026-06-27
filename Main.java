import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        array();
        collections();
        equals_hashcode();
        stream_api();
    }


    private static void array() {
        System.out.println("========== 1: Массивы ==========");
        Random random = new Random();
        int[] years = new int[50];
        for (int i = 0; i < years.length; i++)
            years[i] = 2000 + random.nextInt(26);

        System.out.println("Автомобили, выпущенные после 2015 года:");
        int currentYear = Year.now().getValue();
        int sumAge = 0;
        for (int y : years) {
            sumAge += currentYear - y;
            if (y > 2015)
                System.out.print(y + " ");
        }

        System.out.println("");
        System.out.printf("Средний возраст автомобилей: %.1f лет%n%n", (double) sumAge / years.length);
    }


    private static void collections() {
        System.out.println("========== 2: Коллекции ==========");
        List<String> models = new ArrayList<>(Arrays.asList(
                "Toyota Camry", "BMW X5", "Tesla Model S", "Audi A4", "Tesla Model 3", "BMW X5", 
                "Tesla Cybertruck", "Lada Kalina", "Ford Focus", "Audi A4", "Toyota Camry"));

        List<String> processed = models.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        
        System.out.println("Удаление дубликатов и обратная сортировка:");
        processed.forEach(System.out::println);

        Set<String> modelSet = new LinkedHashSet<>(processed);
        System.out.println("\nСодержимое Set: " + modelSet);

        processed = processed.stream()
                .map(m -> m.contains("Tesla") ? "ELECTRO_CAR" : m)
                .collect(Collectors.toList());

        System.out.println("Замена Tesla на ELECTRO_CAR:");
        processed.forEach(System.out::println);
        System.out.println();
    }


    private static void equals_hashcode() {
        System.out.println("========== 3: Сравнение автомобилей ==========");
        Set<Car> cars = new HashSet<>();
        cars.add(new Car("VIN001", "Civic", "Honda", 2018, 45000, 18000));
        cars.add(new Car("VIN002", "Model S", "Tesla", 2021, 12000, 80000));
        cars.add(new Car("VIN001", "Civic", "Honda", 2018, 46000, 18500));
        cars.add(new Car("VIN003", "X5", "BMW", 2015, 90000, 35000));

        System.out.println("Размер HashSet: " + cars.size());
        cars.forEach(System.out::println);

        List<Car> sortedCars = new ArrayList<>(cars);
        Collections.sort(sortedCars);
        System.out.println("\nОтсортированные по году выпуска:");
        sortedCars.forEach(System.out::println);
        System.out.println();
    }


    private static void stream_api() {
        System.out.println("========== 4: Stream API ==========");
        List<Car> fleet = Arrays.asList(
                new Car("VIN100", "Civic",      "Honda",    2018, 45000,    18000),
                new Car("VIN101", "X5",         "BMW",      2021, 12000,    80000),
                new Car("VIN102", "Model 3",    "Tesla",    2020, 30000,    55000),
                new Car("VIN103", "A4",         "Audi",     2019, 60000,    32000),
                new Car("VIN104", "Camry",      "Toyota",   2022, 5000,     28000),
                new Car("VIN105", "Focus",      "Ford",     2017, 95000,    12000),
                new Car("VIN106", "C-Class",    "Mercedes", 2020, 48000,    52000),
                new Car("VIN107", "X5",         "BMW",      2023, 8000,     95000));

        System.out.println("Топ-3 самых дорогих машин с пробегом < 50 000 км:");
        fleet.stream()
                .filter(c -> c.getMileage() < 50000)
                .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
                .limit(3)
                .forEach(System.out::println);

        double avgMileage = fleet.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0.0);
        System.out.printf("%nСредний пробег всех автомобилей: %.0f км%n", avgMileage);

        Map<String, List<Car>> byManufacturer = fleet.stream().collect(Collectors.groupingBy(Car::getManufacturer));
        System.out.println("\nАвтомобили, сгруппированные по производителю:");
        byManufacturer.forEach((man, carsList) -> { System.out.println(man + ": " + carsList); });
    }
}
