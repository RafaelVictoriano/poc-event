package br.com.poc_event;

public class EventDTO {
    private final String sourceEvent;
    private final String detailType;
    private final String payload;
    private final String eventBus;

    public EventDTO(final String sourceEvent,
                    final String detailType,
                    final String payload,
                    final String eventBus) {
        this.sourceEvent = sourceEvent;
        this.detailType = detailType;
        this.payload = payload;
        this.eventBus = eventBus;
    }

    public String getSourceEvent() {
        return sourceEvent;
    }

    public String getDetailType() {
        return detailType;
    }

    public String getPayload() {
        return payload;
    }

    public String getEventBus() {
        return eventBus;
    }
}
