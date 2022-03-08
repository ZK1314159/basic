package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description：<br>
 * LeetCode 638. 大礼包
 * 在 LeetCode 商店中， 有 n 件在售的物品。每件物品都有对应的价格。然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 * 给你一个整数数组 price 表示物品价格，其中 price[i] 是第 i 件物品的价格。另有一个整数数组 needs 表示购物清单，
 * 其中 needs[i] 是需要购买第 i 件物品的数量。
 * 还有一个数组 special 表示大礼包，special[i] 的长度为 n + 1 ，其中 special[i][j] 表示第 i 个大礼包中内含第 j 件物品的数量，
 * 且 special[i][n] （也就是数组中的最后一个整数）为第 i 个大礼包的价格。
 * 返回确切满足购物清单所需花费的最低价格，你可以充分利用大礼包的优惠活动。你不能购买超出购物清单指定数量的物品，即使那样会降低整体价格。
 * 任意大礼包可无限次购买。
 * <br>
 * CreateDate：2021/10/28 20:25 <br>
 */
public class ShoppingOffer {

    // 考虑剔除同等配置但是价格高一点的，算法里没有
    // 剔除实际上没有优惠的大礼包
    // 考虑剔除比直接购买价格更高的大礼包, 算法里没有
    // 考虑剔除用不到的大礼包
    // 不同大礼包的优惠程度不同，可以排序或者分级，算法里没有
    // 普通商品也是大礼包只是优惠力度为0
    // 算法思想基本对，但是缺少账本的记录，官方答案的map<List<Integer>, Integer>的写法值得借鉴

    Map<List<Integer>, Integer> memo = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();

        // 过滤不需要计算的大礼包，只保留需要计算的大礼包
        List<List<Integer>> filterSpecial = new ArrayList<>();
        for (List<Integer> sp : special) {
            int totalCount = 0, totalPrice = 0;
            for (int i = 0; i < n; i++) {
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }
            if (totalCount > 0 && totalPrice > sp.get(n)) {
                filterSpecial.add(sp);
            }
        }

        return dfs(price, needs, filterSpecial, n);
    }

    // 记忆化搜索计算满足购物清单所需花费的最低价格
    public int dfs(List<Integer> price, List<Integer> curNeeds, List<List<Integer>> filterSpecial, int n) {
        if (! memo.containsKey(curNeeds)) {
            int minPrice = 0;
            for (int i = 0; i < n; i++) {
                minPrice += curNeeds.get(i) * price.get(i); // 不购买任何大礼包，原价购买购物清单中的所有物品
            }
            for (List<Integer> curSpecial : filterSpecial) {
                int specialPrice = curSpecial.get(n);
                List<Integer> nxtNeeds = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (curSpecial.get(i) > curNeeds.get(i)) { // 不能购买超出购物清单指定数量的物品
                        break;
                    }
                    nxtNeeds.add(curNeeds.get(i) - curSpecial.get(i));
                }
                if (nxtNeeds.size() == n) { // 大礼包可以购买
                    minPrice = Math.min(minPrice, dfs(price, nxtNeeds, filterSpecial, n) + specialPrice);
                }
            }
            memo.put(curNeeds, minPrice);
        }
        return memo.get(curNeeds);
    }

    public static void main(String[] args) {
        ShoppingOffer shoppingOffer = new ShoppingOffer();
        Integer[] priceArray = {2,3,4};
        List<Integer> price = new ArrayList<>();
        Collections.addAll(price, priceArray);
        Integer[][] specialArray = {{1,1,0,4},{2,2,1,9}};
        List<List<Integer>> special = new ArrayList<>();
        for (int i = 0; i <= specialArray.length - 1; i++) {
            List<Integer> tmpSpecial = new ArrayList<>();
            Collections.addAll(tmpSpecial, specialArray[i]);
            special.add(tmpSpecial);
        }
        Integer[] needsArray = {1,2,1};
        List<Integer> needs = new ArrayList<>();
        Collections.addAll(needs, needsArray);
        int result = shoppingOffer.shoppingOffers(price, special, needs);
        System.out.println(result);
    }
}
