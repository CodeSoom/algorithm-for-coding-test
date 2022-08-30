k = int(input())

for _ in range(k):
    n = int(input())
    clothes = {}
    for _ in range(n):
        name, cloth = input().split()
        if cloth in clothes:
            clothes[cloth] += 1
        else:
            clothes[cloth] = 1

    count = 1
    for value in clothes.values():
        count *= value + 1
    print(count - 1)
