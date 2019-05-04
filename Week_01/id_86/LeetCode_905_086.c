//simple C

int* MethodFor905_1(int* A, int ASize, int* BSize) 
{
	int e = 0;
	int o = ASize - 1;
	int *B = (int *)malloc(sizeof(int) * ASize);

	for (int i = 0; i < ASize; i++)
	{
		if (A[i] % 2 == 0)
		{
			B[e++] = A[i];
		}
		else
		{
			B[o--] = A[i];
		}
	}
	*BSize = ASize;
	return B;
}