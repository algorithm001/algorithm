class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        dd = {}
        for path in paths:
            plist = path.split(" ")
            prefix = plist[0];
            for i in range(1, len(plist)):
                route = prefix + "/" + plist[i].split("(")[0]
                content = plist[i].split("(")[1].split(")")[0]
                if content not in dd:
                    dd[content] = []
                dd[content].append(route)
                    
        res = []
        for key in dd:
            if len(dd[key]) > 1:
                res.append(dd[key])
        
        return res
