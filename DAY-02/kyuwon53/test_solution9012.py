from unittest import TestCase
from solution9012 import isValidPS


class Test(TestCase):
    yes = "YES"
    no = "NO"

    def test_is_valid_ps_return_yes_1(self):
        str = '(()())((()))'
        self.assertEqual(isValidPS(str), self.yes)

    def test_is_valid_ps_return_yes_2(self):
        str = '()()()()(()()())()'
        self.assertEqual(isValidPS(str), self.yes)

    def test_is_valid_ps_return_no_1(self):
        str = '(())())'
        self.assertEqual(isValidPS(str), self.no)

    def test_is_valid_ps_return_no_2(self):
        str = '(((()())()'
        self.assertEqual(isValidPS(str), self.no)

    def test_is_valid_ps_return_no_3(self):
        str = '((()()(()))(((())))()'
        self.assertEqual(isValidPS(str), self.no)

    def test_is_valid_ps_return_no_4(self):
        str = '(('
        self.assertEqual(isValidPS(str), self.no)

    def test_is_valid_ps_return_no_5(self):
        str = '))'
        self.assertEqual(isValidPS(str), self.no)

    def test_is_valid_ps_return_no_6(self):
        str = '())(()'
        self.assertEqual(isValidPS(str), self.no)
