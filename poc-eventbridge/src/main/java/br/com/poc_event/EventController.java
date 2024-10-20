package br.com.poc_event;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("poc-event")
@RestController()
public class EventController {

    private final PublicarEventoService publicarEventoService;

    public EventController(PublicarEventoService publicarEventoService) {
        this.publicarEventoService = publicarEventoService;
    }

    @PostMapping
    public String publicarEvento(@RequestBody EventDTO event) {
        this.publicarEventoService.eventBridge(event.getSourceEvent(),
                event.getDetailType(),
                event.getPayload(),
                event.getEventBus());
        return "Processamento OK";
    }
}
