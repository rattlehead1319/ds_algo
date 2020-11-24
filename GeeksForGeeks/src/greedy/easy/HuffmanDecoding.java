package greedy.easy;

class MinHeapNode
{
    char data;
    int freq;
    MinHeapNode left, right, top;
    MinHeapNode(char c, int freq)
    {
        left = right = null;
        this.data = c;
        this.freq = freq;
    }
}

public class HuffmanDecoding {
    static String decodeHuffmanData(MinHeapNode root, String binaryString)
    {
        if (root == null) {
            return null;
        }

        String result = "";
        MinHeapNode current = root;
        for (int i = 0; i < binaryString.length(); i++) {

            if (binaryString.charAt(i) == '0') {
                current = current.left;
            } else if (binaryString.charAt(i) == '1') {
                current = current.right;
            }

            if (current.left == null && current.right == null) {
                result += Character.toString(current.data);
                current = root;
            }
        }
        return result;
    }
}
