# 9012 괄호

T = int(input())

for i in range(T):
    a = input()
    count = 0
    for j in range(len(a)):
        if a[j] == '(':
            count += 1
        elif a[j] == ')':
            count -= 1
        if count < 0:
            print('NO')
            break
    if count == 0:
        print('YES')
    elif count > 0:
        print('NO')
