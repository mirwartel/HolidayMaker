package com.OurTransportClient;

public class Room {
    private int id;
    private int room_number;
    private String size;
    private String hotel;

    public Room(int id, int room_number, String size, String hotel) {
        this.id = id;
        this.room_number = room_number;
        this.size = size;
        this.hotel = hotel;
    }
}
