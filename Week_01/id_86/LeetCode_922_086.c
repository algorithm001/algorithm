int *MethodFor922_1(int const *A, int ASize, int *BSize)
{
	int o = 1;
	int e = 0;
	int *ret = (int *)malloc(sizeof(int) * (*BSize = ASize));

	for (int i = 0; i < *BSize; ++i)
	{
		if (A[i] % 2 == 0)
		{
			ret[e] = A[i];
			e = e + 2;
		}
		else
		{
			ret[o] = A[i];
			o = o + 2;
		}
	}
	return ret;
}