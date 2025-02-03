N, r, c = map(int, input().split())

answer = 0

for i in range(N-1, -1, -1):
    base = 2**i
    num = base * base
    if r >= base and c >= base:
        answer += num * 3
        r -= base
        c -= base
    elif r >= base and c < base :
        answer += num * 2
        r -= base
    elif r < base and c >= base :
        answer += num * 1
        c -= base
    elif r < base and c < base :
        answer += num * 0
print(answer)