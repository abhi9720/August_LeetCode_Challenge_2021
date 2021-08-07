problem  : https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3835/
DiscussionLink :https://leetcode.com/problems/making-a-large-island/discuss/1377892/how-to-approch-this-question-with-visualization-on2

class Solution {
    public static int largestIsland(int[][] grid) {
        int row  =  grid.length;
        int col  =  grid[0].length;
        
        int isVisited[][]  =  new int[row][col];
        HashMap<Integer,Integer>map=  new HashMap<>();
        int maxArea = 0;
        int index  = 1;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++ ){
                if(grid[i][j]==1  && isVisited[i][j]<=0 ){
                    map.put(index,dfs(grid,i,j,isVisited,index));
                    maxArea  =  Math.max(map.get(index),maxArea);
                    index++;
                }                
            }
            
        }
        
//        for(int i=0;i<row;i++){
//            for(int j=0;j<col;j++ ){
//            	System.out.print(isVisited[i][j]+"  ");
//            }
//            System.out.println();
//            }
//        System.out.println(map);
//        System.out.println("-------------------------------------------");
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++ ){
                
                if(grid[i][j]==0){
                	int area  = 0;
                  // find all valid neighbour of 0  
                int dir[][] =  {{0,1},{1,0},{0,-1},{-1,0}};
                HashSet<Integer> set  =  new HashSet<Integer>();
                 for(int d[]:dir){
                    int newX =  i+d[0];
                    int newY =  j+d[1];
                    if(isValid(grid,newX,newY) ){
                    set.add(isVisited[newX][newY]);
                        }                
                    }
//                 System.out.println("------ neighbour"+i+" "+j+"--------");
//                 System.out.println(set);
                 
                    // then sum all valid 
                    for(Integer idx :set){
//                    	System.out.println("idx: "+idx+"   "+map.getOrDefault(idx,0));
                        area+= map.getOrDefault(idx,0);
                    }
                    maxArea  = Math.max(maxArea,area+1);
//                    System.out.println(area);
                }
                
                
                
                
                
            }
            
        }
        return maxArea;
    }
      private static int dfs(int grid[][] , int x,int y, int isVisited[][],int index){
        // for x,y cell explore all its neighbour 
        
        
        if(grid[x][y]==0) return 0 ;
        isVisited[x][y] = index;
        int dir[][] =  {{0,1},{1,0},{0,-1},{-1,0}};
        int count  = 1;
        for(int d[]:dir){
            int newX =  x+d[0];
            int newY =  y+d[1];
            if(isValid(grid,newX,newY) && isVisited[newX][newY] <=0){
                
                  count+=dfs(grid,newX,newY,isVisited,index);
                
            }
        }
     return count;
    }
    private static boolean isValid(int grid[][],int x,int y){
        return  !(x<0 || x>=grid.length || y<0 || y>= grid[0].length);        
    }
}