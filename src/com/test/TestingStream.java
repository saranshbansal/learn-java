package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestingStream {
public static void main(String[] args) {
	List<Integer> list = new ArrayList<>();
    long howMany = Stream.of(1, 2, 3, 4)
            .map(x -> list.add(x))
            .count();
    System.out.println(list);

    System.out.println(howMany);
}
}
