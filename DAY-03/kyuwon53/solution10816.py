N = input()
cards = list(map(int, input().split()))
M = input()
numbers = list(map(int, input().split()))

# 딕셔너리 만들기
# 카드를 순회하면서 딕셔너리에 해당 키가 있으면 value를 올려줌
dictionary = dict()
for card in cards:
    if card in dictionary:
        dictionary[card] += 1
    else:
        dictionary[card] = 1

for i in numbers:
    if i in dictionary:
        print(dictionary[i], end=' ')
    else:
        print(0, end=' ')
