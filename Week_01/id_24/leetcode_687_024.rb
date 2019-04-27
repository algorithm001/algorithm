# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} root
# @return {Integer}
def longest_univalue_path(root)
  path_length = 0

  get_path_length(root)

  return path_length
end

def get_path_length(root)
  return 0 if root.nil?
  left_path_length = get_path_length(root.left)
  right_path_length = get_path_length(root.right)
  left_length, right_length = 0, 0

  if !root.left.nil? && root.left.val == root.val
    left_length = left_path_length + 1
  elsif !root.right.nil? && root.right.val == root.val
    right_length = right_path_length + 1
  end
  path_length = [path_length, (left_length  +  right_length)].max
  return  [left_length, right_length].max
end
