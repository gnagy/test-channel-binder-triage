package com.example.testchannelbindertriage;

import java.util.Objects;

public class CardEvent {
    private String payload;

    public CardEvent() {
    }

    public CardEvent(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardEvent cardEvent = (CardEvent) o;
        return Objects.equals(payload, cardEvent.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload);
    }

    @Override
    public String toString() {
        return "CardEvent{" +
                "payload='" + payload + '\'' +
                '}';
    }
}
