# 1158 요세푸스 문제

import sys
input = sys.stdin.readline
from collections import deque

N, K = map(int, input().split())
queue = deque()
array = []

for i in range(1, N+1):
    queue.append(str(i))

while queue:
    for i in range(K-1):
        now = queue.popleft()
        queue.append(now)
    array.append(queue.popleft())

print('<' + ', '.join(array) + '>')
