from unittest import TestCase
from solution9935 import solution


class Test(TestCase):
    def test_solution(self):
        sentence = 'mirkovC4nizCC44'
        bomb = 'C4'
        result = 'mirkovniz'
        self.assertEqual(solution(sentence, bomb), result)

    def test_solution_all(self):
        sentence = '12ab112ab2ab'
        bomb = '12ab'
        result = 'FRULA'
        self.assertEqual(solution(sentence, bomb), result)
