package jungol;

import java.util.Scanner;

public class Main1671_X_ {
	
	static class WhitePaper {
		private static final int SIZEOFPAPER = 100;
		private boolean[][] paper;
		
		public WhitePaper() {
			paper = new boolean[SIZEOFPAPER + 2][SIZEOFPAPER + 2];
		}
		
		public void attachColorPaper(int x, int y, int size) {
			if (x < 0 || y < 0 || x + size > 100 || y + size > 100) {
				System.out.println("Input Error!");
				System.exit(1);
			}
			x++; y++;
			for (int i = x; i < x + size; i++) {
				for (int j = y; j < y + size; j++) {
					if (!paper[i][j]) {
						paper[i][j] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		WhitePaper paper = new WhitePaper();
		int n = in.nextInt();
		if (n > 100 || n < 1) {
			System.exit(1);
		}
		
		for (int i = 0; i < n; i++) {
			paper.attachColorPaper(in.nextInt(), in.nextInt(), 10);
		}
		in.close();
		
		n = WhitePaper.SIZEOFPAPER + 2;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (paper.paper[i][j]) {
					if (!paper.paper[i - 1][j]) {
						count++;
					}
					if (!paper.paper[i + 1][j]) {
						count++;
					}
					if (!paper.paper[i][j - 1]) {
						count++;
					}
					if (!paper.paper[i][j + 1]) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
