package problems.easy.mathematics;

public class ExcelSheetColumn {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int x = columnNumber % 26;
            if (columnNumber == 26) { //this is tricky
                sb.append('Z');
                break;
            } else if (x == 0) {
                sb.append('Z');
                columnNumber--; // trickiest
            } else {
                sb.append((char)(x + 64));
            }
            columnNumber = columnNumber/26;
        }

        return sb.reverse().toString();
    }
}
