package backendNLPInAI.backendNLPInAI.service;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Objects;

@Service
public class NLPService {

    private SentenceModel sentenceModel;
    private TokenizerModel tokenizerModel;

    public NLPService() {
        try (InputStream sentenceModelStream = getClass().getResourceAsStream("/models/en-sent.bin");
             InputStream tokenizerModelStream = getClass().getResourceAsStream("/models/en-token.bin")) {

            sentenceModel = new SentenceModel(sentenceModelStream);
            tokenizerModel = new TokenizerModel(tokenizerModelStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] detectSentences(String text) {
        SentenceDetectorME sentenceDetector = new SentenceDetectorME(sentenceModel);
        return sentenceDetector.sentDetect(text);
    }

    public String[] tokenizeText(String text) {
        TokenizerME tokenizer = new TokenizerME(tokenizerModel);
        return tokenizer.tokenize(text);
    }


}
