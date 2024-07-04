N, K = tuple(map(int, input().split()))
coins = []
for i in range(N):
    coins.append(int(input()))

coins.sort(reverse=True)

ans = 0
for i in range(N):
    ans += int(K / coins[i])
    K -= int(K / coins[i]) * coins[i]

print(ans)