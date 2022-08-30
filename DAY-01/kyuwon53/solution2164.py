from collections import deque


def solution(N):
    card = deque([n for n in range(1, N + 1)])
    while len(card) > 1:
        card.popleft()
        move_card = card.popleft()
        card.append(move_card)
    return card[0]


def solution2(N):
    if N == 1:
        return 1
    card = deque([n for n in range(2, N + 1, 2)])

    if len(card) and N % 2 != 0:
        num = card.popleft()
        card.append(num)

    while len(card) > 1:
        card.popleft()
        move_card = card.popleft()
        card.append(move_card)
    return card[0]
