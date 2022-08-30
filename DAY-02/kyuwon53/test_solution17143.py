from unittest import TestCase
from solution17143 import reverseString


class Test(TestCase):
    def test_reverse_string(self):
        sentence = "baekjoon online judge"
        result = "noojkeab enilno egduj"
        self.assertEqual(reverseString(sentence), result)

    def test_reverse_string_with_tag(self):
        sentence = "<open>tag<close>"
        result = "<open>gat<close>"
        self.assertEqual(reverseString(sentence), result)

    def test_reverse_string_with_tag_blank(self):
        sentence = "<ab cd>ef gh<ij kl>"
        result = "<ab cd>fe hg<ij kl>"
        self.assertEqual(reverseString(sentence), result)

    def test_reverse_string_with_digit(self):
        sentence = "one1 two2 three3 4fourr 5five 6six"
        result = "1eno 2owt 3eerht rruof4 evif5 xis6"
        self.assertEqual(reverseString(sentence), result)

    def test_reverse_string_with_tag_digit_blank(self):
        sentence = "<int><max>2147483647<long long><max>9223372036854775807"
        result = "<int><max>7463847412<long long><max>7085774586302733229"
        self.assertEqual(reverseString(sentence), result)

    def test_reverse_string_with_tag_digit_blank_(self):
        sentence = "<problem>17413<is hardest>problem ever<end>"
        result = "<problem>31471<is hardest>melborp reve<end>"
        self.assertEqual(reverseString(sentence), result)

    def test_reverse_string_with_tag_blank_(self):
        sentence = "<   space   >space space space<    spa   c e>"
        result = "<   space   >ecaps ecaps ecaps<    spa   c e>"
        self.assertEqual(reverseString(sentence), result)
