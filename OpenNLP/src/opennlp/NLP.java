package opennlp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.SimpleTokenizer;

public class NLP {

    private static InputStream inputmodel;
    private static SentenceModel model;
    private static SentenceDetectorME detector;
    private static SimpleTokenizer tokenizer;
    private static POSModel pos_model;
    private static POSTaggerME tagger;

    public static SentenceDetectorME DETECTOR() {
        try {
            //Loading sentence detector model
            inputmodel = new FileInputStream("D:\\OPEN NLP Model/en-sent.bin");
            model = new SentenceModel(inputmodel);
            detector = new SentenceDetectorME(model);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return detector;
    }

    public static SimpleTokenizer TOKENIZER() {
        //Instantiating SimpleTokenizer class 
        //In both the classes, there are no constructors available to instantiate them. 
        //Therefore, we need to create objects of these classes using the static variable INSTANCE.
        tokenizer = SimpleTokenizer.INSTANCE;
        return tokenizer;
    }

    public static POSTaggerME POSTAGER() {
        try {
            //Loading Parts of speech-maxent model
            inputmodel = new FileInputStream("D:\\OPEN NLP Model/en-pos-maxent.bin");
            pos_model = new POSModel(inputmodel);
            //Instantiating POSTaggerME class 
            tagger = new POSTaggerME(pos_model);

        } catch (IOException ex) {
            System.err.println(ex);
        }
        return tagger;
    }
}
