class Node{
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}


class LRUCache {
    
    Map<Integer, Node> map;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int ans = -1;
        if(map.containsKey(key)){
            //get the node from the hashmap
            Node curr = map.get(key);
            ans = curr.val;

            //unlink from original position
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            //move node to MRU
            curr.next = head.next;
            curr.prev = head;
            head.next.prev = curr;
            head.next = curr;
        }

        return ans;
    }
    
    public void put(int key, int value) {
        
        Node newNode = new Node(key, value);

        //add new node to MRU position
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;

        if(map.containsKey(key)){
            Node node = map.get(key);
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = null;
            node.prev = null;
        }

        map.put(key, newNode);

        if(map.size() > capacity){
            Node rem = tail.prev;

            if(rem != null){
                map.remove(rem.key);
                rem.next.prev = rem.prev;
                rem.prev.next = rem.next;
                rem.next = null;
                rem.prev = null;
            }
            
        }
    }
}
