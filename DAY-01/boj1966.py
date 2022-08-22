# 1966 프린터 큐

from collections import deque

a = int(input())

for i in range(a):
    queue = deque()
    count = 0
    n, m = map(int, input().split())
    arr = list(map(int, input().split()))
    for j in arr:
        queue.append(j)
    while True:
        if queue[0] == max(queue):
            queue.popleft()
            count += 1
            if m == 0:
                break
            else:
                m -= 1
        else:
            queue.append(queue.popleft())
            if m == 0:
                m = len(queue)-1
            else:
                m -= 1
    print(count)
