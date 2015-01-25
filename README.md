Few Small Programmes
===================================
Repository contains few small utility fun-programs.

#### Some of the Projects ####

- [Closures in Java](java-closures)

> There are still few developers who have to work with pre-Java 8 environments, and have to write iterative code for element search. And, this only includes who cannot use existing open source libraries for such functionality. This module contains few example where Java way of creating Closures can help solve the issues.

```
Func<Integer, Boolean> greaterThanTen = NumericExpression.greaterThan(refValue);
List<Integer> retrievedValues = matchAll(list, greaterThanTen, 6);

Func<String, Boolean> like = Expression.fuzzyPattern("\w{6,}$");
List<String> retrievedValue = matchAll(stringList, like, likeString);
```
