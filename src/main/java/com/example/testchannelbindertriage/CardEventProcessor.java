package com.example.testchannelbindertriage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
class CardEventProcessor implements Consumer<CardEvent> {

    @Autowired
    private StreamBridge streamBridge;
    private List<CardEvent> receivedEvents = new ArrayList();

    public void process(CardEvent cardEvent) {
        System.out.println("Sending " + cardEvent);
        streamBridge.send("cardEventProcessor-out-0", cardEvent);
    }

    @Override
    public void accept(CardEvent cardEvent) {
        System.out.println("Received " + cardEvent);
        receivedEvents.add(cardEvent);
    }
    public List<CardEvent> getReceivedEvents() {
        return receivedEvents;
    }
}
