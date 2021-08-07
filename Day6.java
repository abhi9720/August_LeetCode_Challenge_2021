Runtime  2ms

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> children  =  new LinkedList<>();
        List<List<Integer>> ans =  new ArrayList<>();
        if(root==null) return ans;
        children.add(root);
        
        
        
        while(!children.isEmpty() ){
           int len  =  children.size();
            List<Integer> level  =  new ArrayList<Integer>();
           for(int i=0;i<len;i++){
               Node parent =  children.poll();
               level.add(parent.val);
             for(Node c : parent.children){
                 children.add(c);
             }               
           }
            ans.add(level);
        }        
        return ans;
    }
}


Runtime : 0ms

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans  =  new ArrayList<>();
        dfs(root,ans,0);
        return ans;
    }
    private void dfs(Node root , List<List<Integer>> ans,int d){

        if(root==null) return ;
        if(ans.size()<=d ) ans.add(new ArrayList<Integer>());
        
        ans.get(d).add(root.val);
        
        for(Node child  : root.children){
            dfs(child,ans,d+1);
        }        
    }
    
}
  
