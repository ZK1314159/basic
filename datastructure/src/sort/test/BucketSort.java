package sort.test;

class BucketSort {
    private void bucket(int[] data) {
        int n = data.length;
        int bask[][] = new int[10][n];
        int index[] = new int[10];
        int max = Integer.MIN_VALUE;
        for (int i : data) {
            max = max > (Integer.toString(i).length()) ? max : (Integer.toString(i).length());
        }
        String str;
        for (int i = max - 1; i >= 0; i--) {
            for (int j : data) {
                str = "";
                if (Integer.toString(j).length() < max) {
                    for (int k = 0; k < max - Integer.toString(j).length(); k++)
                        str += "0";
                }
                str += Integer.toString(j);
                bask[str.charAt(i) - '0'][index[str.charAt(i) - '0']++] = j;
            }
            int pos = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < index[j]; k++) {
                    data[pos++] = bask[j][k];
                }
            }
            for (int x = 0; x < 10; x++)
                index[x] = 0;
        }
    }

    public static void main(String[] args) {
        BucketSort sort = new BucketSort();
        int[] in = {12, 23, 34, 1, 343, 549387, 473827483, 438478347, 2323, 74384};
        sort.bucket(in);
        for (int i : in) {
            System.out.println(i);
        }
    }
}
