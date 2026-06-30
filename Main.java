public class Main {
    public static void main(String[] args) {
        HotelRoomService<Room> service = new HotelRoomService<>();
        LuxHotelRoomService luxService = new LuxHotelRoomService();
        
        EconomyRoom economy = new EconomyRoom(101);
        StandartRoom standard = new StandartRoom(102);
        LuxRoom lux = new LuxRoom(103);
        UltraLuxRoom ultra = new UltraLuxRoom(104);
        
        System.out.println("=== Бронирование комнат ===");
        System.out.println(service.reserve(economy));
        System.out.println(service.reserve(standard));
        System.out.println(service.reserve(lux));
        System.out.println(service.reserve(ultra));
        
        System.out.println("\n=== Освобождение комнат ===");
        System.out.println(service.free(economy));
        System.out.println(service.free(standard));
        System.out.println(service.free(lux));
        System.out.println(service.free(ultra));
        
        System.out.println("\n=== Уборка комнат ===");
        System.out.println(service.clean(economy));
        System.out.println(service.clean(standard));
        System.out.println(service.clean(lux));
        System.out.println(service.clean(ultra));
        
        System.out.println("\n=== Люксовый сервис - работает только с люксом ===");
        System.out.println(luxService.reserve(lux));
        System.out.println(luxService.reserve(ultra));
        System.out.println(luxService.foodDelivery(lux));
        System.out.println(luxService.foodDelivery(ultra));
        
        System.out.println("\n=== Освобождение люксовых комнат ===");
        System.out.println(luxService.free(lux));
        System.out.println(luxService.free(ultra));
        
        // Попытка использовать люксовый сервис с обычными комнатами (ошибка при компиляции)
        // System.out.println(luxService.foodDelivery(economy));
        // System.out.println(luxService.foodDelivery(standard));
        // System.out.println(luxService.clean(economy));
        // System.out.println(luxService.clean(standard));

        // Попытка забронировать уже занятую комнату (RoomAlreadyBookedException)
        // System.out.println(service.reserve(economy));
        // System.out.println(service.reserve(economy));
    }
}