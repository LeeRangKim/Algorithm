from collections import deque

n, m = tuple(map(int, input().split()))

grid = []
check = [[0 for _ in range(m)] for _ in range(n)]
start = []

for i in range(n):
    temp = list(map(int, input().split()))
    if 2 in temp :
        start = [i, temp.index(2)]
        check[i][temp.index(2)] = 0
    grid.append(temp)

queue = deque()
queue.append(start)

pos_i = [0, 0, 1, -1]
pos_j = [1, -1, 0, 0]

while queue:
    now = queue.popleft()
    now_i = now[0]
    now_j = now[1]
    for i in range(4):
        next_i = now_i + pos_i[i]
        next_j = now_j + pos_j[i]
        if next_i == start[0] and next_j == start[1]:
            continue
        if next_i < 0 or next_i >= n:
            continue
        if next_j < 0 or next_j >= m:
            continue
        if check[next_i][next_j] != 0:
            continue
        if grid[next_i][next_j] != 1:
            continue
        queue.append([next_i, next_j])
        check[next_i][next_j] = check[now_i][now_j] + 1

for i in range(n):
    temp = []
    for j in range(m):
        if grid[i][j] == 1 and check[i][j] == 0:
            temp.append(-1)
        else: temp.append(check[i][j])
    print(*temp)