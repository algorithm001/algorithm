#include<stdio.h>

struct stack_1 {
	char stack[512];
	int top;
	void (*push) (struct stack_1 * this,char c);
	char (*pop) (struct stack_1 * this);
	int (*is_empty) (struct stack_1 * this);
};

//char stack[512];
//int top = 0;

void push1(struct stack_1 * this,char c) {
	this->stack[this->top++] = c;
}

char pop1(struct stack_1 * this) {
	return this->stack[--this->top];
}

int is_empty1(struct stack_1 * this) {
	return this->top == 0;
}

int main(void) {
	struct stack_1 st1 = {
		.stack="",
		.top = 0,
		.push = push1,
		.pop = pop1,
		.is_empty = is_empty1, 	
	};
	st1.push(&st1,'a');
	st1.push(&st1,'b');
	st1.push(&st1,'c');

	while ( !st1.is_empty(&st1)) {
		putchar(st1.pop(&st1));
	}
	putchar('\n');
	struct stack_1 st2 = {
		"",
		0,
		push1,
		pop1,
		is_empty1, 	
	};
    struct stack_1 *st3 = &st2;
    st3->push(st3,'b');
    st3->push(st3,'5');
    st3->push(st3,'3');
	while ( !st3->is_empty(st3)) {
		putchar(st3->pop(st3));
	}
	putchar('\n');
	return 0;
}
