package io.github.underscore11code.compsci;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main implements Runnable {
  private Set<String> words = new HashSet<>();
  private Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    new Main().run();
  }

  @Override
  public void run() {
    while (true) {
      while (true) {
        final String word = this.prompt("Enter a word, or \"done\" if you are done:",
                String::toUpperCase,
                s -> !s.equals("") && !words.contains(s));
        if (word.equalsIgnoreCase("done")) break;
        words.add(word);
      }
      final List<String> ordered = words.stream().sorted().collect(Collectors.toList());
      System.out.println("You have entered the following words: ");
      for (final String s : ordered) {
        System.out.println(s);
      }

      final Boolean again = this.prompt("Would you like to use the dictionary again? (y/n)",
              s -> s.equalsIgnoreCase("y"),
              "y",
              "n");
      if (!again) break;
    }
  }

  private String prompt(final String prompt, final Predicate<String> check) {
    while (true) {
      System.out.print(prompt);
      final String line = this.scanner.nextLine();
      if (check.test(line)) return line;
      System.out.println("Invalid input.");
    }
  }

  private String prompt(final String prompt, final String... options) {
    return this.prompt(prompt, p -> Arrays.asList(options).contains(p));
  }

  private <T> T prompt(final String prompt, final Function<String, T> map, final Predicate<String> check) {
    return map.apply(this.prompt(prompt, check));
  }

  private <T> T prompt(final String prompt, final Function<String, T> map, final String... options) {
    return map.apply(this.prompt(prompt, options));
  }
}
