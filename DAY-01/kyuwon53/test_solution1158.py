from unittest import TestCase
from solution1158 import solution


class Test(TestCase):
    def test_solution(self):
        result = [3, 6, 2, 7, 5, 1, 4]
        self.assertEqual(result, solution(7, 3))
