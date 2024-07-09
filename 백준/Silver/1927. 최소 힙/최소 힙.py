import sys

N = int(sys.stdin.readline())

heap = []

def heap_push():
    now_idx = len(heap) - 1
    while now_idx > 0:
        parent_idx = (now_idx - 1) // 2
        if heap[now_idx] < heap[parent_idx]:
            heap[now_idx], heap[parent_idx] = heap[parent_idx], heap[now_idx]
            now_idx = parent_idx
        else:
            break

def heap_pop():
    heap[0] = heap[-1]
    heap.pop()
    now_idx = 0
    heap_size = len(heap)
    
    while True:
        left_idx = 2 * now_idx + 1
        right_idx = 2 * now_idx + 2
        smallest = now_idx
        
        if left_idx < heap_size and heap[left_idx] < heap[smallest]:
            smallest = left_idx
        if right_idx < heap_size and heap[right_idx] < heap[smallest]:
            smallest = right_idx
        if smallest == now_idx:
            break
        
        heap[now_idx], heap[smallest] = heap[smallest], heap[now_idx]
        now_idx = smallest

for i in range(N):
    x = int(sys.stdin.readline())
    
    if x == 0:
        if heap:
            print(heap[0])
            heap_pop()
        else:
            print(0)
    else:
        heap.append(x)
        heap_push()
