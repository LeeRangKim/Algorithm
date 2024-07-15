import sys

N = int(sys.stdin.readline())

heap = []


def heap_push():
    now = len(heap)-1
    while now > 0:
        next = int((now-1)/2)
        if abs(heap[now]) < abs(heap[next]) or (abs(heap[now]) == abs(heap[next]) and heap[now] < heap[next]):
            heap[now], heap[next] = heap[next], heap[now]
            now = next
        else:
            break



def heap_pop():
    heap[0] = heap[-1]
    heap.pop(-1)
    now = 0

    right = (now+1)*2
    left = right-1

    while left < len(heap):
        if right == len(heap):
            if abs(heap[left]) < abs(heap[now]) or (abs(heap[left]) == abs(heap[now]) and heap[left] < heap[now]):
                heap[now], heap[left] = heap[left], heap[now]
                now = left
                right = (now + 1) * 2
                left = right - 1
                continue
        else:
            # left가 더 작거나 같을떄
            if abs(heap[left]) < abs(heap[right]) or (abs(heap[left]) == abs(heap[right]) and heap[left] <= heap[right]):
                if abs(heap[now]) > abs(heap[left]) or (abs(heap[now]) == abs(heap[left]) and heap[now] > heap[left]):
                    heap[now], heap[left] = heap[left], heap[now]
                    now = left
                    right = (now + 1) * 2
                    left = right - 1
                    continue
            # right가 더 작을때
            elif abs(heap[right]) < abs(heap[left]) or (abs(heap[right]) == abs(heap[left]) and heap[right] < heap[left]):
                if abs(heap[now]) > abs(heap[right]) or (abs(heap[now]) == abs(heap[right]) and heap[now] > heap[right]):
                    heap[now], heap[right] = heap[right], heap[now]
                    now = right
                    right = (now + 1) * 2
                    left = right - 1
                    continue
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