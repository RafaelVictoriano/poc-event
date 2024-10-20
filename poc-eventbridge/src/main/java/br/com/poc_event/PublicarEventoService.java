package br.com.poc_event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.eventbridge.EventBridgeClient;
import software.amazon.awssdk.services.eventbridge.model.PutEventsRequest;
import software.amazon.awssdk.services.eventbridge.model.PutEventsRequestEntry;

@Service
public class PublicarEventoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublicarEventoService.class);
    private final EventBridgeClient eventBridgeClient;

    public PublicarEventoService(EventBridgeClient eventBridgeClient) {
        this.eventBridgeClient = eventBridgeClient;
    }


    public void eventBridge(final String sourceEvent,
                            final String detailType,
                            final String payload,
                            final String eventBus) {
        LOGGER.info("Enviando evento para event bridge");

        final var putEventsRequestEntry = PutEventsRequestEntry.builder()
                .source(sourceEvent)
                .detailType(detailType)
                .detail(payload)
                .eventBusName(eventBus)
                .build();

        final var eventsRequest = PutEventsRequest.builder()
                .entries(putEventsRequestEntry)
                .build();

        final var putEventsResponse = eventBridgeClient.putEvents(eventsRequest);

        LOGGER.info("Evento enviado com sucesso, {}", putEventsResponse);
    }
}
