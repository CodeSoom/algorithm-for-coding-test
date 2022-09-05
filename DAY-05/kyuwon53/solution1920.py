"""
정수가 존재하는지 알아내는 프로그램
예제
5
4 1 5 2 3
5
1 3 7 9 5

=>
1은 [4 1 5 2 3]에 존재 : 1
3은 [4 1 5 2 3]에 존재 : 1
7은 [4 1 5 2 3]에 없음 : 0
9는 [4 1 5 2 3]에 없음 : 0
5는 [4 1 5 2 3]에 존재 : 1

1. 입력 리스트에 존재하는지 in이면 1 not in 이면 0
2. 입력 리스트를 정렬하여 중간 값부터 점검 (이진탐색)
"""


def is_exist(target, numbers):
    """
    numbers에 target이 존재하면 True, 존재하지 않으면 False
    :param target: 검사할 수
    :param numbers: 대상 정수 리스트
    :return: numbers에 target이 존재하면 True, 존재하지 않으면 False
    """
    return target in numbers


def test_is_exist():
    assert is_exist(1, [1, 2, 3]) == True
    assert is_exist(1, [4, 2, 3]) == False


test_is_exist()


def binary_search(target, numbers):
    """
    이진 탐색을 이용해서 numbers에 target이 존재하는지 검사
    target보다 index 값이 더 크다면 index의 왼쪽에 target이 있는 것이므로 left_index와 index 중앙값으로  index 변경
    target보다 index 값이 더 작다면 index의 오른쪽에 target이 있는 것이므로 right_index와 index 중앙값으로 index변경
    left_index 가 right_index보다 커지면 없는거
    :param target:
    :param numbers:
    :return: 존재하면 True, 존재하지 않으면 False
    """
    left_index = 0

    right_index = len(numbers) - 1

    while True:
        index = (left_index + right_index) // 2
        if left_index > right_index:
            return False
        if target < numbers[index]:
            right_index = index - 1
        elif target > numbers[index]:
            left_index = index + 1
        elif target == numbers[index]:
            return True


def test_binary_search():
    # assert binary_search(1, [1, 4, 7, 23, 6, 8, 3, 9]) == True
    # assert binary_search(3, [6, 4, 2, 8, 5, 1]) == False
    assert binary_search(7, [4, 1, 5, 2, 3]) == False


test_binary_search()

n = int(input())
numbers = list(map(int, input().split()))
m = int(input())
targets = list(map(int, input().split()))

sorted_numbers = sorted(numbers) # 이진탐색에서는 정렬된 리스트가 필요
for target in targets:
    print(1 if binary_search(target, sorted_numbers) else 0)
