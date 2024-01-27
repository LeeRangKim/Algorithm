L = int(input())
word = input()

sumWord = 0

for i in range(L):
    sumWord += (ord(word[i])-96)*(31 ** i)

print(sumWord % 1234567891)