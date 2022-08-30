def solution(N, K):
    q = [n for n in range(1, N + 1)]
    result = []
    index = 0
    for i in range(N):
        index += K - 1
        index %= len(q)
        result.append(str(q.pop(index)))
    print('<' + ','.join(list(map(str, result))) + '>')
    return result


from collections import deque


def solution2(N, K):
    q = deque([n for n in range(1, N + 1)])
    result = []
    while q:
        for _ in range(K - 1):
            num = q.popleft()
            q.append(num)
        result.append(q.popleft())
    print('<' + ', '.join(list(map(str, result))) + '>')
    return result
