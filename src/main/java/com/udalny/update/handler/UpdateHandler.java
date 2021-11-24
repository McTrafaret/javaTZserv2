package com.udalny.update.handler;

import com.udalny.entity.packet.Packet;

public interface UpdateHandler {

    boolean probe(Packet p);
    void update(Packet p);
}
