N = int(input())

heap = []


def heapify(heap, n):
    if n == 0: return
    elif n % 2:
        next_n = int((n+1)/2-1)
    else:
        next_n = int((n-2)/2)
    if heap[n] < heap[next_n]:
        heap[n], heap[next_n] = heap[next_n], heap[n]
        heapify(heap, next_n)

def heapify_down(heap, idx, size):
    left = 2 * idx + 1
    right = 2 * idx + 2
    smallest = idx

    if left < size and heap[left] < heap[smallest]:
        smallest = left
    if right < size and heap[right] < heap[smallest]:
        smallest = right

    if smallest != idx:
        heap[idx], heap[smallest] = heap[smallest], heap[idx]
        heapify_down(heap, smallest, size)


for _ in range(N):
    temp_list = list(map(int, input().split()))

    for temp in temp_list:
        if len(heap) >= N:
            if heap[0] < temp:
                heap[0] = heap[-1]
                heap.pop()
                heapify_down(heap, 0, len(heap))
            else : continue
        heap.append(temp)
        heapify(heap, len(heap)-1)

print(heap[0])
