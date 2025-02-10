import sys
input = sys.stdin.readline

N = int(input())

input_list = list(map(int, input().split()))
input_dict = dict()

set_list = sorted(list(set(input_list)))
for i in range(len(set_list)):
    input_dict[set_list[i]] = i

for num in input_list:
    print(input_dict[num], end=" ")


