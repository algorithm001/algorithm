class Solution:
    def findJudge(self, n, trusts):
        if n == 1 and len(trusts) == 0:
            return 1
        followers = [None] * (n + 1)
        followings = [None] * (n + 1)
        for trust in trusts:
            person = trust[0]
            following = trust[1]
            if not followings[person]:
                followings[person] = []
            followings[person].append(following)
            if not followers[following]:
                followers[following] = []
            followers[following].append(person)
        for i in range(1, n + 1):
            follower = followers[i]
            following = followings[i]
            if following or not follower:
                continue
            if len(follower) == n - 1:
                return i
        return -1


