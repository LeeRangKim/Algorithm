N = int(input())
infoArr = []
for i in range(N):
    infoArr.append(list(map(int, input().split())))

for me in infoArr:
    rank = 1
    for other in infoArr:
        if me[0] < other[0] and me[1] < other[1]:
            rank += 1
    print(rank, end=" ")
