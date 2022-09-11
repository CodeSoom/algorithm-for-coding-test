"""
ex)
2 4 -10 4 -9
=>
2 3 0 3 1

입력값의 원소 X1보다 작은 값을 출력 값으로 보여주면 된다.
예를 분석해보면,
첫번째 원소 2 보다 작은 원소는 2개 (-10,-9)
두번째 원소 4 보다 작은 원소는 3개 (2, -10, -9)
세번째 원소 -10보다 작은 원소는 0개
네번째 원소 4 보다 작은 원소는 3개 (2, -10, -9)
다섯번째 원소 -9 보다 작은 원소는 1개 (-9)이다.

따라서 해당 문제 해결 아이디어는
1. 딕셔너리로 만든다 ( 중복 제거, 검색 시간복잡도 )
2. 오름차순으로 정렬한다.
3. 해당 값의 인덱스가 압축 정렬 값이 된다.
"""


def coordinate_compression(coordinates):
    coordinate_set = sorted(set(coordinates))
    d = {key: i for i, key in enumerate(coordinate_set)}

    result = [str(d[coordinate]) for coordinate in coordinates]
    return ' '.join(result)


def test_coordianate_compression():
    assert coordinate_compression([2, 4, -10, 4, -9]) == '2 3 0 3 1'


test_coordianate_compression()

n = int(input())
coordinates = list(map(int, input().split()))

print(coordinate_compression(coordinates))
