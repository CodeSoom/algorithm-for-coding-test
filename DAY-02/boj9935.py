# 9935 문자열 폭발

import sys

input = sys.stdin.readline

word = input().rstrip()
bomb = list(map(str, input().rstrip()))
arr = []

for i in word:
    arr.append(i)
    if i == bomb[-1]:
        if arr[len(arr) - len(bomb):] == bomb:
            for _ in range(len(bomb)):
                arr.pop()

if len(arr) == 0:
    print('FRULA')
else:
    for i in arr:
        print(i, end='')
