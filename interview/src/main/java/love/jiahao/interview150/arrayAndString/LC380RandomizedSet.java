package love.jiahao.interview150.arrayAndString;

import java.util.*;

/**
 * <big>O1时间插入、删除、获取随机元素</big>
 * <p>使用list集合来存放数据、map存放值以及对应的索引</p>
 *
 * @author 13684
 * @date 2024/3/16
 */
public class LC380RandomizedSet { // 96 59
    List<Integer> nums; // 保存数据的集合
    Map<Integer, Integer> indices; // key 为值 value 为索引
    Random random; // 生成随机数

    public LC380RandomizedSet() {
        nums = new ArrayList<Integer>();
        indices = new HashMap<Integer, Integer>();
        random = new Random();
    }

    /*
        首先判断map中的key也就是集合中的值是否存在，
        如果存在直接返回false
        不存在则将值添加进去，并put到map中key为添加的值，value为添加前的List的size
     */
    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    /*
        首先判断要移除的元素是否存在
        得到当前数值索引
        将最后一个元素的值替换到当前数值索引
        保存到map
        移除map原来的
        移除集合最后一个元素
     */
    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }

        int index = indices.get(val); // 得到当前数值的索引
        int last = nums.get(nums.size() - 1); // 找到最后一个元素的值
        nums.set(index, last); // 将索引处设置为最后一位元素的值
        indices.put(last, index); // 保存到map集合
        nums.remove(nums.size() - 1); // 移除集合最后一个元素
        indices.remove(val); // 移除map集合中对应的键值
        return true;
    }

    public int getRandom() {
        int i = random.nextInt(nums.size());
        return nums.get(i);
    }

}
