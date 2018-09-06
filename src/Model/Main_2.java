package Model;


import java.util.Map;
import java.util.stream.Collectors;

public class Main_2 {
    public static void main(String[] args) {

        // count number of articles per year

        Map<Integer, Long> collect = Article.readAll().stream()
                .collect(Collectors.groupingBy(Article::getInceptionYear, Collectors.counting()));

        System.out.println("collect = " + collect);
    }
}