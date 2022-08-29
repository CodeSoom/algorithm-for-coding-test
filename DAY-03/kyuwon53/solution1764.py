N, M = map(int, input().split())
dictionary = dict()
result = []
for i in range(N):
    dictionary[input()] = 0
for i in range(M):
    name = input()
    if name in dictionary:
        result.append(name)
sorted_result = sorted(result)
print(len(sorted_result))
for s in sorted_result:
    print(s)
