package HashTable

//已通过
func IsAnagram(s string, t string) bool {
	if len(s) != len(t){
		return false
	}
	sb :=[]byte(s)
	collectionMap := map[byte]int{}
	for i := 0; i< len(sb);i++  {
		value,ok := collectionMap[sb[i]]
		if !ok {
			collectionMap[sb[i]] = 1
		}else{
			collectionMap[sb[i]] = value + 1
		}
	}

	st := []byte(t)
	for i := 0; i< len(st);i++  {
		value,ok := collectionMap[st[i]]
		if !ok {
			return false
		}else{
			if value == 0{
				return false
			}
			collectionMap[st[i]] = value - 1
		}
	}
	return true
}

func IsAnagram2(s string, t string) bool {
	tmpA,tmpB :=make([]int,26),make([]int,26)
	for i:=0;i<len(s);i++ {
		tmpA[s[i]-'a']++
	}
	for i:=0;i<len(t);i++ {
		tmpB[t[i]-'a']++
	}
	for i:=0;i<26;i++ {
		if tmpA[i] != tmpB[i] {
			return false
		}
	}
	return true
}