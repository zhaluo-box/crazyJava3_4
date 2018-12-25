package com.zhaluobox.crazyjava.chapter06.section08;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntBinaryOperator;

public class LambdaArrays07 {
	
	public static void main(String[] args) {
		System.out.println("==========lomdba实现============");
		String[] arr1 = new String[] { "java", "fkava", "fkit", "ios", "android" };
		Arrays.parallelSort(arr1, (o1, o2) -> o1.length() - o2.length());
		System.out.println(Arrays.toString(arr1));

		System.out.println("==========匿名内部类============");
		Arrays.parallelSort(arr1, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		System.out.println(Arrays.toString(arr1));

		System.out.println("==========lomdba实现============");
		int[] arr2 = new int[] { 3, -4, 25, 16, 30, 18 };
		// left代表数组中前一个所索引处的元素，计算第一个元素时，left为1
		// right代表数组中当前索引处的元素
		Arrays.parallelPrefix(arr2, (left, right) -> left * right);
		System.out.println(Arrays.toString(arr2));

		System.out.println("==========匿名内部类============");
		Arrays.parallelPrefix(arr2, new IntBinaryOperator() {
			@Override
			public int applyAsInt(int left, int right) {
				return left * right;
			}
		});
		System.out.println(Arrays.toString(arr2));

		long[] arr3 = new long[5];
		// operand代表正在计算的元素索引
		Arrays.parallelSetAll(arr3, operand -> operand * 5);
		System.out.println(Arrays.toString(arr3));
	}
}
