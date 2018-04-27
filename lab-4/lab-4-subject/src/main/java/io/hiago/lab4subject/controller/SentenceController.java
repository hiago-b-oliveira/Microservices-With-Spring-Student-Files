package io.hiago.lab4subject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class SentenceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/sentence")
    public String getSentence() {
        String service = "lab-4-subject";
        List<String> words = Arrays.asList(getWord(service), getWord(service), getWord(service));
        return String.join(", ", words);
    }

    public String getWord(String service) {
        Optional<URI> uri = Optional.ofNullable(this.discoveryClient.getInstances(service))
                .filter(si -> !si.isEmpty())
                .map(si -> si.get(0).getUri());

        return (uri.isPresent()) ? (new RestTemplate()).getForObject(uri.get() + "/word", String.class) : null;
    }

}
