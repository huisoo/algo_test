package algo_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {

    int start;
    int destination;
    int time;

    public Node(int start, int destination, int time) {

        this.start = start;
        this.destination = destination;
        this.time = time;
    }
}

public class timemachine_bak11657 {
	
	static final int NONE = -1;
    static final int INFINITE = 10000000;
    static boolean negative_cycle = false;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		int N; // 도시의 개수
        int M; // 버스 노선의 개수
        Node[] node;
        int[] dist; // 시작 노드에서 각 노드까지의 최단 거리

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
		try {
			st = new StringTokenizer(br.readLine());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        N = Integer.parseInt(st.nextToken()); //캐스팅
        M = Integer.parseInt(st.nextToken());

        // 버스 정보, 걸리는 시간 초기화
        node = new Node[M];
        dist = new int[N + 1];
        // start node
        
        for (int i = 0; i < N + 1; i++) {
            dist[i] = INFINITE; // 시간 무한으로 초기화
        }
        dist[1] = 0;
        

        // 버스 노선 정보(A출발지 B도착치 C걸리는시간(가중치))
        for (int i = 0; i < M; i++) {

            try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            node[i] = new Node(A, B, C);
        }
        
       
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                int x = node[j].start;
                int y = node[j].destination;
                int z = node[j].time;
                if (dist[x] != INFINITE && dist[y] > dist[x] + z) {
                    dist[y] = dist[x] + z;
                    if (i == N) {
                        negative_cycle = true;
                        break;
                    }
                }
            }
        }
        if (negative_cycle) {
            System.out.println(NONE);
        }
        else
        {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INFINITE) {
                	System.out.println(NONE);
                }else
                	System.out.println(dist[i]);
                }
        }
    
        


	}
	
	 
}
