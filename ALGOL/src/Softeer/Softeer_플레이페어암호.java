package Softeer;
import java.util.*;
import java.io.*;

public class Softeer_플레이페어암호 {
	static char[][] map = new char[5][5];
	static int idxF;
	static int idxS;
	static int idxFy;
	static int idxSy;
	static int cnt;
	static StringBuilder answer = new StringBuilder();

	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String msg = bf.readLine();
		String key = bf.readLine();
		// 65
		// 90
		// 74
		int t = 1 << 26;
		t = t | 1 << 9;
		int y = 0;
		int x = 0;
		int tmp = 0;
		for (int i = 0; i < key.length(); i++) {
			tmp = (int) key.charAt(i) - 65;
			if ((t & 1 << tmp) > 0)
				continue;
			t = t | 1 << tmp;
			map[y][x] = key.charAt(i);
			x += 1;
			if (x > 4) {
				x = 0;
				y += 1;
			}
		}
		int idx = 0;
		for (int i = idx; i < 26; i++) {
			if ((t & 1 << i) > 0)
				continue;
			idx = i;
			map[y][x] = (char) (65 + i);
			x += 1;
			if (x > 4) {
				x = 0;
				y += 1;
			}
			if (y == 5)
				break;
		}

		char tmpF;
		char tmpS;
		int size = msg.length();
		sb.append(msg);
		int i = 0;
		while (size / 2 > i) {
			if (2 * i + 1 == size) {
				tmpF = sb.charAt(2 * i);
				sb.append('X');
				break;
			} else {
				tmpF = sb.charAt(2 * i);
				tmpS = sb.charAt((2 * i) + 1);
			}
			if (tmpF == tmpS) {

				if (tmpF == 'X') {
					sb.insert(2 * i + 1, 'Q');

				} else
					sb.insert(2 * i + 1, 'X');
				size++;
			}
			i++;
		}
		if (sb.length() % 2 == 1)
			sb.append('X');
		int cnt = 0;
		for (int j = 0; j < (sb.length() / 2); j++) {
			tmpF = sb.charAt(2 * j);
			tmpS = sb.charAt((2 * j) + 1);
			if (checkR(tmpF, tmpS)) {

			} else if (checkC(tmpF, tmpS)) {

			} else {
				checkAl(tmpF, tmpS);
			}

		}
		System.out.println(answer.toString());

	}

	public static boolean checkR(char F, char S) {
		idxF = 0;
		idxS = 0;
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == F) {
					idxF = j;
					cnt++;
				}
				if (map[i][j] == S) {
					idxS = j;
					cnt++;
				}
				if (cnt == 2) {
					if (idxF != 4) {
						answer.append(map[i][idxF + 1]);
					} else if (idxF == 4) {
						answer.append(map[i][0]);
					}
					if (idxS != 4) {
						answer.append(map[i][idxS + 1]);
					} else if (idxS == 4) {
						answer.append(map[i][0]);
					}
					return true;
				}
			}
			cnt = 0;
		}
		return false;
	}

	public static boolean checkC(char F, char S) {
		idxF = 0;
		idxS = 0;
		int cnt = 0;
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 5; i++) {
				if (map[i][j] == F) {
					idxF = i;
					cnt++;
				}
				if (map[i][j] == S) {
					idxS = i;
					cnt++;
				}
				if (cnt == 2) {
					if (idxF != 4) {
						answer.append(map[idxF + 1][j]);
					} else if (idxF == 4) {
						answer.append(map[0][j]);
					}
					if (idxS != 4) {
						answer.append(map[idxS + 1][j]);
					} else if (idxS == 4) {
						answer.append(map[0][j]);
					}
					return true;
				}
			}
			cnt = 0;
		}
		return false;
	}

	static void checkAl(char F, char C) {
		idxF = 0;
		idxS = 0;
		idxFy = 0;
		idxSy = 0;
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == F) {
					idxF = j;
					idxFy = i;
					cnt++;
				}
				if (map[i][j] == C) {
					idxS = j;
					idxSy = i;
					cnt++;
				}
				if (cnt == 2) {
					answer.append(map[idxFy][idxS]);
					answer.append(map[idxSy][idxF]);
					return;
				}
			}
		}
	}
}
