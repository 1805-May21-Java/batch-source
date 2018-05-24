package core_java_assignment;

import java.util.ArrayList;

public class Question19 {
	ArrayList<Integer> list = new ArrayList();
	ArrayList<Integer> evenSum = new ArrayList();
	ArrayList<Integer> oddSum = new ArrayList();
	ArrayList<Integer> inefficient = new ArrayList();

	public void numbersAndStuff(int end) {
		list.clear();
		evenSum.clear();
		evenSum.add(0);
		oddSum.clear();
		oddSum.add(0);
		inefficient.clear();
		for (int i = 0; i <= end; i++) {
			list.add(i);
		}
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			if (i % 2 == 0) {
				evenSum.set(0, evenSum.get(0) + list.get(i));
			} else {
				oddSum.set(0, oddSum.get(0) + list.get(i));
			}
		}
		for (int integer : list) {
			if (!isPrime(integer)) {
				inefficient.add(integer);
			}
		}
		System.out.println(evenSum);
		System.out.println(oddSum);
		System.out.println(inefficient);
	}

	private boolean isPrime(int n) {
		if (n == 2)
			return false;
		if (n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
