package az.ingress.java43spring.controller;

import az.ingress.java43spring.client.TestClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/feign/test")
public class FeignTestController {

    TestClient testClient;

    @GetMapping
    public String test(@RequestParam(defaultValue = "World") String name){
        return testClient.test(name);
    }

    @PostMapping
    public String echo(@RequestBody String body){
        return testClient.echo(body);
    }
}
