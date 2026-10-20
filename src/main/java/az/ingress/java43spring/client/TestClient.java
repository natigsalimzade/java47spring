package az.ingress.java43spring.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "java158-test-service", url = "${client.java158.url}")
public interface TestClient {

    @GetMapping("/test")
    String test(@RequestParam("name") String name);

    @PostMapping(value = "/test", consumes = MediaType.TEXT_PLAIN_VALUE)
    String echo();

}
