class TimeMap {
    Map<String, TreeSet<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        
        map.computeIfAbsent(key, k -> new TreeSet<>((a, b) -> Integer.compare(a.getKey(), b.getKey()))).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        TreeSet<Pair<Integer, String>> set = map.get(key);
        
        // Dummy pair used to search for largest timestamp <= requested timestamp
        Pair<Integer, String> dummy = new Pair<>(timestamp, "");
        Pair<Integer, String> floor = set.floor(dummy);

        return (floor != null) ? floor.getValue() : "";
    }
}
