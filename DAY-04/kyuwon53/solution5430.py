from collections import deque


def solution(functions, array):
    """
    배열의 초기값과 수행할 함수가 주어졌을 때 각 함수를 수행 후 최종 결과를 리턴
    R(뒤집기) : 배열에 있는 수의 순서를 뒤집는다.
            => R 생성 때마다 reverse하면 시간 초과
            => R이 짝수번 나오면 그대로이기 때문에 총 합이 홀수이면 뒤집는다.
    D(버리기) : 첫 번째 수를 버리고 배열이 비어있으면 에러를 발생
            => R이 홀수 번일 때는 뒤집힌 것이기 때문에 pop
            => R이 짝수 번일 때는 원래로 돌아오기 때문에 popleft
    :param functions: 수행할 함수 조합
    :param array: 정수 배열 초기값
    :return: 결과
    """
    queue = deque()
    for i in array:
        queue.append(i)

    cnt = 0

    for f in functions:
        if f == 'R':
            cnt += 1
        if f == 'D':
            if queue:
                if cnt % 2 == 0:
                    queue.popleft()
                else:
                    queue.pop()
            else:
                return "error"
    if cnt % 2 == 1:
        queue.reverse()
    return list(map(str, queue))


def test_solution():
    """
    전체 코드 테스트
    :return:
    """
    assert solution('RDD', [1, 2, 3, 4]) == ['2', '1']


test_solution()

n = int(input())
for i in range(n):
    fn = input()
    k = int(input())
    # 입력받은 리스트 형태의 문자열을 리스트로 변환
    # [,]를 제거 ','로 문자열을 자르고 리스트로 변환한다.
    # k = 0 일 경우 split 오류가 나기때문에 괄호가 제거
    arr = list(map(int, input()[1:-1].split(','))) if k != 0 else input()[1:-1]

    result = solution(fn, arr)
    if result == 'error':
        print(result)
    else:
        print('[' + ','.join(result) + ']')
