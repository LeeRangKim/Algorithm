N, K = map(int, input().split())


def check(N, K):
    if K == 1 or N == K:
        return 1
    if K < 1 or K > N:
        return 0
    return check(N - 1, K - 1) + check(N - 1, K)


print(check(N+1, K+1))
