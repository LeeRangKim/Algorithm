def check(num):
    if num == 1:
        return 0

    for i in range(2, num-1):
        if (num % i) == 0:
            return 0
    return 1


N = int(input())
numbers = list(map(int, input().split()))

answer = 0
for number in numbers :
    answer += check(number)

print(answer)


