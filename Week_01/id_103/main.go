package main

import "fmt"

func main() {
	a := &struct {}{}
	a2 := struct {}{}
	b2 := struct {}{}
	b := &struct {}{}
	fmt.Println(&a,&b)
	fmt.Println(a == b)
	fmt.Println(a2,b2)
	fmt.Println(a2 == b2)
}
