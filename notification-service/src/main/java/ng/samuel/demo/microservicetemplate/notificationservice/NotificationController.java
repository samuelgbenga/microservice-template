package ng.samuel.demo.microservicetemplate.notificationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private final WebClient webClient;

    @Autowired
    public NotificationController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @GetMapping("/send/{userId}")
    public Mono<String> sendNotification(@PathVariable String userId) {
        return webClient.get()
                .uri("http://USER-SERVICE/users/" + userId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, String>>() {
                })
                .map(user -> "Notification sent to " + user.get("name") + " (" + user.get("email") + ")")
                .onErrorResume(e -> Mono.just("Failed to send notification: " + e.getMessage()));
    }

}
