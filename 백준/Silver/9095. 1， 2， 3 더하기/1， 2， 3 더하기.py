T = int(input())


def check(n):
    global answer
    if n < 0: return
    elif n == 0 : answer += 1
    else:
        check(n-1)
        check(n-2)
        check(n-3)


for i in range(T):
    n = int(input())
    answer = 0
    check(n)
    print(answer)

