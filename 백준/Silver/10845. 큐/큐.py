import sys

N = int(sys.stdin.readline())

front = 0
back = 0
queue = [-1] * 10000

for i in range(0, N):
    cmds = sys.stdin.readline().split()
    cmd = cmds[0]
    if cmd == "push":
        queue[back] = cmds[1]
        back += 1

    elif cmd == "pop":
        if front == back:
            print(-1)
        else:
            print(queue[front])
            queue[front] = -1
            front += 1

    elif cmd == "front":
        if front == back:
            print(-1)
        else:
            print(queue[front])

    elif cmd == "back":
        if front == back:
            print(-1)
        else:
            print(queue[back-1])

    elif cmd == "empty":
        if front == back:
            print(1)
        else:
            print(0)

    elif cmd == "size":
        print(back - front)