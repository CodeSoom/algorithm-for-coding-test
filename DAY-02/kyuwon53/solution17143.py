# 아이디어
# 문자열 뒤집기
# 단, 태그는 단어가 아니다
# 각 단어를 ...
# '<'라면 문자열에 바로 붙인다. flag를 써서 '>'이 나올때까지 결과에 붙임
# 리팩토링 필요
def reverseString(sentence):
    stack = []
    result = ''
    flag = False
    for s in sentence:
        if s == '<':
            result, stack = joinStack(result, stack, '')
            flag = True
        elif s == '>':
            result += s
            flag = False
            continue

        if flag:
            result += s
        elif s == ' ':
            result, stack = joinStack(result, stack, ' ')
        else:
            stack.append(s)

    result, stack = joinStack(result, stack, '')
    return result


def joinStack(result, stack, blank):
    stack.reverse()
    result += ''.join(stack) + blank
    stack = []
    return result, stack
