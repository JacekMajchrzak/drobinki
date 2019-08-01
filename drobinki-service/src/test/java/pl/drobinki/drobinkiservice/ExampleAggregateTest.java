package pl.drobinki.drobinkiservice;

import org.junit.Before;
import org.junit.Test;
import pl.drobinki.drobinkiservice.common.AggregateEventsAssertions;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleAggregateTest {
    private static final String OLD_NAME = "old name";
    private static final String NEW_NAME = "new name";

    private AggregateEventsAssertions aggregateEventsAssertions;

    @Before
    public void setUp() {
        aggregateEventsAssertions = new AggregateEventsAssertions();
    }

    @Test
    public void shouldChangeName() {
        // given
        final String id = UUID.randomUUID().toString();
        ExampleAggregate exampleAggregate = new ExampleAggregate(id, OLD_NAME);
        // when
        exampleAggregate.changeName(NEW_NAME);
        // then
        assertThat(exampleAggregate.hasName(NEW_NAME)).isTrue();
        aggregateEventsAssertions.containsExactly(new NameChangedEvent(id, NEW_NAME));
    }
}
