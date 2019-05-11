# 递归删除
def delete_duplicates(head)
    if head.nil? || head.next.nil?
        return head
    end
    
   head.next = delete_duplicates(head.next)
   if head.val == head.next.val 
       head = head.next
   end
    return head
end
# 常规思路
# 注意边界条件
def delete_duplicates(head)
      if head.nil? || head.next.nil?
        return head
    end
    current = head
  while !current.nil? && !current.next.nil? do
      if current.val == current.next.val
        current.next = current.next.next
      else
        current = current.next
      end
  end
    return head
end
