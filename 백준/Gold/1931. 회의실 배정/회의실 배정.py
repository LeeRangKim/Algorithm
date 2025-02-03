N = int(input())

time = [list(map(int, input().split())) for _ in range(N)]
time.sort(key=lambda x : (x[1], x[0]))

answer = 0
now = 0
for ti in time:
    if now <= ti[0]:
        if ti[0] == ti[1]:
            answer +=1
            now = ti[0]
        else:
            now = ti[1]
            answer += 1

print(answer)