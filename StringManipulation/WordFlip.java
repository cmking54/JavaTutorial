import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class WordFlip {
    public static String reverseWords(String s) {
        String[] words = s.split(" "); 
        // chop given string everytime you encounter the parameter
        
        Stream<String> row = Arrays.stream(words); 
        // enables lambdas over a collection
        
        Function<String, String> reverseWord = str -> new StringBuilder(str).reverse().toString();
        // just does the job of reversing the words

        Stream<String> row_with_words_flipped = row.map(reverseWord);
        // use the function on each word

        Collector<String, String, String> word_smith = Collectors.joining(" ");
        // object to gather the chopped string back together with the parameter as glue

        String rejoin_chopped_words = row_with_words_flipped.collect(word_smith);
        // gathers all separated words as described above

        return rejoin_chopped_words;
        // return the result
    }
    public static void main(String[] args) {
        String test_string = "Don't panic! This is just a test!";
        System.out.println(WordFlip.reverseWords(test_string));
    }
}

