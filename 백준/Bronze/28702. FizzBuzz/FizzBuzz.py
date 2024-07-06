import sys

# 입력값 초기화
list_input = [sys.stdin.readline().strip() for _ in range(3)]

# 출력할 i 계산
val = [int(v) + (3 - i) for i, v in enumerate(list_input) if v.isnumeric()][0]

# 조건 별 출력값 초기화
answer = ""
if val % 3 == 0:
    answer += 'Fizz'
if val % 5 == 0:
    answer += 'Buzz'
   
# 출력
print(answer if answer != '' else val)