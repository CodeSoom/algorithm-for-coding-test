from unittest import TestCase
from solution5525 import solution


class Test(TestCase):
    def test_solution_1(self):
        n = 1
        sentence = "OOIOIOIOIIOII"
        self.assertEqual(solution(n, sentence), 4)

    def test_solution_2(self):
        n = 2
        sentence = "OOIOIOIOIIOII"
        self.assertEqual(solution(n, sentence), 2)
