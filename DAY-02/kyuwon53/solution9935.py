def solution(sentence, bomb):
    stack = []
    result = 'FRULA'
    n = len(bomb)

    for s in sentence:
        stack.append(s)
        if stack[-n:] == list(bomb):
            del stack[-n:]

    if len(stack):
        result = ''.join(stack)
    return result

# 백준 제출용
# sentence = input()
# bomb = input()
# stack = []
# n = len(bomb)
# result = 'FRULA'
# for s in sentence:
#     stack.append(s)
#     if stack[-n:] == list(bomb):
#         del stack[-n:]
#
# if len(stack):
#     result = ''.join(stack)
# print(result)
