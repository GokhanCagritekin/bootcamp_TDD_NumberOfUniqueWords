package Homework2;

import org.junit.platform.commons.util.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberOfUniqueWords {

    public static String[] stringToArray(String str){
        String[] words = str.split("[ .,?!:;]");
        return Arrays.stream(words).filter(x -> !StringUtils.isBlank(x)).toArray(String[]::new);
    }



    public static int calculateNumberOfUniqueWords(String[] words){
        boolean[] array = new boolean[words.length];
        ArrayList<String> nonUniques = new ArrayList<String>();
        words = Arrays.stream(words).map(s -> s.toLowerCase()).toArray(String[]::new);
        int j, i = 0;
        int count = 0;
        for (i = 0; i < words.length; i++) {
            if (!array[i] && !(nonUniques.contains(words[i]))) {
                count++;
                for (j = i + 1; j < words.length; j++) {
                    if (words[j].compareTo(words[i]) == 0){
                        if(!(nonUniques.contains(words[i]))){
                            nonUniques.add(words[i]);
                            array[j] = true;
                            count--;
                        }
                    }
                }
            }
        }
        return count;
    }
}
