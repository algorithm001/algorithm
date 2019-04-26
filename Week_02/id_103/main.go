package main

import "fmt"

var temp = -1
func main() {
	change()
	fmt.Println(temp)
}

func change(){
	temp = 10
}
