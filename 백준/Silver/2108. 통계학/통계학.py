N = int(input())
infoArr = []

cnt = [0] * 8002

for i in range(N):
    temp = int(input())
    infoArr.append(temp)
    cnt[temp+4000] += 1

infoArr.sort()


def my_round(num):
    if num >= 0:
        if num - int(num) >= 0.5:
            return int(num) + 1
        else:
            return int(num)

    else:
        if num - int(num) <= -0.5:
            return int(num)-1
        else:
            return int(num)


max_num = max(cnt)
answer = -1
for i in range(0, 8002):
    if max_num == cnt[i]:
        if answer != -1:
            answer = i
            break
        else:
            answer = i
answer-=4000

print(my_round(sum(infoArr) / N))
print(infoArr[int(N / 2)])
print(answer)
print(max(infoArr)-min(infoArr))
