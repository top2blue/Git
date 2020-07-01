package kr.green.Example.ex0610;
/*
문제 1] 3n+1 Problem
어떤 정수 n에서 시작해, n이 짝수면 2로 나누고, 홀수면 3을 곱한 다음 1을 더한다. 
이렇게 해서 새로 만들어진 숫자를 n으로 놓고, n=1 이 될때까지 같은 작업을 계속 반복한다. 
예를 들어, n=22이면 다음과 같은 수열이 만들어진다.
22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1

n이라는 값이 입력되었을때 1이 나올때까지 만들어진 수의 개수(1을 포함)를 n의 사이클 길이라고 한다. 
위에 있는 수열을 예로 들면 22의 사이클 길이는 16이다. 
i와 j라는 두개의 수가 주어졌을때, i와 j사이의 모든 수(i, j포함)에 대해 최대 사이클 길이를 구하라.

입력 예
1    10
100  200
201  210
900  1000

출력 예
1    10    20
100  200   125
201  210   89
900  1000  174
*/

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Ex02 {
	public static void main(String[] args) {
		int n = 22, maxCycle=0;
		while(n>1) {
			System.out.print(n + " ");
			if(n%2==0)
				n = n/2;
			else
				n = n*3+1;
			maxCycle++;
		}
		System.out.print(n);
		System.out.println(" : " + ++maxCycle);
	}
	@Test
	public void test() {
		assertEquals(Ex02.exam2(1,10), 20);
		assertEquals(Ex02.exam2(100,200), 125);
		assertEquals(Ex02.exam2(201,210), 89);
		assertEquals(Ex02.exam2(900,1000), 174);
	}
	// 아래 메서드 두개를 1개로 합쳐도 답이 나온다.
	public static int exam2(int a, int b) {
		int max=0;
		for(int i=a;i<=b;i++) {
			int cycle=0, n = i;
			while(n>1) {
				if(n%2==0)
					n = n/2;
				else
					n = n*3+1;
				cycle++;
			}
			++cycle;	
			if(max<cycle) max = cycle;
		}
		return max;
	}
	// 싸이클은 다른 메서드에서 구하여 받고 여기서는 싸이클의 최대값만 구한다.
	public static int exam(int a, int b) {
		int max=0;
		for(int i=a;i<=b;i++) {
			if(max<getCycle(i)) max = getCycle(i);
		}
		return max;
	}
	// 지정 숫자에 대한 사이클 횟수를 리턴하는 메서드
	public static int getCycle(int n) {
		int cycle=0;
		while(n>1) {
			if(n%2==0)
				n = n/2;
			else
				n = n*3+1;
			cycle++;
		}
		return ++cycle;
	}
	
	

}
