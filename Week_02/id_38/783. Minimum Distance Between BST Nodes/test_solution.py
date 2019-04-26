from unittest import TestCase
from leetcodesupport import *
from solution import Solution
from collections import deque

class TestSolution(TestCase):
    def setUp(self) -> None:
        self.solution = Solution()

    def test_minDiffInBST_invalid_empty(self):
        root = string_to_tree_node("[]")
        self.assertIsNone(None, self.solution.minDiffInBST(root))

    def test_minDiffInBST_invalid_one_node(self):
        root = string_to_tree_node("[1]")
        self.assertIsNone(None, self.solution.minDiffInBST(root))

    def test_minDiffInBST_result_1(self):
        root = string_to_tree_node("[4,2,6,1,3,null,null]")
        self.assertEqual(1, self.solution.minDiffInBST(root))

    def test_minDiffInBST_result_2(self):
        root = string_to_tree_node("[4,2,6]")
        self.assertEqual(2, self.solution.minDiffInBST(root))

    def test_minDiffInBST_result_6(self):
        root = string_to_tree_node("[27,null,34,null,58,50,null,44,null,null,null]")
        self.assertEqual(6, self.solution.minDiffInBST(root))




    # def test_in_order(self):
    #     root = string_to_tree_node("[4,2,6,1,3,null,null]")
    #     self.solution.in_order(root)

