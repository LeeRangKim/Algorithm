N, M = tuple(map(int, input().split()))

grid = list(map(int, input().split()))
grid_sum = [0] * (N+1)
grid_sum[0] = grid[0]

for i in range(1, N+1):
    grid_sum[i] = grid_sum[i-1] + grid[i-1]

for i in range(M):
    a, b = tuple(map(int, input().split()))
    print(grid_sum[b] - grid_sum[a-1])
