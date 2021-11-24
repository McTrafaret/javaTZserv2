package com.udalny.entity.packet;

public class Packet {

    private PacketType type;
    private String data;

    public Packet() {

    }

    public Packet(PacketType type, String data) {
        this.type = type;
        this.data = data;
    }

    public PacketType getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "PacketResult{" +
                "type=" + type +
                ", data='" + data + '\'' +
                '}';
    }
}
