#include<stdio.h>
/**
 * https://akaedu.github.io/book/ch12s04.html
 * 广度优先搜索（BFS，Breadth First Search）
 * 1. 利用队列的FIFO
 * 2. 每个方向各进一步，这就是最短路径的关键？
 * 3. 一旦被走了的节点，其他的就不能走了
 */

#define MAX_ROW 5
#define MAX_COL 5

struct point {
	int row, col, predecessor;
} queue[512];
int head = 0, tail = 0;

void enqueue(struct point p)
{
	queue[tail++] = p;
}

struct point dequeue(void)
{
	return queue[head++];
}

int is_empty(void) {
	return head == tail;
}

int maze[MAX_ROW][MAX_COL] = {
    0, 1, 0, 0, 0,
	0, 1, 0, 1, 0,
	0, 0, 0, 0, 0,
	0, 1, 1, 1, 0,
	0, 0, 0, 1, 0,
};

void print_maze(void)
{
	int i, j;
	for (i = 0; i < MAX_ROW; i++) {
		for (j = 0; j < MAX_COL; j++)
			printf("%d ", maze[i][j]);
		putchar('\n');
	}
	printf("*********\n");
}

/**
* 走过的标为 2
*/
void visit(int row, int col)
{
	struct point visit_point = { row, col, head-1 };
	maze[row][col] = 2;
	printf("enqueue(%d, %d)\n", visit_point.row, visit_point.col);
	enqueue(visit_point);
}	

int main(void)
{
	struct point p = { 0, 0, -1};

	maze[p.row][p.col] = 2;
	enqueue(p);	
	
	while (!is_empty()) {
		p = dequeue();
		printf("(%d, %d)\n", p.row, p.col);
		if (p.row == MAX_ROW - 1  /* goal */
		    && p.col == MAX_COL - 1)
			break;
		if (p.col+1 < MAX_COL     /* right */
		    && maze[p.row][p.col+1] == 0)
			visit(p.row, p.col+1);
		if (p.row+1 < MAX_ROW     /* down */
		    && maze[p.row+1][p.col] == 0)
			visit(p.row+1, p.col);
		if (p.col-1 >= 0          /* left */
		    && maze[p.row][p.col-1] == 0)
			visit(p.row, p.col-1);
		if (p.row-1 >= 0          /* up */
		    && maze[p.row-1][p.col] == 0)
			visit(p.row-1, p.col);
		print_maze();
	}
	if (p.row == MAX_ROW - 1 && p.col == MAX_COL - 1) {
		printf("(%d, %d)\n", p.row, p.col);
		printf("path:\n");
		// 最后用3标识走过的路径
		maze[p.row][p.col] = 3;
		while (p.predecessor != -1) {
			p = queue[p.predecessor];
			maze[p.row][p.col] = 3;
			printf("(%d, %d)\n", p.row, p.col);
		}
		print_maze();
	} else
		printf("No path!\n");

	return 0;
}
