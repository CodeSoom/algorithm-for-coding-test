# 4949 균형잡힌 세상

import sys

input = sys.stdin.readline


while True:
    arr = []
    text = input().rstrip()
    confirm = 0
    for i in range(len(text)):
        if text[i] == '(':
            arr.append(1)
        elif text[i] == ')':
            if len(arr) == 0 or arr[-1] == 2:
                confirm = 1
                break
            if arr[-1] == 1:
                arr.pop()
        elif text[i] == '[':
            arr.append(2)
        elif text[i] == ']':
            if len(arr) == 0 or arr[-1] == 1:
                confirm = 1
                break
            if arr[-1] == 2:
                arr.pop()

    if text == '.':
        break

    if len(arr) == 0 and confirm == 0:
        print('yes')
    else:
        print('no')
