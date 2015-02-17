Few Small Programmes
===================================
Repository contains few small utility fun-programs.

#### Some of the Projects ####

- [Closures in Java](java-closures)

> There are still few developers who have to work with pre-Java 7 environments, and have to write iterative code for element search. And, this only includes who cannot use existing open source libraries for such functionality. This module contains few example where Java way of creating Closures can help solve the issues.

* Number based expression can be used as specified in below example
```java
Func<Integer, Boolean> greaterThanTen = Expression.greaterThan(refValue);
List<Integer> retrievedValues = Expression.matchAll(list, greaterThanTen, 6);
```

* Similar to above example certain String Operations can be applied using ```fuzzyPattern``` or ```fuzzyLike``` methods.
```java
Func<String, Boolean> like = Expression.fuzzyPattern("\w{6,}$");
List<String> retrievedValue = Expression.matchAll(stringList, like, likeString);
```

* In certain cases, if user prefers to provide method name, then overridden method can be used as per below.
```java
Func<Person, Boolean> criteria = Expression.contains("getType", JobType.ENGINEER);
List<Person> singlePersons = Expression.matchAll(persons, criteria);
```
