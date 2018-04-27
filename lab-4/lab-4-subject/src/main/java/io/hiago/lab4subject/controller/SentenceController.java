package io.hiago.lab4subject.controller;

import io.hiago.lab4subject.dao.SubjectClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SentenceController {

//    @Autowired
//    private DiscoveryClient discoveryClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private SubjectClient subjectClient;

    @GetMapping("/sentence")
    public String getSentence() {
        String service = "lab-4-subject";
        List<String> words = Arrays.asList(getWord(service), getWord(service), getWord(service));
        return String.join(", ", words);
    }

    public String getWord(String service) {
//        Optional<URI> uri = Optional.ofNullable(this.discoveryClient.getInstances(service))
//                .filter(si -> !si.isEmpty())
//                .map(si -> si.get(0).getUri());

//        return (uri.isPresent()) ? (new RestTemplate()).getForObject(uri.get() + "/word", String.class) : null;

//        return restTemplate.getForObject("http://" + service + "/word", String.class);

        return subjectClient.getWord();
    }

}
