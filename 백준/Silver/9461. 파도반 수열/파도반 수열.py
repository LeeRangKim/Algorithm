T = int(input())

for i in range(T):
    N = int(input());

    spin = [0] * 101
    spin[1] = 1
    spin[2] = 1
    spin[3] = 1
    spin[4] = 2
    spin[5] = 2
    for i in range(6, 101):
        spin[i] = spin[i-1] + spin[i-5]

    print(spin[N])
