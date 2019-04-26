from unittest import TestCase
from leetcodesupport import *
from solution import Solution


class TestSolution(TestCase):
    def setUp(self) -> None:
        self.solution = Solution()

    def test_findSecondMinimumValue_root_is_empty(self):
        root = string_to_tree_node("[]")
        self.assertEqual(-1, self.solution.findSecondMinimumValue(root))

    def test_findSecondMinimumValue_root_has_no_children(self):
        root = string_to_tree_node("[2]")
        self.assertEqual(-1, self.solution.findSecondMinimumValue(root))

    def test_findSecondMinimumValue_third_level_is_second_minimum(self):
        root = string_to_tree_node("[2, 2, 2, 3, 3, 3, 3]")
        self.assertEqual(3, self.solution.findSecondMinimumValue(root))

    def test_findSecondMinimumValue_result_is_2(self):
        root = string_to_tree_node("[2, 2, 2]")
        self.assertEqual(-1, self.solution.findSecondMinimumValue(root))

    def test_findSecondMinimumValue_result_is_2(self):
        root = string_to_tree_node("[1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4, 8, 3, 3, 1, 6, 2, 1]")
        self.assertEqual(2, self.solution.findSecondMinimumValue(root))

    def test_findSecondMinimumValue_result_is_3(self):
        root = string_to_tree_node("[2, 3, 4]")
        self.assertEqual(3, self.solution.findSecondMinimumValue(root))

    def test_findSecondMinimumValue_result_is_5(self):
        root = string_to_tree_node("[2,2,5,null,null,5,7]")
        self.assertEqual(5, self.solution.findSecondMinimumValue(root))

    def test_findSecondMinimumValue_result_is_5(self):
        root = string_to_tree_node("[5, 8, 5]")
        self.assertEqual(8, self.solution.findSecondMinimumValue(root))

    def test_dfs(self):
        root = string_to_tree_node("[1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4, 8, 3, 3, 1, 6, 2, 1]")
        self.solution.dfs(root)

