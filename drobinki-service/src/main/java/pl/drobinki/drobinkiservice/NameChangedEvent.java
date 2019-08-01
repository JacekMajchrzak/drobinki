package pl.drobinki.drobinkiservice;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import pl.drobinki.drobinkiservice.common.DomainEvent;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class NameChangedEvent implements DomainEvent {
    private final String id;
    private final String name;
}
