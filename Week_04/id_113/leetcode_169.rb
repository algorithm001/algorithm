# @param {Integer[]} nums
# @return {Integer}
def majority_element(nums)
  return nums[0] if nums.length == 1

  counter = {}
  z = 0
  m = 0
  nums.each do |n|
    if counter.key?(n)
      counter[n] += 1
      if counter[n] > m
        z = n
        m = counter[n]
      end
      next
    else
      counter[n] = 1
    end
  end

  z
end
