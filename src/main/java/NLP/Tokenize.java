/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NLP;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.util.List;

/**
 *
 * @author Omar
 */
public class Tokenize {
    public static void main(String[] args) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
        
        String text = "Hey! This is Omar Atriano";
        
        CoreDocument coredocument = new CoreDocument(text);
        
        stanfordCoreNLP.annotate(coredocument);
        
        List<CoreLabel> coreLabelList = coredocument.tokens();
        
        for(CoreLabel coreLabel: coreLabelList){
            System.out.println(coreLabel.originalText());
        }
        
    }
}
