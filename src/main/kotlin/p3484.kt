package p3484

class Spreadsheet(rows: Int) {

    private var arr: Array<Array<Int>> = Array(rows + 1) {
        Array(26) {
            0
        }
    }

    fun setCell(cell: String, value: Int) {
        val (row, col) = calcPosition(cell)
        arr[row][col] = value
    }

    fun resetCell(cell: String) {
        val (row, col) = calcPosition(cell)
        arr[row][col] = 0
    }

    fun getValue(formula: String): Int {
        val (left, right) = formula.replace("=", "").split("+")
        return getNumber(left) + getNumber(right)
    }

    private fun getCellValue(cell: String): Int {
        val (row, col) = calcPosition(cell)
        return arr[row][col]
    }

    private fun calcPosition(cell: String): Pair<Int, Int> {
        val col = cell[0] - 'A'
        val row = cell.substring(1).toInt()
        return Pair(row, col)
    }

    private fun getNumber(cell: String): Int {
        return cell.toIntOrNull() ?: getCellValue(cell)
    }
}
