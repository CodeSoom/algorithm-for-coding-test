# 17413 단어 뒤집기 2

N = input().rstrip()

openTag = False
check = []
result = ''

for i in range(len(N)):
    if N[i] == '<':
        check.reverse()
        result += ''.join(check)
        check = []
        openTag = True
        result += N[i]
    elif N[i] == '>':
        openTag = False
        result += N[i]
    else:
        if openTag is True:
            result += N[i]
        else:
            if N[i] == ' ':
                check.reverse()
                result += ''.join(check)
                result += ' '
                check = []
            else:
                check.append(N[i])

check.reverse()
result += ''.join(check)
check = []

print(result)
