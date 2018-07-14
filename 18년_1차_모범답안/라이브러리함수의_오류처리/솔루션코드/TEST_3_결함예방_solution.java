import java.util.*;

public class Main {
	public static final int SRC_SIZE = 30;	// src�迭�� ��Ҽ�
	public static final int DEST_SIZE = 20;	// dest�迭�� ��Ҽ�
	
	static int src_idx;			// ���縦 ������ src�迭�� ���� ��ҹ�ȣ
	static int dest_idx;		// ����� �����Ͱ� ����� dest�迭�� ���� ��ҹ�ȣ
	static int copy_len;		// ������ �������� ����
	
	static int []src = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
	static int []dest = new int[DEST_SIZE];
	Scanner s = new Scanner(System.in);
	
	
	void inputData() {
		src_idx = s.nextInt();
		dest_idx = s.nextInt();
		copy_len = s.nextInt();
		s.close();
	}
	// �ۼ��� �Լ�
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
