package backendNLPInAI.backendNLPInAI.controller;

import backendNLPInAI.backendNLPInAI.service.NLPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nlp")
public class NLPController {

    @Autowired
    private NLPService nlpService;

    @PostMapping("/detect-sentences")
    public String[] detectSentences(@RequestBody String text) {

        return nlpService.detectSentences(text);
    }

    @PostMapping("/tokenize-text")
    public String[] tokenizeText(@RequestBody String text) {
        return nlpService.tokenizeText(text);
    }
}
