import sys

input = sys.stdin.readline

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

T = int(input())

for _ in range(T):
    M, N, x, y = map(int, input().split())

    lcm = (M * N) // gcd(M, N)  # 최소공배수 구하기 (O(log min(M, N)))

    answer = -1
    while x <= lcm:  # x부터 시작해 M씩 증가하며 탐색 (O(M))
        if (x % N if x % N != 0 else N) == y:
            answer = x
            break
        x += M

    print(answer)
