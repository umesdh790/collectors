package Model;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

public class Main_1 {
    public static void main(String args[]) {
      int max = Article.readAll().stream()
              .filter(article -> article.getInceptionYear()>1900)
               .map(article -> article.getInceptionYear())
               .collect(Collectors.maxBy(Comparator.naturalOrder())).get();

        System.out.println("max = " + max);


        IntSummaryStatistics statistics = Article.readAll().stream().filter(a -> a.getInceptionYear() > 1900)
                .mapToInt(Article::getInceptionYear)
                .summaryStatistics();

        System.out.println("statistics = " + statistics);

        IntSummaryStatistics statistics2 = Article.readAll().stream()
                .filter(a -> a.getInceptionYear() > 1900)
                .collect(Collectors.summarizingInt(Article::getInceptionYear));
        System.out.println("statistics2 = " + statistics2);

        String articles = Article.readAll().stream()
                .limit(2)
                .map(Article::getTitle)
                .collect(Collectors.joining(", "));

        System.out.println("articles = " + articles);
    }
}
