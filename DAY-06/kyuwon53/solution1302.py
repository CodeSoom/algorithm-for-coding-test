n = int(input())
d = dict()

for _ in range(n):
    key = input()
    if d.get(key):
        d[key] += 1
    else:
        d[key] = 1
sorted_d = sorted(d.items(), key=lambda item: (-item[1], item[0]))

print(sorted_d[0][0])
