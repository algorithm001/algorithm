class Solution(object):

    def detectCycle(self, head):
        if not head:
            return None
        node_in_cycle = self.meeting_node(head)
        if not node_in_cycle:
            return None

        cycle_length = 1
        temporary_node_in_cycle = node_in_cycle.next
        while temporary_node_in_cycle:
            if temporary_node_in_cycle == node_in_cycle:
                break
            temporary_node_in_cycle = temporary_node_in_cycle.next
            cycle_length += 1

        first_pointer = head
        for i in range(0, cycle_length):
            first_pointer = first_pointer.next
        second_pointer = head
        while True:
            if first_pointer == second_pointer:
                return second_pointer
            first_pointer = first_pointer.next
            second_pointer = second_pointer.next

    def meeting_node(self, head):
        if not head:
            return None
        slow_pointer = head.next
        if not slow_pointer:
            return None
        fast_pointer = slow_pointer.next
        while slow_pointer and fast_pointer:
            if slow_pointer == fast_pointer:
                return fast_pointer
            slow_pointer = slow_pointer.next
            fast_pointer = fast_pointer.next
            if fast_pointer:
                fast_pointer = fast_pointer.next
        return None
