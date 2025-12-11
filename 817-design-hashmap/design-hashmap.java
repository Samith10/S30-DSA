class MyHashMap {
    class Node{
        int key, value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    int buckets;
    Node[] storage;

    public MyHashMap() {
        this.buckets = 1000;
        this.storage = new Node[buckets];
    }
    
    int getBucket(int key){
        return key%1000;
    }

    private Node find(Node dummy, int key){
        Node prev = dummy;
        Node curr = dummy.next;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        if(storage[bucket]==null){
            storage[bucket] = new Node(-1 ,-1);
        }
        Node curr = find(storage[bucket], key);
        if(curr.next != null){
            curr.next.value = value;
        }
        else{
        curr.next = new Node(key,value);
        }
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        if(storage[bucket]==null){
            return -1;
        }
        Node curr = find(storage[bucket], key);
        if(curr.next != null){
            return curr.next.value;
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        if(storage[bucket]==null){
            return;
        }
        Node curr = find(storage[bucket], key);
        if(curr.next == null){
            return;
        }
        curr.next=curr.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */