
    // �½����飬ż����ǰ������룬�����Ӻ���ǰ����
	// ʱ�临�Ӷ�O(n)
	// �ռ临�Ӷ�O(2n)�����������ƻ�ԭ������
    public int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];

        int head = 0;
        int tail = A.length -1;
        // �������ݣ������ż��
        for (int i = 0; i < A.length ; i++) {
            if (A[i] % 2 == 0){
                B[head] = A[i];
                head ++;
            }else {
                B[tail] = A[i];
                tail --;
            }
            // �������ݶ�������
            if (head > tail){
                break;
            }
        }
        return B;
    }


    // ����ָ��ֱ��ǰ��ɨ�裬ż����ǰ������룬�����Ӻ���ǰ����
	// �����������飬��Լ�ڴ�ռ�
	// ʱ�临�Ӷ�O(n)
	// �ռ临�Ӷ�O(n)�����ƻ�ԭ������
    public int[] sortArrayByParity1(int[] A) {
        if (A.length == 1){
            return A;
        }

        int head = 0;
        int tail = A.length -1;
        int swap = 0;
        // �������ݣ������ż��
        for (int i = 0; i < A.length ; i++) {
            // headָ��ż����ǰ��
            if (A[head] % 2 == 0){
                head ++;
            }
            // headָ������������β�����һ��ż������head����
            else {
                if (A[tail] % 2 != 0){
                    tail --;
                }else {
                    swap = A[head];
                    A[head] = A[tail];
                    A[tail] = swap;
                    head ++;
                    tail --;
                }

            }
            // �������ݶ�������
            if (head >= tail){
                break;
            }
        }
        return A;
    }