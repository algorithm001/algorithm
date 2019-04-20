bool isValid(char* s) {
    int length = strlen(s);
    char* temp = (char*)malloc(length);
    int tail = 0;
    for (int i = 0;i < length;i++) {
        char value = s[i];
        if (value == '(' || value == '{' || value == '[' ) {
            temp[tail] = value;
            tail++;
        }
        else {
            if (tail == 0) {
                return false;
            }
            char now = temp[tail - 1];
            if ((now == '(' && value == ')') || (now == '{' && value == '}') || (now == '[' && value == ']')) {
                
            }
            else {
                return false;
            }
            tail--;
        }
    }
    if (tail != 0) {
        return false;
    }
    return true;
}