package love.jiahao.interview150.hashTable;


/**
 * <big>赎金信</big>
 *
 * @author 13684
 * @date 2024/3/27
 */
public class LC383CanConstruct {
    /*
        由于全是小写字符所以就采用hash表的思想，
        将提供者对应的位置++
        消费者对应的位置--，
        如果减到小于零则不能构成
     */
    public boolean canConsConstruct(String ransomNote, String magazine) {    // 99 51
        int[] array = new int[26];
        char[] magazineCharArray = magazine.toCharArray();
        for (char c : magazineCharArray) {
            array[c - 97]++;
        }

        char[] ransomNoteCharArray = ransomNote.toCharArray();
        for (char c : ransomNoteCharArray) {
            array[c - 97]--;
            if (array[c - 97] < 0) {
                return false;
            }
        }

        return true;
    }
}
