<?php
/**
 * Created by PhpStorm.
 * User: yuanyunxu
 * Date: 19/5/2
 * Time: ÏÂÎç4:23
 */
class Solution {

    /**
     * @param String[][] $grid
     * @return Integer
     */
    function numIslands($grid) {
        $row = count($grid);
        if (empty($row)) {
            return 0;
        }
        $col = count($grid[0]);
        $res = 0;
        for ($i = 0; $i != $row; $i++) {
            for ($j = 0; $j != $col; $j++) {
                if ($grid[$i][$j] == 1) {
                    ++$res;
                    $this->dfs($i, $j, $grid, $row, $col);
                }
            }
        }
        return $res;
    }

    /**
     * @param $r
     * @param $c
     * @param $grid
     * @param $row
     * @param $col
     */
    private function dfs($r, $c, &$grid, $row, $col) {
        if ($r == $row ||
            $c == $col ||
            $r == -1 ||
            $c == -1 ||
            $grid[$r][$c] == 0 ||
            $grid[$r][$c] == 'm') {
            return;
        }
        $grid[$r][$c] = 'm';
        $this->dfs($r + 1, $c, $grid, $row, $col);
        $this->dfs($r, $c + 1, $grid, $row, $col);
        $this->dfs($r - 1, $c, $grid, $row, $col);
        $this->dfs($r, $c - 1, $grid, $row, $col);
        return;
    }
}