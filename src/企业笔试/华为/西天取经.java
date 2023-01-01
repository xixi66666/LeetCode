package 企业笔试.华为;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author YangChenxi
 */
public class 西天取经 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int limit = scanner.nextInt();
        int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int dis[][][] = new int[255][255][4];
        int mapp[][] = new int[300][400];
        boolean vis[][][] = new boolean[255][255][5];
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                mapp[i][j] = scanner.nextInt();
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                for(int k = 0;k<4;k++){
                    dis[i][j][k] = 100000;
                }
            }
        }
        dis[0][0][0] = 0;
        Queue<node> queue = new LinkedList<>();
        queue.add(new node(0,0,0,0));
        while(!queue.isEmpty()){
                node now = queue.poll();
                System.out.println(now.toString());
                if(vis[now.x][now.y][now.cost]){
                    continue;
                }
                vis[now.x][now.y][now.cost] = true;
                for(int i = 0;i<4;i++){
                    int xx = now.x + dir[i][0];
                    int yy = now.y + dir[i][1];
                    if(xx < 0 || xx >= n || yy <0 || yy >=m) {
                        continue;
                    }
                    int res = Math.abs(mapp[xx][yy] - mapp[now.x][now.y]);
                    if(res > limit){
                        if(now.cost == 3){
                            continue;
                        }
                        if(dis[xx][yy][now.cost + 1] > now.step+1){
                            dis[xx][yy][now.cost + 1] = now.step+1;
                            queue.add(new node(xx,yy,now.cost+1,now.step+1));
                            //System.out.print("大于   " + now.x + now.y +"   "+ queue.peek().toString());
                        }
                    }else {
                        if(dis[xx][yy][now.cost] > now.step+1){
                            dis[xx][yy][now.cost] = now.step+1;
                            queue.add(new node(xx,yy,now.cost,now.step+1));
                            //System.out.print("小于   " + now.x + now.y +"   "+ queue.peek().toString());
                        }
                    }
                }
            //System.out.println(queue.element().toString());
        }
        int ans = 100000;
        for(int i = 0;i<=3;i++){
            ans = Math.min(ans,dis[n-1][m-1][i]);
        }
        if(ans > 10000){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }
}
class node {
    int x,y;
    int cost;
    int step;

    public node(int x, int y, int cost, int step) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.step = step;
    }

//    @Override
//    public int compareTo(node o) {
//        return this.step - o.step;
//    }

    @Override
    public String toString() {
        return "node{" +
                "x=" + x +
                ", y=" + y +
                ", cost=" + cost +
                ", step=" + step +
                '}';
    }
}
