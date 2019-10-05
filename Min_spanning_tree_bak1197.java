package algo_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

    int start;
    int destination;
    int cost;

    public Edge(int start, int destination, int cost) {

        this.start = start;
        this.destination = destination;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Edge o) {
    	if(this.cost < o.cost) return -1;
    	else if(this.cost==o.cost) return 0;
    	else return 1;
    }
}

public class Min_spanning_tree_bak1197 {
	
	public static int[] parent;
	public static ArrayList<Edge> EdgeList;
	
	public static int getParent(int Parent[], int x) {
		if(parent[x]==x) {
			return x;
		}
		return parent[x] = getParent(parent, parent[x]);
	}
	
	public static boolean findParent(int parent[], int x, int y) {
		x=getParent(parent, x);
		y=getParent(parent, y);
		if(x==y) return true;
		return false;
	}
	
	public static void unionParent(int x, int y) {
		x = getParent(parent, x);
		y = getParent(parent, y);
		if(x<y) parent[y] = x;
		else parent[x]=y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		int N; // 도시의 개수
        int M; // 버스 노선의 개수
        EdgeList = new ArrayList<Edge>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
		try {
			st = new StringTokenizer(br.readLine());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        N = Integer.parseInt(st.nextToken()); //노드 수
        M = Integer.parseInt(st.nextToken()); //간선수

        parent = new int[N+1];
        //parent 초기화
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i; 
        }
        
      
        // 버스 노선 정보(A출발지 B도착치 C걸리는시간(가중치))
        for (int i = 1; i < M+1; i++) {
            try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            EdgeList.add(new Edge(A, B, C));
        }
        //Cost 오름차순
        Collections.sort(EdgeList);
        
        //System.out.println(EdgeList.get(0).start);
        
        int sum = 0;
        for(int i=0;i<EdgeList.size();i++) {
        	Edge edge = EdgeList.get(i);
        	if(!findParent(parent, edge.start, edge.destination)) {
        		sum +=edge.cost;
        		unionParent(edge.start, edge.destination);
        	}
        }
        
        
        System.out.println(sum);

	}
	
	 
}
