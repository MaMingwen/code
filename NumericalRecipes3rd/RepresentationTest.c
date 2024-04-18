#include "stdio.h"

union Udoub {
	double d;
	unsigned char c[8];
};

void main() {
	union Udoub u;
	u.d = -0;
	for (int i=7;i>=0;i--) printf("%02x",u.c[i]);
	printf("\n");
}