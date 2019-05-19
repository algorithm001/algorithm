# @param {Integer[]} a
# @return {Integer[]}
def sort_array_by_parity(a)
    if a.length < 2
        return a
    end

    left = []
    right = []
    a.length.times.each do
        if a[0].even?
            left << a.delete_at(0)
        else
            right << a.delete_at(0)
        end
    end
    a = left + right
end
