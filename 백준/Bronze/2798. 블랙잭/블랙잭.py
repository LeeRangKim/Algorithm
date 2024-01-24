N, M = map(int, input().split())
cards = list(map(int, input().split()))


answer = 0

for i in range(0, N):
    for j in range(i+1, N):
        for k in range(j+1, N):
            temp = cards[i] + cards[j] + cards[k]
            if M >= temp > answer:
                answer = temp

print(answer)