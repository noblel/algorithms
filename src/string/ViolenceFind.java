package string;

/**
 * 暴力子字符串查找
 * 最坏的情况在长度为N的文本中查找长度为M的模式要~NM次(M(N-M+1))字符串比较
 *
 * @author Noblel
 */
class ViolenceFind {

    /**
     * 采用依次比对的方式
     * @param pat 查找的子字符串
     * @param txt 源字符串
     * @return 匹配的字符串位置
     */
    public static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i+j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == M) {
                //找到匹配
                return i;
            }
        }
        //未找到匹配
        return N;
    }

    /**
     * 显式回退，对于比较过的不再比较
     * @param pat 查找的子字符串
     * @param txt 源字符串
     * @return 匹配的字符串位置
     */
    public static int backSearch(String pat, String txt) {
        int j, M = pat.length();
        int i, N = txt.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) {
            //找到匹配
            return i - M;
        } else {
            //未找到匹配
            return N;
        }
    }
}
