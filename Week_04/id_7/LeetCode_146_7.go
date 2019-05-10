package geekcode

import (
	"container/list"
)

type CacheItem struct {
	key   int
	value interface{}
}

type LRUCache struct {
	dlist    *list.List
	mapItems map[int]*list.Element
	capacity int
}

func Constructor(max int) LRUCache {
	l := LRUCache{}
	l.capacity = max
	l.Init()
	return l
}

func (self *LRUCache) Init() {
	self.dlist = new(list.List)
	self.mapItems = make(map[int]*list.Element)
}

// 插入新数据的时候，对列表的操作需要注意:
// 如果插入后，列表将满，那么先删除元素，再做插入
func (self *LRUCache) Put(key int, value interface{}) {
	if v, ok := self.mapItems[key]; ok && v != nil {
		v.Value.(*CacheItem).value = value
		self.dlist.MoveToFront(v)
	} else {
		i := &CacheItem{key: key, value: value}
		self.mapItems[key] = self.dlist.PushFront(i)
		self.Reduce()
	}
}

func (self *LRUCache) Len() int {
	return self.dlist.Len()
}

//获取数据以后，
//数据移动顺序和插入，更新数据时候移动的方向是一致的
func (self *LRUCache) Get(key int) interface{} {
	n := self.mapItems[key]
	if n != nil {
		self.dlist.MoveToFront(n)
		return n.Value.(*CacheItem).value
	} else {
		return -1
	}
}

func (self *LRUCache) Reduce() {
	if self.Len() > self.capacity {
		n := self.dlist.Back()
		if n != nil {
			mapKey := n.Value.(*CacheItem).key
			delete(self.mapItems, mapKey)
			self.dlist.Remove(n)
		}
	}
}
