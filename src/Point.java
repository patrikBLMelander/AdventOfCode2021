/**
 * Created by Patrik Melander
 * Date: 2021-12-13
 * Time: 21:29
 * Project: AdventOfCode2021
 * Copyright: MIT
 */
public class Point {
    public int row;
    public int col;

    public Point(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row && col == point.col;
    }
}
