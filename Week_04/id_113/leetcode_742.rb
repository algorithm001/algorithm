# @param {Integer[]} cost
# @return {Integer}
def min_cost_climbing_stairs(cost)
  m = []
  dp(cost.length, cost, m)
end

def dp(n, cost, m)
  return m[n] unless m[n].nil?
  return 0 if n == -1
  return cost[0] if n == 0

  c = n == cost.length ? 0 : cost[n]
  m[n] = c + min(dp(n - 1, cost, m), dp(n - 2, cost, m))
  m[n]
end

def min(*values)
  values.min
end
