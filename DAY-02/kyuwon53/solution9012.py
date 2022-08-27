# 아이디어
# 스택에 괄호가 '(' 이면 집어 넣는다.
# 스택에 괄호가 ')' 라면 최근에 집어넣은 괄호가 '(' 이면 빼낸다.
#                     최근에 집어넣은 괄호가 없거나 ')'라면 return "NO"
# (()())((()))
# ( -> (( -> (() 제거 ( -> (( -> (() 제거 ( -> () 제거 -> ...
# 스택에 남아있는 괄호가 없다면 올바른 괄호 => YES 출력
# 스택에 남아있는 괄호가 있다면 올바르지 않은 괄호 => NO 출력

def isValidPS(parenthesis):
    stack = []

    for s in parenthesis:
        if s == '(':
            stack.append(s)
        elif s == ')':
            if len(stack) and stack[-1] == '(':
                stack.pop()
            else:
                return "NO"

    if len(stack) > 0:
        return "NO"
    return "YES"


# 백준 제출용으로 변경
# output을 따로
# 한번에 입력인거 같으니 list로 input을 받..?
n = int(input())
parenthesis = []
for _ in range(n):
    parenthesis.append(list(map(str, input().split()))[0])

for p in parenthesis:
    result = "YES"
    stack = []
    for s in p:
        if s == '(':
            stack.append(s)
        elif s == ')':
            if len(stack) and stack[-1] == '(':
                stack.pop()
            else:
                result = "NO"
                break

    if len(stack) > 0:
        result = "NO"
    print(result)
