#include <stdio.h>

long long int kimchi(int n){
	long long int a[100] = { 0, 1, 1, 1 };
	for (int i = 4; i <= n; i++){
		if (i % 3 == 0) a[i] = 3 * a[i - 1] - 2 * a[i - 2] - a[i - 3];
		else if (i % 3 == 1) a[i] = 3 * a[i - 1] - 2 * a[i - 2] + a[i - 3];
		else a[i] = 2 * a[i - 1] - 2 * a[i - 2] + a[i - 3];
	}
	return a[n];
}

int main(void){
	int N;
	scanf("%d", &N);
	printf("%lld", kimchi(N));
	return 0;
}