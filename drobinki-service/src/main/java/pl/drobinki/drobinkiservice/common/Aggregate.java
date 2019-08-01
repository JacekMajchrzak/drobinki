package pl.drobinki.drobinkiservice.common;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class Aggregate {

    private static ThreadLocal<List<DomainEvent>> eventsToPublish = new ThreadLocal<>();

    protected static void apply(DomainEvent domainEvent) {
        List<DomainEvent> events = eventsToPublish.get();

        if (events == null) {
            events = new ArrayList<>();
            eventsToPublish.set(events);
        }
        events.add(domainEvent);
    }

    public static void clearEventsToPublish() {
        eventsToPublish.remove();
    }


    public static void publish(Consumer<DomainEvent> consumer){

        List<DomainEvent> events = eventsToPublish.get();
        eventsToPublish.remove();

        if (events == null) return;

        events.forEach(event -> {
            try {
                consumer.accept(event);
                    log.info("Event published: {}", event);
            } catch (Exception exp) {
                      log.error("Unable to publish event: {}", event);
                throw exp;
            }
        });
    }
}
