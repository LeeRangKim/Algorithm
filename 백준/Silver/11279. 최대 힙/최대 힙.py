import sys

N = int(sys.stdin.readline())

heap = []


def heap_push():
    now = len(heap)-1
    while now > 0:
        parent = int((now-1)/2)
        if heap[now] > heap[parent]:
            heap[now], heap[parent] = heap[parent], heap[now]
            now = parent
        else:
            break


def heap_pop():
    heap[0] = heap[len(heap)-1]
    heap.pop(-1)
    now = 0
    while (now + 1)*2 - 1 < len(heap):
        left = (now + 1)*2 - 1
        right =(now + 1)*2

        if right < len(heap):
            if heap[left] >= heap[right] and heap[left] > heap[now]:
                heap[now], heap[left] = heap[left], heap[now]
                now = left
            elif heap[right] > heap[left] and heap[right] > heap[now]:
                heap[right], heap[now] = heap[now], heap[right]
                now = right
            else:
                break
        else:
            if heap[left] > heap[now]:
                heap[now], heap[left] = heap[left], heap[now]
                now = left
            else:
                break


for i in range(N):
    x = int(sys.stdin.readline())

    if x == 0:
        if heap:
            print(heap[0])
            heap_pop()
        else: print(0)
    else:
        heap.append(x)
        heap_push()