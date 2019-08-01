package pl.drobinki.drobinkiservice.common;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AggregateEventsAssertions {
    private List<DomainEvent> domainEvents = new ArrayList<>();

    public AggregateEventsAssertions() {
        Aggregate.clearEventsToPublish();
    }

    private void consume(DomainEvent domainEvent) {
        domainEvents.add(domainEvent);
    }

    public AggregateEventsAssertions contains(DomainEvent... domainEvent) {
        Aggregate.publish(this::consume);

        assertThat(domainEvents).contains(domainEvent);
        return this;
    }

    public AggregateEventsAssertions containsExactly(DomainEvent... domainEvent) {
        Aggregate.publish(this::consume);

        assertThat(domainEvents).containsExactly(domainEvent);
        return this;
    }

    public AggregateEventsAssertions first(DomainEvent domainEvent) {
        Aggregate.publish(this::consume);

        assertThat(domainEvents).first().isEqualTo(domainEvent);
        return this;
    }
}
