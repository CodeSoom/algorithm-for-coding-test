# 패션왕 신해빈

import sys

input = sys.stdin.readline

T = int(input())

for i in range(T):
    n = int(input())
    dic = {}
    for j in range(n):
        a, b = map(str, input().split())
        if b not in dic:
            dic[b] = 0
        dic[b] += 1
    result = 1

    for j in range(len(dic.values())):
        result *= (list(dic.values())[j] + 1)

    print(result - 1)
