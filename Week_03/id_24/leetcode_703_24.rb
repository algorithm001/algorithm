class KthLargest

=begin
    :type k: Integer
    :type nums: Integer[]
=end
    def initialize(k, nums)
        @k = k
        if k > nums.size
           @max_nums = nums.sort
        else
           @max_nums = nums.sort[nums.size-k..nums.size]
        end
        #@nums = nums
        #@size = nums.size
        @k_value = @max_nums.first
    end


=begin
    :type val: Integer
    :rtype: Integer
=end
    def add(val)
     if @k_value.nil? || @max_nums.size < @k
         @max_nums = @max_nums.push(val).sort
         @k_value = @max_nums.first
         return @k_value
     end
     if val > @k_value
         @max_nums.delete_at 0
         @max_nums = @max_nums.push(val).sort
         @k_value = @max_nums.first
     end
      # puts "#{@max_nums}"
     return @k_value
    end


end

# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest.new(k, nums)
# param_1 = obj.add(val)
# 构建一个小顶堆大小为k，学习如何堆化，如何存储一个堆
# 利用数组存储堆，节点为i的位置，存储的左节点的位置为2*i，右节点的位置为2*i+1，堆化分为
# 从上往下和从下往上两种堆化方式.

# 堆来处理这个问题
class KthLargest

=begin
    :type k: Integer
    :type nums: Integer[]
=end
    def initialize(k, nums)
        @k = k
        @nums = []
        for num in nums
            add(num)
        end
    end


=begin
    :type val: Integer
    :rtype: Integer
=end
    def add(val)
        if @nums.size < @k
           @nums <<  val
           upbubble()
           if @nums.size < @k
            return nil
           end
        elsif val > @nums[0]
            @nums[0] = val
            downbubble()
        end
        return @nums[0]
    end

    def upbubble
        if @nums.size > 1
            i = @nums.size-1
            father =  (i-1)/2

        while i > 0 and @nums[i] < @nums[father]
            @nums[i], @nums[father] = @nums[father], @nums[i]
            i = father
            father = (i-1)/2
        end
    end
    end

    def downbubble
        if @k > 1
            i = 0
            while i <= (@k-2)/2
                left = 2 * i + 1
                right = [2 * i + 2, @k-1].min
                if @nums[left] <= @nums[right]
                    smaller = left
                else
                    smaller = right
                end
                if @nums[i] > @nums[smaller]
                    @nums[i], @nums[smaller] = @nums[smaller], @nums[i]
                    i = smaller
                else
                    break
                end
            end
        end
    end
end


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest.new(k, nums)
# param_1 = obj.add(val)
