#include <iostream>
#include <string.h>

using namespace std;

#define SRC_SIZE	30	// src배열의 요소수
#define DEST_SIZE	20	// dest배열의 요소수
int dest[DEST_SIZE];		// 원본 데이터가 복사될 배열
int src[SRC_SIZE]={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

// 작성할 함수
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
	int src_idx;			// 복사를 시작할 src배열의 시작 요소번호
	int dest_idx;			// 복사된 데이터가 저장될 dest배열의 시작 요소번호
	int copy_len;			// 복사할 데이터의 갯수

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


