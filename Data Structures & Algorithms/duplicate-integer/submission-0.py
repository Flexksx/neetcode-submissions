class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        num_hashmap:dict[int,int] = {}
        for num in nums: 
            if num in num_hashmap.keys():
                return True
            num_hashmap[num]=0
        return False
        