package com.epam.task1.main;

import java.math.BigInteger;

import com.epam.task1.list.LinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.addAfter(0, "asadad");
		list.addFirst("Hi pidivizion");
		System.out.println(list.contains("asadad"));
		System.out.println(list.get(1));
		System.out.println(list.indexOf("asadad"));
		list.addFirst("sdfsdfs");
		System.out.println(list.indexOf("asadad"));
		list.addLast("aaaaddddddd");
		list.set(2, "new ha");
		System.out.println(list.get(2));
		list.remove(2);
		System.out.println(list.get(2));
		list.remove("asadad");
		System.out.println(list.contains("asadad"));
		
		LinkedList<BigInteger> bigIntList = new LinkedList<>();
		bigIntList.addAfter(0, BigInteger.ONE);
		bigIntList.addLast(BigInteger.TEN);
		System.out.println("1 + 10 = " + bigIntList.get(0).add(bigIntList.get(1)));
	}
}
