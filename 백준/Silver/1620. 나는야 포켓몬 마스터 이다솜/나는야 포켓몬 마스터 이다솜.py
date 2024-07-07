N, M = tuple(map(int, input().split()))

poketDicByNum = {}
poketDicByName = {}

for i in range(N):
    temp = input()
    poketDicByNum[i+1]= temp
    poketDicByName[temp] = i+1

for i in range(M):
    temp = input()
    if temp.isdigit():
        print(poketDicByNum[int(temp)])
    else:
        print(poketDicByName[temp])