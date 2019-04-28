func isAnagram(s string, t string) bool {
    if len(s) < len(t){
        s,t = t,s
    }
    smap := make(map[rune]uint8)
    tmap := make(map[rune]uint8)
    for _,ss := range s {
        smap[ss]++
    }
    for _,tt := range t {
        tmap[tt]++
    }
    for k, _ := range smap {
        if tmap[k] != smap[k] {
            return false
        }
    }
    return true
}
