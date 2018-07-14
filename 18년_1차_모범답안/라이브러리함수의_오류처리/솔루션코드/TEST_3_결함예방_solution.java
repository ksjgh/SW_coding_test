import java.util.*;

public class Main {
	public static final int SRC_SIZE = 30;	// src배열의 요소수
	public static final int DEST_SIZE = 20;	// dest배열의 요소수
	
	static int src_idx;			// 복사를 시작할 src배열의 시작 요소번호
	static int dest_idx;		// 복사된 데이터가 저장될 dest배열의 시작 요소번호
	static int copy_len;		// 복사할 데이터의 갯수
	
	static int []src = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
	static int []dest = new int[DEST_SIZE];
	Scanner s = new Scanner(System.in);
	
	
	void inputData() {
		src_idx = s.nextInt();
		dest_idx = s.nextInt();
		copy_len = s.nextInt();
		s.close();
	}
	// 작성할 함수
	int SafeMove(int src_idx, int dest_idx, int length) {
		if(src_idx >= SRC_SIZE || src_idx < 0)return -1;
		if(dest_idx >= DEST_SIZE || dest_idx < 0)return -1;
		if(src_idx + length >SRC_SIZE || dest_idx + length > DEST_SIZE) return -1;
		if(length < 0) return -1;
		
		System.arraycopy(src, src_idx, dest, dest_idx, length);
		return 0 ;
	}

	public static void main(String[] args) {
		Main m = new Main();
		
		m.inputData();				
		int r = m.SafeMove(src_idx, dest_idx, copy_len);
		
		if(r == -1) System.out.println("ERROR");
		else
		{
			for(int i=0; i<DEST_SIZE; i++)
			{
				System.out.print(dest[i]+" ");
			}
		}
	}
}
