T = int(input())

for i in range(T):
    N = int(input())
    clothes = dict()

    for j in range(N):
        (name, type) = tuple(input().split())
        temp = clothes.get(type, 0) + 1
        clothes[type] = temp

    answer = 1
    for type, cnt in clothes.items():
        answer *= (cnt + 1)

    print(answer-1)