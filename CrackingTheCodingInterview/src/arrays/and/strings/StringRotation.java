package arrays.and.strings;

public class StringRotation {
    boolean checkRotation(String str1, String str2) {
        /**
         *  waterbottle
         *  erbottlewat
         *  trick is to concatenate the same string
         *  erbottlewat + erbottlewat will have waterbottle as substring
         **/
        return isSubstring(str1 + str1, str2);
    }

    boolean isSubstring(String str1, String str2) {
        return true;
    }
}
