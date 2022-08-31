def isBalance(sentence):
    # 여는 괄호 ( [ 가 들어오면 stack에 담는다.
    # 짝이 안맞는 경우를 위해 닫는 경우는 비교를 따로 분류한다.
    # 스택으로 모든 문자열을 보기보단, 정규식?

    stack = []
    for s in sentence:
        if not stack and (s == ')' or s == ']'):
            return False
        if s == '(' or s == '[':
            stack.append(s)
        elif stack:
            if (stack[-1] == '(' and s == ')') or stack[-1] == '[' and s == ']':
                stack.pop()
            elif (stack[-1] == '(' and s == ']') or stack[-1] == '[' and s == ')':
                return False
    if stack:
        return False
    return True


while True:
    sentence = input()
    if sentence == '.':
        break
    result = "yes" if isBalance(sentence) else "no"
    print(result)
