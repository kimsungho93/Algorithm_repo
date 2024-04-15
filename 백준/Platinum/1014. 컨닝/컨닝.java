import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main {
	static int T,N,M;
	static char[][] room;
	static int[][] cache;
	public static void main(String[] args) throws IOException {
		InputReader reader = new InputReader();
		T = reader.readInt();
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
			room = new char[N][M];
			for (int i = 0; i < N; i++) {
				String rowLine = reader.readLine();
				for (int j = 0; j < M; j++) {
					room[i][j] = rowLine.charAt(j);
				}
			}
			cache = new int[N][1 << M];
			for (int i = 0; i < N; i++) {
				Arrays.fill(cache[i], -1);
			}
			int ret = arrangeMaxStudent(0,0);
			System.out.println(ret);
		}
	}

	private static int arrangeMaxStudent(int rowNum, int previousState) {
		if(rowNum == N) return 0;
		if(cache[rowNum][previousState] != -1) return cache[rowNum][previousState];
		List<Integer> currentArrangement = arrangeOneRow(rowNum, previousState);
		int ret = 0;
		for (int i = 0; i < currentArrangement.size(); i++) {
			int currentState = currentArrangement.get(i);
			int addStudents = getStudentAmount(currentState);
			ret = max(arrangeMaxStudent(rowNum+1, currentState)+addStudents, ret);
		}

		return cache[rowNum][previousState] = ret;
	}

	private static List<Integer> arrangeOneRow(int rowNum, int previousState) {
		List<Integer> l = new ArrayList<>();
		findArrangement(rowNum,0,0,previousState,l);
		return l;
	}

	private static void findArrangement(int currentRow, int currentCol, int currentState, int previousState, List<Integer> l) {
		if(currentCol == M) {
			l.add(currentState);
			return;
		}

		if(room[currentRow][currentCol] == '.' && canSeat(currentCol,currentState,previousState)) {
			findArrangement(currentRow, currentCol+1, currentState | (1 << currentCol), previousState, l);
		}
		findArrangement(currentRow, currentCol+1, currentState, previousState, l);
	}

	private static boolean canSeat(int index, int currentState, int previousState) {
		boolean leftSideCondition = (previousState & (1 << index-1)) == 0 && (currentState & (1 << index-1)) == 0;
		boolean leftBorderCondition = (previousState & (1 << 1)) == 0 && (currentState & (1 << 1)) == 0;
		boolean rightSideCondition = (previousState & (1 << index+1)) == 0 && (currentState & (1 << index+1)) == 0;
		boolean rightBorderCondition = (previousState & (1 << M-2)) == 0 && (currentState & (1 << M-2)) == 0;
		if(index == 0) return leftBorderCondition;
		if(index == M-1) return rightBorderCondition;

		if(leftSideCondition && rightSideCondition) return true;
		return false;
	}

	private static int getStudentAmount(int currentState) {
		int amount = 0;
		for (int i = 0; i < M; i++) {
			if((currentState & (1<<i)) != 0) amount++;
		}
		return amount;
	}

}
class InputReader {
	private BufferedReader br;

	public InputReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public InputReader(String filepath) {
		try {
			br = new BufferedReader(new FileReader(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Character> readLineIntoCharList() throws IOException {
		List<Character> l = new ArrayList<>();
		while(true) {
			int readVal = br.read();
			if(readVal == '\n' || readVal == -1) break;
			l.add((char)readVal);
		}
		return l;
	}

	public boolean ready() throws IOException {
		return br.ready();
	}

	public String readLine() throws IOException {
		return br.readLine();
	}
	public int readInt() throws IOException {
		return Integer.parseInt(readLine());
	}
	public Long readLong() throws IOException {
		return Long.parseLong(readLine());
	}
}