N = int(input())

numArr = [0] * 10001
for i in range(N):
    numArr[int(input())] += 1

for i in range(10001):
    if numArr[i] != 0:
        for j in range(numArr[i]):
            print(i)
