/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NLP;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.util.Properties;

/**
 *
 * @author Omar
 */
public class Pipeline {
    
    private static Properties properties;
    private static String propertiesName = "tokenize, ssplit, pos, lemma";
    private static StanfordCoreNLP stanfordCoreNLP;
    
    private Pipeline(){
        
    }
    
    static{
        properties = new Properties();
        properties.setProperty("annotators", propertiesName);
    }
    
    public static StanfordCoreNLP getPipeline(){
        if(stanfordCoreNLP == null){
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }
}
