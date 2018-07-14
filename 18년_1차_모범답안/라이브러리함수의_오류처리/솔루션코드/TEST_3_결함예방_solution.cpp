#include <iostream>
#include <string.h>

using namespace std;

#define SRC_SIZE	30	// src�迭�� ��Ҽ�
#define DEST_SIZE	20	// dest�迭�� ��Ҽ�
int dest[DEST_SIZE];		// ���� �����Ͱ� ����� �迭
int src[SRC_SIZE]={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

// �ۼ��� �Լ�
int SafeMove(int src_idx, int dest_idx, int length)
{
	if(src_idx >= SRC_SIZE || src_idx < 0)return -1;
	if(dest_idx >= DEST_SIZE || dest_idx < 0)return -1;
	if(src_idx + length >SRC_SIZE || dest_idx + length > DEST_SIZE) return -1;
	if(length < 0) return -1;

	memmove(dest+dest_idx, src+src_idx, length*sizeof(int));
	return 0;
}
int main(void)
{
	int i, r;
	int src_idx;			// ���縦 ������ src�迭�� ���� ��ҹ�ȣ
	int dest_idx;			// ����� �����Ͱ� ����� dest�迭�� ���� ��ҹ�ȣ
	int copy_len;			// ������ �������� ����

	cin >> src_idx >> dest_idx >> copy_len;

	r = SafeMove(src_idx, dest_idx, copy_len);
	if(r == -1) cout << "ERROR" << endl;
	else
	{
		for(i=0; i<DEST_SIZE; i++)
		{
			cout << dest[i] << " ";
		}
	}
}


