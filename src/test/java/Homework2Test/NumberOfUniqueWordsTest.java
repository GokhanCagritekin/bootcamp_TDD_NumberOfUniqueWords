package Homework2Test;


import Homework2.NumberOfUniqueWords;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class NumberOfUniqueWordsTest {
        @Test
        public void it_should_return_array_from_string(){
                String[] words = NumberOfUniqueWords.stringToArray("This is a test");
                Assert.assertArrayEquals(words,new String[]{"This","is","a","test"});
        }

        @Test
        public void it_should_ignore_extra_space_whenConvertingStringToArray(){
                String[] words = NumberOfUniqueWords.stringToArray("This is       a              test");
                Assert.assertArrayEquals(words,new String[]{"This","is","a","test"});
        }

        @Test
        public void stringToArray_should_ignore_commaDotAndOtherPunctuations(){
                String[] words = NumberOfUniqueWords.stringToArray("It should ignore comma,comma and dot.Right?");
                Assert.assertArrayEquals(words,new String[]{"It","should","ignore","comma","comma","and","dot","Right"});
        }

        @Test
        public void it_should_return_numberOfUniqueWordsCount(){
                int count = NumberOfUniqueWords.calculateNumberOfUniqueWords(new String[]{"This","is","a","test","test"});
                Assert.assertEquals(3,count);
        }

        @Test
        public void it_should_return_numberOfUniqueWordsCount_withMoreThanTwoRepetition(){
                int count = NumberOfUniqueWords.calculateNumberOfUniqueWords(new String[]{"This","is","is","a","a","a","test"});
                Assert.assertEquals(2,count);
        }

        @Test
        public void numberOfUniqueWordsCount_should_caseInsensitive(){
                int count = NumberOfUniqueWords.calculateNumberOfUniqueWords(new String[]{"This","is","a","test","ThiS","Is","A"});
                Assert.assertEquals(1,count);
        }

}
