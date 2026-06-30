class RoomAlreadyBookedException extends RuntimeException {}

interface RoomService<T extends Room> {
    String clean(T room);
    String reserve(T room);
    String free(T room);
}

interface LuxRoomService<T extends LuxRoom> extends RoomService<T> {
    String foodDelivery(T room);
}

class HotelRoomService<T extends Room> implements RoomService<T> {
    @Override
    public String clean(T room) { 
        return "Уборка в комнате " + room.toString(); 
    }

    @Override
    public String reserve(T room) {
        if (room.isBooked) throw new RoomAlreadyBookedException();
        room.isBooked = true;
        return "Бронирование комнаты " + room.toString(); 
    }

    @Override
    public String free(T room) {
        room.isBooked = false;
        return "Освобождение комнаты " + room.toString(); 
    }
}

class LuxHotelRoomService extends HotelRoomService<LuxRoom> implements LuxRoomService<LuxRoom> {
    @Override
    public String foodDelivery(LuxRoom room) {
        return "Доставка еды в комнату " + room.toString();
    }
}
