package searching.easy;

class Pair
{
    public int first;
    public int second;
}
public class TwoRepeatedElements {
    public Pair twoRepeated(int arr[], int N){

        Pair p = new Pair();

        for (int i = 0; i < N+2; i++) {
            int abi = Math.abs(arr[i]);
            if (arr[abi] < 0 && p.first == 0) {
                p.first = Math.abs(arr[i]);
            } else if (arr[abi] < 0 && p.first != 0) {
                p.second = Math.abs(arr[i]);
            } else {
                arr[abi] = 0 - arr[abi];
            }
        }
        return p;
    }
}
