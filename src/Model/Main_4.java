package Model;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main_4 {
    public static void main(String[] args) {
        Set<Article> articles = Article.readAll();

        Function<Map<Integer,Long>,Map.Entry<Integer,Long>> finisher = getMaxArticleByYear();

        Collector<Article, ?, Map<Integer, Long>> groupingBy = Collectors.groupingBy(Article::getInceptionYear, Collectors.counting());

        Collector<Article, ?, Map.Entry<Integer, Long>> collectAndThen = Collectors.collectingAndThen(groupingBy, finisher);

        Map.Entry<Integer, Long> maxArticlePerYear = articles.stream().collect(collectAndThen);

        System.out.println("maxArticlePerYear = " + maxArticlePerYear);
    }

    private static <K,V extends Comparable< ? super V>> Function<Map<K, V>, Map.Entry<K, V>> getMaxArticleByYear() {
        return map -> map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();
    }
}
