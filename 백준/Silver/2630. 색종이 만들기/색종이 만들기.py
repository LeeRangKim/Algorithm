N = int(input())

grid = [list(map(int, input().split())) for _ in range(N)]

answer = [0, 0]


def check(r, c, length):
    need_cut = 0

    check_color = grid[r][c]
    for i in range(length):
        for j in range(length):
            if grid[r + i][c + j] != check_color:
                need_cut = 1
                break
        if need_cut: break

    if need_cut:
        next_length = int(length / 2)
        check(r, c, next_length)
        check(r + next_length, c, next_length)
        check(r, c + next_length, next_length)
        check(r + next_length, c + next_length, next_length)
    else:
        answer[check_color] += 1


check(0, 0, N)

print(answer[0])
print(answer[1])
