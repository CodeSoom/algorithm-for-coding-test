# 5430 AC

import sys
from collections import deque

input = sys.stdin.readline

T = int(input())

for i in range(T):
    p = list(map(str, input().rstrip()))
    n = int(input())
    try:
        arr = deque(list(map(int, input()[1:-2].split(','))))
    except:
        arr = deque([])
    arrow = 1
    error = 0
    for j in p:
        if j == 'R':
            arrow *= -1
        elif j == 'D':
            if len(arr) == 0:
                print('error')
                error = 1
                break
            elif arrow == 1:
                arr.popleft()
            elif arrow == -1:
                arr.pop()
    if arrow == 1 and len(arr) != 0:
        result = '['
        for j in range(len(arr)):
            result += str(arr[j])
            if j != len(arr)-1:
                result += ','
        result += ']'
        print(result)
    elif arrow == -1 and len(arr) != 0:
        arr.reverse()
        result = '['
        for j in range(len(arr)):
            result += str(arr[j])
            if j != len(arr) - 1:
                result += ','
        result += ']'
        print(result)
    elif len(arr) == 0 and error == 0:
        print([])
