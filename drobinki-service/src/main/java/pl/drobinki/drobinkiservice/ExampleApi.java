package pl.drobinki.drobinkiservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleApi {

    @RequestMapping("/greeting")
    public ExampleResponse greeting() {
        return new ExampleResponse("Name");
    }

}
