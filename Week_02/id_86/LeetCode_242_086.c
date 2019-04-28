#include<stdbool.h> 

// 120ms 7.1MB
bool MethodFor242_1(char* s, char* t) 
{
	int flag = 1;
	if (strlen(s) != strlen(t))
	{
		flag = 0;
	}
	else
	{
		int a[26] = { 0 };
		for (int i = 0; i < strlen(s); i++)
		{
			a[s[i] - 'a']++;
			a[t[i] - 'a']--;
		}

		for (int i = 0; i < 26; i++)
		{
			if (a[i] != 0)
			{
				flag = 0;
			}
		}
	}
	return flag;

}