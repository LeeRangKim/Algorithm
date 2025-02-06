from collections import deque

C, R, H = map(int, input().split())

box = [[list(map(int, input().split())) for _ in range(R)] for __ in range(H)]
check_box = [[[-1 for _ in range(C)] for _ in range(R)] for _ in range(H)]

queue = deque()

for i in range(H):
    for j in range(R):
        for k in range(C):
            if box[i][j][k] == 1:
                queue.append([i, j, k, 0])
                check_box[i][j][k] = 0


dc = [0, 0, 1, -1, 0, 0]
dr = [1, -1, 0, 0, 0, 0]
dh = [0, 0, 0, 0, -1, 1]

while queue:
    now_tomato = queue.popleft()

    for i in range(6):
        next_tomato = [now_tomato[0] + dh[i], now_tomato[1]+dr[i], now_tomato[2]+dc[i], now_tomato[3] + 1]

        if 0 <= next_tomato[0] < H and 0 <= next_tomato[1] < R and 0<= next_tomato[2] < C:
            if check_box[next_tomato[0]][next_tomato[1]][next_tomato[2]] == -1 and box[next_tomato[0]][next_tomato[1]][next_tomato[2]] == 0:
                check_box[next_tomato[0]][next_tomato[1]][next_tomato[2]] = next_tomato[3]
                box[next_tomato[0]][next_tomato[1]][next_tomato[2]] = 1
                queue.append(next_tomato)


answer = 0
for i in range(H):
    for j in range(R):
        for k in range(C):
            if box[i][j][k] == 0:
                answer = -1
                break
            if check_box[i][j][k] > answer != -1:
                answer = check_box[i][j][k]

print(answer)

