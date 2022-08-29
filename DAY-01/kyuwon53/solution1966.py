n, m = map(int, input().split())
priorities = list(map(int, input().split()))
queue = [(i, p) for i, p in enumerate(priorities)]
answer = 0
print(queue)
while True:
    cur = queue.pop(0)
    if any(cur[1] < q[1] for q in queue):
        queue.append(cur)
    else:
        answer += 1
        if cur[0] == m:
            print(answer)
            break
