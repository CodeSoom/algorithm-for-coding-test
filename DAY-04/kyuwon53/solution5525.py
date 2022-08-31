# 아이디어
# n을 받아서 해당 Pn을 만들고
# sentence의 처음부터 Pn의 길이만큼 비교
def solution(n, sentence):
    # Pn는 I 와 O가 번갈아가면서
    # 길이가 2n+1
    pn = 'I' + 'OI' * n
    count = 0
    i = 1

    while i < len(sentence) - 1:
        if sentence[i:i + len(pn)] == pn:
            count += 1
            while sentence[i + len(pn): i + len(pn) + 2] == 'OI':
                count += 1
                i += 2
            i += len(pn) - 1
        i += 1

    return count


# 백준 제출용
n = int(input())
m = input()
sentence = input()
print(solution(n, sentence))
