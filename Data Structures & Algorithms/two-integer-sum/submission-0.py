class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numbers_differences:dict[int,int]={}
        for i in range(0, len(nums)):
            num = nums[i]
            print(num)
            needed_number = target - num
            print(needed_number)
            if needed_number not in numbers_differences:
                print(f"Adding {num} with index {i}")
                numbers_differences[num]=i
            else:
                needed_index = numbers_differences[needed_number]
                if i< needed_index:
                    return [i,needed_index]
                return [needed_index,i]
            
        return [] 