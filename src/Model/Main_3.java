package Model;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main_3 {
    public static void main(String[] args) {
        Set<Article> articles = Article.readAll();

        Map<Author, Long> articlesPerAuther = articles.stream().flatMap(article -> article.getAuthors().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Optional<Map.Entry<Author, Long>> maxArticlePerAuther = articlesPerAuther
                .entrySet().stream()
                .collect(Collectors.maxBy(Comparator.comparing(entry -> entry.getValue())));

        System.out.println("maxArticlePerAuther = " + maxArticlePerAuther);
    }
}
