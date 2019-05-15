func longestWord(s string) string {
    best, length := "", 0
    for _, word := range strings.Split(s, " ") {
        if len(word) > length {
            best, length = word, len(word)
        }
    }
    return best
}
