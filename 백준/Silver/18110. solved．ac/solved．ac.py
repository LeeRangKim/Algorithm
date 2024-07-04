N = int(input())

scores = []

for i in range(N):
    scores.append(int(input()))

scores.sort()


def my_round(num):
    if num - int(num) >= 0.5:
        return int(num) + 1
    else:
        return int(num)


buffer = my_round(N * 0.15)

scores = scores[buffer: N - buffer]

if sum(scores) == 0:
    print(0)
else:
    print(my_round(sum(scores) / (N - (buffer * 2))))
