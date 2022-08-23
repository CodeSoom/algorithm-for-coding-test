from unittest import TestCase
from solution2164 import solution
from solution2164 import solution2


class Test(TestCase):
    def test_solution4(self):
        self.assertEqual(4, solution(4))

    def test_solution6(self):
        self.assertEqual(4, solution(6))

    def test_solution1(self):
        self.assertEqual(1, solution(1))

    def test_solution2(self):
        self.assertEqual(2, solution(2))

    def test_solution10(self):
        self.assertEqual(4, solution(10))

    def test_solution9(self):
        self.assertEqual(2, solution(9))

    def test_solution12(self):
        self.assertEqual(8, solution(12))

    def test_solution14(self):
        self.assertEqual(12, solution(14))

    def test_solution124(self):
        self.assertEqual(120, solution(124))

    def test_solution2_4(self):
        self.assertEqual(4, solution2(4))

    def test_solution2_6(self):
        self.assertEqual(4, solution2(6))

    def test_solution2_1(self):
        self.assertEqual(1, solution2(1))

    def test_solution2_2(self):
        self.assertEqual(2, solution2(2))

    def test_solution2_8(self):
        self.assertEqual(8, solution2(8))

    def test_solution2_10(self):
        self.assertEqual(4, solution2(10))

    def test_solution2_9(self):
        self.assertEqual(2, solution2(9))

    def test_solution2_12(self):
        self.assertEqual(8, solution2(12))

    def test_solution2_14(self):
        self.assertEqual(12, solution2(14))

    def test_solution2_124(self):
        self.assertEqual(120, solution2(124))
