def max_cable(cables, n):
    max_len = max(cables)
    min_len = 1

    count = 0
    while min_len <= max_len or count < n:
        mid_len = (max_len + min_len) // 2
        count = 0
        for cable in cables:
            count += cable // mid_len
        # 카운트가 n보다 크다는 것은 케이블 길이를 더 늘려도 된다는 말
        if count >= n:
            min_len = mid_len + 1
        elif count < n:
            max_len = mid_len - 1

    return max_len


# def test_max_cable():
#     assert max_cable([802, 743, 457, 539], 11) == 200
#
#
# test_max_cable()

k, n = map(int, input().split())
cables = []
for _ in range(k):
    cables.append(int(input()))

print(max_cable(cables, n))
