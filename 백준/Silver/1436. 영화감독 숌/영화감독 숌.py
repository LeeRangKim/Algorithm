import sys
def check(tempList):
    count = 0
    for temp in tempList:
        if temp == "6":
            count += 1
            if count == 3:
                return 1
        else:
            count = 0
    return 0


N = int(sys.stdin.readline())

now = 0
num = 665

while now != N:
    num += 1
    if check(list(str(num))):
        now += 1
        if now == N:
            print(num)
            break
