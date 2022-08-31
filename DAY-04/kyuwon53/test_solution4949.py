from unittest import TestCase
from solution4949 import isBalance


class Test(TestCase):
    def test_is_balance_올바른_소괄호만_있는_경우(self):
        self.assertEqual(isBalance("()"), True)

    def test_is_balance_올바른_대괄호만_있는_경우(self):
        self.assertEqual(isBalance("[]"), True)

    def test_is_balance_올바른_괄호만_있는_경우(self):
        self.assertEqual(isBalance("[( )]"), True)

    def test_is_balance_올바른_괄호_문자열이_있는_경우(self):
        self.assertEqual(isBalance("sf[ss( sfsdf)sdf]"), True)

    def test_is_balance_올바르지_않은_괄호의_짝개수가_다른_경우(self):
        self.assertEqual(isBalance("(()"), False)

    def test_is_balance_첫번째_괄호가_닫는_괄호인_경우(self):
        self.assertEqual(isBalance(")("), False)

    def test_is_balance_괄호가_짝이_안맞는_경우(self):
        self.assertEqual(isBalance("(]"), False)

    def test_is_balance_예시_첫번째(self):
        self.assertEqual(isBalance("So when I die (the [first] I will see in (heaven) is a score list)."), True)

    def test_is_balance_예시_두번째(self):
        self.assertEqual(isBalance("([ (([( [ ] ) ( ) (( ))] )) ])."), True)

    def test_is_balance_짝이_맞지_않는_괄호(self):
        self.assertEqual(isBalance("Help( I[m being held prisoner in a fortune cookie factory)]."), False)

    def test_is_balance_점(self):
        self.assertEqual(isBalance(".."), True)

    def test_is_balance_공백(self):
        self.assertEqual(isBalance("  "), True)

    def test_is_balance_짝(self):
        self.assertEqual(isBalance("[(()])."), False)

    def test_is_balance_괄호짝(self):
        self.assertEqual(isBalance("(])."), False)
