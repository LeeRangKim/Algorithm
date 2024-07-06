N = int(input())
infoArr = []
for i in range(N):
    infoArr.append(list(map(int, input().split())))

infoArr.sort(key=lambda x: (x[1], x[0]))

for i in range(N):
    print(*infoArr[i])