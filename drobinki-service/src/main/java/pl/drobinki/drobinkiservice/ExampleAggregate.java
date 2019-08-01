package pl.drobinki.drobinkiservice;

import lombok.AllArgsConstructor;
import pl.drobinki.drobinkiservice.common.Aggregate;

@AllArgsConstructor
public class ExampleAggregate extends Aggregate {
    private String id;
    private String name;

    public void changeName(String newName) {
        this.name = newName;
        apply(new NameChangedEvent(id, newName));
    }

    public boolean hasName(String newName) {
        return this.name.equals(newName);
    }
}
