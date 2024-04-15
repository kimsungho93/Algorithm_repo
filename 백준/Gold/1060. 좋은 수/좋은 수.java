import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class GoodNum implements Comparable<GoodNum>{
	int left;	
	int right;	
	int idx;	
	int count;	
	
	public GoodNum(int left, int right, int idx, int count) {
		super();
		this.left = left;	
		this.right = right;	
		this.idx = idx;		
		this.count = count;	
	}
	
	@Override
	public int compareTo(GoodNum o) {
		int res = this.count - o.count;
		if (res == 0) return this.left - o.left;
		
		return res;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int L = Integer.parseInt(in.readLine());
		
		PriorityQueue<GoodNum> good = new PriorityQueue<>();

		st = new StringTokenizer(in.readLine());
		List<Integer> list = new ArrayList<>();	
		for(int i = 0; i < L; i++) {
			int temp = Integer.parseInt(st.nextToken());
			list.add(temp);
			good.offer(new GoodNum(temp, temp, 0, 0));
		}
		
		int n = Integer.parseInt(in.readLine());
		
		Collections.sort(list);

		int left = 1;
		int right = Integer.MAX_VALUE;
		for(int i = 0; i < L; i++) {
			if (left == list.get(i)) {
				left = list.get(i) + 1;
				continue;
			}
			right = list.get(i)-1;
			good.offer(new GoodNum(left, right, 0, right - left));
			left = right+2;
		}
		
		while(!good.isEmpty() && n > 0) {	
			GoodNum cur = good.poll();
			int curLeft = cur.left + cur.idx;
			int curRight = cur.right - cur.idx;
			
			sb.append(curLeft).append(" ");
			n--;
			
			if (n <= 0) break;
			
			
			if(curLeft != curRight) {
				sb.append(curRight).append(" ");
				n--;
			}
			
			if(curLeft == curRight || (curLeft+1) == curRight)
				continue;

			int newIdx = cur.idx+1;
			int newCount = (newIdx+1)*(cur.right - (cur.left+newIdx)) + newIdx; 
			good.offer(new GoodNum(cur.left, cur.right, newIdx, newCount));
		}
		
		for(int v = list.get(L-1)+1; n > 0; n--) {
			sb.append(v++).append(" ");
		}
		
		System.out.println(sb);
	}
}