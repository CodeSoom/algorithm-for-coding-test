# 5525 IOIOI

import sys

input = sys.stdin.readline

n = int(input())
m = int(input())
s = input()

result = 0
count = 0

for i in range(len(s)):
    if s[i] == 'O' and count % 2 == 1:
        count += 1
    elif s[i] == 'O' and count % 2 == 0:
        count = 0
    elif s[i] == 'I' and count % 2 == 0:
        count += 1
    elif s[i] == 'I' and count % 2 == 1:
        count = 1
    if count == ((n * 2) + 1):
        result += 1
        count = (n * 2) - 1

print(result)
