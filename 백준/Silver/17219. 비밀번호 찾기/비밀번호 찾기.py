N, M = tuple(map(int, input().split()))

link_dic = {}

for i in range(N):
    site, password = tuple(input().split())
    link_dic[site] = password

for i in range(M):
    site = input()
    print(link_dic[site])