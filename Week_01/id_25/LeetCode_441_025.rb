# @param {Integer} n
# @return {Integer}
def arrange_coins(n)
  low = 0
  high = n
  loop do
    k = ((low+high)/2).ceil
    if k * (k + 1)/2 == n
      return k
      break
    elsif k * (k + 1)/2 > n && (k -1) * k / 2 < n
      return k - 1
      break
    elsif low > high
      return -1
      break
    elsif k * (k + 1)/2 > n
      high = k - 1
    else k * (k + 1)/2 < n
      low = k + 1
    end
  end
end
