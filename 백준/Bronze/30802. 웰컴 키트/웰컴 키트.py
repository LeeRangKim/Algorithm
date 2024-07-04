N = int(input())
sizeArr = map(int, input().split(" "))
T, P = tuple(map(int, input().split(" ")))

out1 = 0
for size in sizeArr:
    out1 += int(size / T)
    if size % T != 0 : out1 += 1

out2 = int(N / P)
out3 = N % P

print(out1)
print(out2, out3)