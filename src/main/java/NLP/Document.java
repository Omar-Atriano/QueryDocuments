/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NLP;

import SQL.DatabaseOperations;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Omar
 */
public class Document {
    //////////////////
    StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
    DatabaseOperations op = new DatabaseOperations();
    
    List<String> stopWords;// = new ArrayList<String>();
        Map<String, Integer> contadorDeElementos;// = new HashMap<String, Integer>();
        List<String> wordStems;// = new ArrayList<String>();
        List<String> wordCode;// = new ArrayList<String>();
        
    public Document(String titulo, String author, String location){
        stopWords = new ArrayList<String>();
        contadorDeElementos = new HashMap<String, Integer>();
        wordStems = new ArrayList<String>();
        wordCode = new ArrayList<String>();
            wordCode.add("JJ");    wordCode.add("JJR");   wordCode.add("JJS");
            wordCode.add("NN");    wordCode.add("NNS");   wordCode.add("NNP");
            wordCode.add("NNPS");  wordCode.add("VB");    wordCode.add("VBD");
            wordCode.add("VBG");   wordCode.add("VBN");   wordCode.add("VBP");   wordCode.add("VBZ");
            
        CoreDocument coredocument = new CoreDocument(titulo);
        stanfordCoreNLP.annotate(coredocument);
        List<CoreLabel> coreLabelList = coredocument.tokens();
        
        //Hace las listas WordStems y StopWords
        for(CoreLabel coreLabel: coreLabelList){
            System.out.println(coreLabel.originalText() +" = "+coreLabel.lemma() +" = "+coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class));
            if(wordCode.contains(coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class)))
                wordStems.add(coreLabel.lemma());
            else
                stopWords.add(coreLabel.lemma());
        }
        //Cuenta las apariciones de los terminos de wordStems
         for (String elemento : wordStems) {
            if (contadorDeElementos.containsKey(elemento)) {
                contadorDeElementos.put(elemento, contadorDeElementos.get(elemento) + 1);
            } else {
                contadorDeElementos.put(elemento, 1);
            }
        }
         
         //Insertion of the  Document into the DB
         insertDocDB(titulo, author, location);
         checkTerms();
         registerAppearances();
    }
    public void insertDocDB(String title, String author, String location){
        try{
            op.setDocument(title, author, location);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }    
    public void checkTerms(){
        List<String> dbTerms = new ArrayList<String>();
        try{
            dbTerms = op.getTerms();
        }catch(SQLException e){
            e.printStackTrace();
        }
        for(String elemento: wordStems){
            if(!dbTerms.contains(elemento)){
                try{
                    op.setTerm(elemento);
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        
    }
    public void registerAppearances(){
        int idDoc=0;
        try{
            idDoc = op.getNextId();
        }catch(SQLException e){
            e.printStackTrace();
        }
        for (Map.Entry<String, Integer> entry : contadorDeElementos.entrySet()) {
            String term = entry.getKey();
            int ap = entry.getValue();
            int idTerm=0;
            try{
                idTerm = op.getTermId(term);
            }catch(SQLException e){
                e.printStackTrace();
            }
            
            try{
                op.serAppearance(idTerm, idDoc, ap);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public List<String> getWordStems(){
        return wordStems;
    }
    public List<String> getStopWords(){
        return stopWords;
    }
    public Map<String,Integer> getContadorElementos(){
        return contadorDeElementos;
    }
    public void printStopWords(){
        System.out.println("Stopwords:      "+ stopWords.size());
        for(String stop : stopWords){
            System.out.println(stop);
        }
    }
    public void printWordStem(){
        System.out.println("Word Stem:      "+ wordStems.size());
        for(String stem : wordStems){
            System.out.println(stem);
        }
    }
    public void printAppearences(){
        System.out.println("Apariciones:");
        for (String elemento : contadorDeElementos.keySet()) {
            int contador = contadorDeElementos.get(elemento);
            System.out.println("El elemento '" + elemento + "' aparece " + contador + " veces en la lista.");
        }
    }
}
