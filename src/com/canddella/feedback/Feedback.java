package com.canddella.feedback;

import java.text.Annotation;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;

public class Feedback {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String text = "I love this product. It's amazing!";
        
        // Set up Stanford NLP pipeline
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, parse, sentiment");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // Create an annotation with the text
        Annotation annotation = new Annotation(text);
        pipeline.annotate(annotation);

        // Get sentiment annotation from the annotation
        CoreMap sentence = annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0);
        String sentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);

        System.out.println("Sentiment: " + sentiment);
    }
	

}

	


