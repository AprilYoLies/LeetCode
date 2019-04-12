package com.eva.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 14
 * 3 2 1 2 1 1 1 2 2 3 3 4 2 2
 * 3 3 4 3 3 5 4 6 7 5 6 8 4 9
 * 2 1 2 1 1 1 2 2 3 3 4 4 1 1
 * 2 2 1 3 2 4 7 2 2 5 7 2 2 1
 * <p>
 * 4
 * 3 2 1 2
 * 2 3 4 3
 * 2 1 2 1
 * 2 2 1 3
 * <p>
 * 2
 * 1 2
 * 2 3
 * 2 8
 * 2 1
 * <p>
 * 11
 * 1 4 1 2 7 1 2 4 7 4 7
 * 4 3 3 4 2 2 7 2 8 5 4
 * 1 3 2 2 8 1 3 4 7 6 8
 * 3 1 1 2 1 1 5 1 6 3 3
 *
 * @Author EvaJohnson
 * @Date 2019-04-12
 * @Email g863821569@gmail.com
 */
public class Azulejos {

    private static Comparator<Tile> priceSorter = new SortorByPrice();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        // 保存后排的瓦片
        ArrayList<Tile> row1 = new ArrayList<>();
        // 保存前排的瓦片
        ArrayList<Tile> row2 = new ArrayList<>();
        fillId(row1, size);
        fillId(row2, size);

        inputData(sc, size, row1);
        inputData(sc, size, row2);

        row1.sort(priceSorter);
        row2.sort(priceSorter);

        for (int i = 0, j = 0; j < row1.size(); ) {
            if (row1.get(i).price == row1.get(j).price && j < row1.size() - 1) j++;
            else {
                System.out.print("");
                for (int index = i; index < j; index++) {
                    int height = row1.get(index).height;
                    int res = findAndExchange(height, index, row2, row1);
                    if (res < 0) {
                        System.out.println("\nimpossible");
                        return;
                    }
                }
                i = j++;
            }
        }

        System.out.println("\nThe right order......");
        print(row1);
        print(row2);

        System.out.println("\nThis is the answer......");

        for (Tile tile : row1) {
            System.out.print(tile.getId() + " ");
        }
        System.out.println();
        for (Tile tile : row2) {
            System.out.print(tile.getId() + " ");
        }
    }

    private static void inputData(Scanner sc, int size, ArrayList<Tile> row) {
        for (int i = 0; i < size; i++) {
            int p = sc.nextInt();
            fillPrice(row, i, p);
        }
        for (int i = 0; i < size; i++) {
            int h = sc.nextInt();
            fillHeight(row, i, h);
        }
    }

    // 打印瓦片的价格和高度序列
    private static void print(List<Tile> list) {
        for (Tile tile : list) {
            System.out.print(tile.getPrice() + " ");
        }
        System.out.println();
        for (Tile tile : list) {
            System.out.print(tile.getHeight() + " ");
        }
        System.out.println();
    }

    /**
     * @param height 当前前排瓦片的高度
     * @param l      当前前排瓦片的索引
     * @param row2   前排瓦片
     * @param row1   后排瓦片
     * @return
     * @see @findTarget()
     */
    private static int findAndExchange(int height, int l, List<Tile> row2, List<Tile> row1) {
        int target = -1;
        int max = 0;
        int p = row2.get(l).price;
        int r = l;
        target = findTarget(row2, l, r, p, height, max, target, true);
        if (target >= 0) {
            Tile t = row2.get(l);
            row2.set(l, row2.get(target));
            row2.set(target, t);
        } else {
            r = l;
            p = row1.get(l).price;
            max = Integer.MAX_VALUE;
            height = row2.get(l).height;
            target = findTarget(row1, l, r, p, height, max, target, false);
            if (target >= 0) {
                Tile t = row1.get(l);
                row1.set(l, row1.get(target));
                row1.set(target, t);
            }
        }
        return target;
    }

    /**
     * 查找对应瓦片链表中是否有满足需求高度的瓦片。
     * <p>
     * 此处的查找分为两种情况，如果是位于前排，那么就是查找高度小于其后排瓦片且尽可能大的瓦片，
     * 如果是位于后排，那么便是查找大于其前排高度且尽可能小的瓦片。需要注意在两种查找的情况下，
     * 查找范围都是在当前价格区段中。
     *
     * @param row    被查找的瓦片序列
     * @param l      当前被查找的位置
     * @param r      相同价格区段的最后一个瓦片的索引
     * @param p      目前所在的价格区段
     * @param height 参考高度
     * @param max    记录尽可能大或者小的值
     * @param target 目标位置，如果没找到，将返回-1，否则为目标索引
     * @param flag   两种查找模式，true 代表查找前排小于后排高度尽可能大的target，false 代表查找后排大于前排高度尽可能小的target
     * @return 被查找的target的索引下标，-1代表查找失败
     */
    private static int findTarget(List<Tile> row, int l, int r, int p, int height, int max, int target, boolean flag) {
        while (row.get(r).price == p) {
            r++;
            if (r == row.size()) break;
        }
        for (int i = l; i < r; i++) {
            int h = row.get(i).height;
            if ((flag && h < height) || (!flag && h > height)) {
                if ((!flag && h < max) || (flag && h > max)) {
                    max = h;
                    target = i;
                }
            }
        }
        return target;
    }

    // 瓦片价格比较器
    private static class SortorByPrice implements Comparator<Tile> {

        @Override
        public int compare(Tile o1, Tile o2) {
            return o1.price - o2.price;
        }
    }

    private static void fillPrice(List<Tile> list, int index, int p) {
        list.get(index).setPrice(p);
    }

    private static void fillHeight(List<Tile> list, int index, int h) {
        list.get(index).setHeight(h);
    }

    // 新建瓦片对象设置ID，存放入链表中
    private static void fillId(List<Tile> list, int n) {
        for (int i = 0; i < n; i++) {
            Tile tile = new Tile();
            tile.setId(i);
            list.add(i, tile);
        }
    }

    /**
     * 定义瓦片Pojo
     * id 瓦片序号
     * price 瓦片价格
     * height 瓦片高度
     */
    private static class Tile {
        private int id;
        private int price;
        private int height;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id + 1;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
