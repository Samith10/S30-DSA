class MyHashSet {
    int primary;
    int secondary;
    boolean[][] storage;

    public MyHashSet() {
        this.primary = 1000;
        this.secondary = 1000;
        storage = new boolean[primary][];
    }

    int getPrimary(int key){
        return key%1000;
    }

    int getSecondary(int key){
        return key/1000;
    }
    
    public void add(int key) {
        int bucket = getPrimary(key);
        int bucketItem = getSecondary(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[secondary+1];
            }
            else{
            storage[bucket] = new boolean[secondary];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = getPrimary(key);
        int bucketItem = getSecondary(key);
        if(storage[bucket] != null){
            storage[bucket][bucketItem] = false;
        }
    }
    
    public boolean contains(int key) {
        int bucket = getPrimary(key);
        int bucketItem = getSecondary(key);
        if(storage[bucket] == null){
            return false;
        }
        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */