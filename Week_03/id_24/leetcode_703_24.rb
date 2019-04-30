class KthLargest

=begin
    :type k: Integer
    :type nums: Integer[]
=end
    def initialize(k, nums)
        @k = k
        @nums = nums
        @size = nums.size
        @hash = nums.each do |num|
        end
    end


=begin
    :type val: Integer
    :rtype: Integer
=end
    def add(val)
      @nums = (@nums << val).sort
      @size += 1
      return @nums[@size-@k]
    end


end

# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest.new(k, nums)
# param_1 = obj.add(val)
