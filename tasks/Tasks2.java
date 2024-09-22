package tasks;

import java.util.Arrays;
import java.util.Collections;

public class Tasks2 {
	public static void main(String[] args) {
		System.out.println(".-=TASK 2.1=-.");
		System.out.println(duplicateChars("Barack", "Obama"));
		System.out.println(".-=TASK 2.2=-.");
		int[] task2input = {3,12,7,81,52};
		System.out.println(divisibleByThree(task2input));
		System.out.println(".-=TASK 2.3=-.");
		System.out.println(getInitials("simonov sergei evgenievich"));
		System.out.println(getInitials("kozhevnikova tatiana vitalevna"));
		System.out.println(".-=TASK 2.4=-.");
		double[] task4input = {3.5, 7.0, 1.5, 9.0, 5.5};
		double[] task4inputNull = {10.0, 10.0, 10.0, 10.0};
		String task4output = Arrays.toString(normalizinator(task4input));
		System.out.println(task4output);
		task4output = Arrays.toString(normalizinator(task4inputNull));
		System.out.println(task4output);
		System.out.println(".-=TASK 2.5=-.");
		double[] task5input = {1.6, 0, 212.3, 34.8, 0, 27.5};
		String task5output = Arrays.toString(compressinator(task5input));
		System.out.println(task5output);
		System.out.println(".-=TASK 2.6=-.");
		System.out.println(camelToSnake("helloWorld"));
		System.out.println(".-=TASK 2.7=-.");
		int[] task7input = {3,5,8,1,2,4};
		System.out.println(secondBiggest(task7input));
		System.out.println(".-=TASK 2.8=-.");
		System.out.println(localReverse("baobab",'b'));
		System.out.println(localReverse("Hello, I’m under the water, please help me",'e'));
		System.out.println(".-=TASK 2.9=-.");
		System.out.print(equalCount(8,1,8));
		System.out.print(";");
		System.out.print(equalCount(5,5,5));
		System.out.print(";");
		System.out.print(equalCount(4,9,6));
		System.out.println(";");
		System.out.println(".-=TASK 2.10=-.");
		System.out.println(anagramDetectinator("LISTEN","silent"));
		System.out.println(anagramDetectinator("Eleven plus two?","Twelve plus one!"));
		System.out.println(anagramDetectinator("hello","world"));
		
	}
	
	public static String duplicateChars(String 	s1, String s2 ) {
		String filter ="[" + s2.toLowerCase() + "]";
		return s1.toLowerCase().replaceAll(filter, "");
	}
	public static int divisibleByThree(int[] a) {
		int found = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 3 == 0) found++;
		}
		return found;
	}
	public static String getInitials(String fullName) {
		fullName = fullName.toLowerCase();
		String[] parts = fullName.split("[ ]");
		parts[1]=parts[1].substring(0, 1).toUpperCase() + ".";
		parts[2]=parts[2].substring(0, 1).toUpperCase() + ".";
		parts[0]=parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1);
		return parts[1] + parts[2] + parts[0];
	}
	public static double[] normalizinator(double[] a) {
		//System.out.println(Arrays.toString(a));
		double[] boundaryTest = Arrays.copyOf(a,a.length);
		
		Arrays.sort(boundaryTest);
		double minNum = boundaryTest[0];
		double maxNum = boundaryTest[boundaryTest.length-1] - minNum;
		
		for (int i = 0; i < a.length; i++) {
			a[i] -= minNum;
		}
		
		if (maxNum == 0.0) {
			Arrays.fill(a, 0.0);
		} else {
			for (int i = 0; i < a.length; i++) {
				a[i] /= maxNum;
			}
		}
		return a;
	}
	
	public static int[] compressinator(double[] in) {
		int zeroCnt = 0;
		
		for (int i = 0; i < in.length; i++) {
			in[i] = (int) in[i];
			if (in[i] == 0.0) zeroCnt++;
		}
					
		Arrays.sort(in);
		int[] out = new int[in.length - zeroCnt];
		for (int i = zeroCnt; i < in.length; i++)
			out[i - zeroCnt] = (int) in[i];
		return out;
	}
	
	public static String camelToSnake(String in) {
			String filter = "\\p{Lu}";
			String out = "";
			for (int i = 0; i < in.length(); i++) {
				String iter = in.substring(i, i+1);
				if (iter.matches(filter))
					iter = "_" + iter.toLowerCase();
				out += iter;
			}
			return out;
	}
	
	public static int secondBiggest(int[] in) {
		int[] out = Arrays.copyOf(in, in.length);
		Arrays.sort(out);
		return out[out.length - 2];
	}
	
	public static String reverse(String s) {
		char[] _s = s.toCharArray();
		for (int i = 0; i < _s.length/2; i++) {
			char temp = _s[i];
			_s[i] = _s[_s.length - i - 1];
			_s[_s.length - i - 1] = temp;
		}
		
		return String.valueOf(_s);
	}
	
	public static String localReverse(String in, char f) {
		StringBuffer _inB = new StringBuffer(in);
		boolean flagOpened = false;
		int anchor = 0;
		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) != f)
				continue;
			flagOpened = !flagOpened;
			if (flagOpened) anchor = i+1;
			else _inB.replace(anchor, i, reverse(in.substring(anchor, i)));
		}
		return _inB.toString();
	}
	
	public static int equalCount(int a, int b, int c) {
		int out = 0;
		if ((a == b) || (b == c) || (c == a)) out = 2;
		if ((a == b) && (b == c) && (c == a)) out = 3;
		return out;
	}
	public static boolean anagramDetectinator(String in1, String in2) {
		String filter = "[^a-z]";
		char[] ch1 = in1.toLowerCase().replaceAll(filter, "").toCharArray();
		Arrays.sort(ch1);
		char[] ch2 = in2.toLowerCase().replaceAll(filter, "").toCharArray();
		Arrays.sort(ch2);	
		return Arrays.equals(ch1, ch2);
	}
}