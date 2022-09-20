"""
예산
1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다.
상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다.

1번 요건을 충족하기 위해  입력값의 총 액이 예산보다 적으면 예산의 가장 큰 금액을 반환
총 액이 예산보다 크다면 예산의 평균값, 최저값, 최댓값으로 이진탐색.
이 때 예산의 최댓값보다 예산이 적으면 그냥 합하고 크면 최댓값으로 만든다.
"""


def get_budget(budgets, limit):
    max_budget = max(budgets)
    min_budget = 0

    while min_budget <= max_budget:
        mid_budget = (max_budget + min_budget) // 2
        total = 0
        for budget in budgets:
            if budget > mid_budget:
                total += mid_budget
            else:
                total += budget
        if total <= limit:
            min_budget = mid_budget + 1
        else:
            max_budget = mid_budget - 1

    return max_budget


def test_get_budget():
    assert get_budget([70, 80, 30, 40, 100], 450) == 100
    assert get_budget([120, 110, 140, 150], 485) == 127


test_get_budget()

n = int(input())
budgets = list(map(int, input().split()))
limit = int(input())
print(get_budget(budgets, limit))
