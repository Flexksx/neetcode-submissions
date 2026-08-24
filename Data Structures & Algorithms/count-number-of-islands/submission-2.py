from collections import deque
from typing import List

_WATER_CELL: str = "0"
_LAND_CELL: str = "1"


def is_land(grid: List[List[str]], coordinates: tuple[int, int]) -> bool:
    return grid[coordinates[0]][coordinates[1]] == _LAND_CELL


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid or not grid[0]:
            return 0

        island_counter: int = 0
        visited: set[tuple[int, int]] = set()

        rows = len(grid)
        cols = len(grid[0])
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        for row in range(rows):
            for col in range(cols):
                if (row, col) in visited:
                    continue

                current_value: str = grid[row][col]

                if current_value == _WATER_CELL:
                    continue

                if current_value == _LAND_CELL:
                    island_counter += 1
                    visited.add((row, col))

                    queue = deque([(row, col)])

                    while queue:
                        curr_row, curr_col = queue.popleft()

                        for dir_row, dir_col in directions:
                            nr = curr_row + dir_row
                            nc = curr_col + dir_col

                            if 0 <= nr < rows and 0 <= nc < cols:
                                neighbor_coord = (nr, nc)

                                if neighbor_coord in visited:
                                    continue

                                if is_land(grid, neighbor_coord):
                                    visited.add(neighbor_coord)
                                    queue.append(neighbor_coord)

        return island_counter
