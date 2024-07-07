from collections import deque

N, M = tuple(map(int, input().split()))

inputArr = [[0]*(N+1) for _ in range(N+1)]

for i in range(M):
    a, b = tuple(map(int, input().split()))
    inputArr[a][b] = 1
    inputArr[b][a] = 1

min = 1000000
answer = -1

for i in range(1, N+1):
    check= [0]*(N+1)
    check[0] = 1
    check[i] = 1

    queue = deque()
    queue.append(i)

    while queue:
        now = queue.popleft()
        for j in range(1, N+1):
            if check[j] == 0 and inputArr[now][j] == 1:
                check[j] = check[now]+1
                queue.append(j)

    if sum(check) < min:
        min = sum(check)
        answer = i

print(answer)