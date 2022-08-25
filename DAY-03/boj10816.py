# 10816 숫자 카드 2

n = int(input())
arr = list(map(int, input().split()))
m = int(input())
arr2 = list(map(int, input().split()))

dic = {}

for i in arr:
    if i in dic:
        dic[i] += 1
    else:
        dic[i] = 1

for i in arr2:
    if i in dic:
        print(dic[i], end=' ')
    else:
        print(0, end=' ')
