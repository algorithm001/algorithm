class TrieNode:
    def __init__(self, data):
        self.data = data
        self.isEnding = False
        self.children = [None] * 26

class Solution:
    def longestWord(self, words):
        words = sorted(words)
        longest_word = None
        root = TrieNode("/")
        for i in range(len(words)):
            word = words[i]
            if not longest_word:
                longest_word = word
            p = root
            length_of_word = len(word)
            word_is_valid = True
            for j in range(length_of_word):
                index = ord(word[j]) - ord("a")
                if not p.children[index] and j == length_of_word - 1:
                    p.children[index] = TrieNode(word[j])
                elif not p.children[index]:
                    word_is_valid = False
                    break
                p = p.children[index]
            if len(word) > len(longest_word) and word > longest_word and word_is_valid:
                longest_word = word
        return longest_word
