# 1764 듣보잡

n, m = map(int, input().split())
set_first = set()
set_second = set()

for i in range(n):
    set_first.add(input())

for i in range(m):
    set_second.add(input())

set_result = set.intersection(set_first, set_second)

set_final = sorted(set_result)

print(len(set_final))
for i in set_final:
    print(i)
