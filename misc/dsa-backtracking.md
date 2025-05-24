# Backtracking Notes

## Subset

### Problem Statement
Given an integer array `nums` of unique elements, return all possible subsets (the power set). The solution set must not contain duplicate subsets.

### Example
```cpp
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
```

### Solution
```cpp
class Solution {
public:
    void bt(int i, vector<int>& v, vector<int>& temp, vector<vector<int>>& res){
        res.push_back(temp);
        if(i >= v.size()) return;
        for(int idx = i; idx < v.size(); idx++){
            temp.push_back(v[idx]);
            bt(idx+1, v, temp, res);
            temp.pop_back();
        }
    }
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> temp;
        bt(0, nums, temp, res);
        return res;
    }
};
```

## Subsets II

### Problem Statement
Given an integer array `nums` that may contain duplicates, return all possible subsets (the power set) without duplicates.

### Example
```cpp
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
```

### Solution
```cpp
class Solution {
public:
    void bt(int i, vector<int>& nums, vector<int>& temp, vector<vector<int>>& res){
        res.push_back(temp);
        if(i >= nums.size()) return;
        for(int idx = i; idx < nums.size(); idx++){
            if(idx > i && nums[idx] == nums[idx-1]) continue;
            temp.push_back(nums[idx]);
            bt(idx+1, nums, temp, res);
            temp.pop_back();
        }
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> temp;
        sort(nums.begin(), nums.end());
        bt(0, nums, temp, res);
        return res;
    }
};
```

## Combinations

### Problem Statement
Given two integers `n` and `k`, return all possible combinations of `k` numbers chosen from `[1, n]`.

### Example
```cpp
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
```

### Solution
```cpp
class Solution {
public:
    void bt(int i, int n, int k, vector<int>& temp, vector<vector<int>>& res){
        if(temp.size() > k) return;
        if(temp.size() == k) res.push_back(temp);
        else {
            for(int idx = i; idx <= n; idx++){
                temp.push_back(idx);
                bt(idx+1, n, k, temp, res);
                temp.pop_back();
            }
        }
    }
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> res;
        vector<int> temp;
        bt(1, n, k, temp, res);
        return res;
    }
};
```

## Combination Sum

### Problem Statement
Given an array of distinct integers `candidates` and a target integer `target`, return all unique combinations where the chosen numbers sum to `target`. Numbers may be used multiple times.

### Example
```cpp
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
```

### Solution
```cpp
class Solution {
public:
    void bt(int i, vector<int>& v, int t, vector<int>& temp, vector<vector<int>>& res){
        if(t == 0){
            res.push_back(temp);
            return;
        }
        if(t < 0) return;
        for(int idx = i; idx < v.size(); idx++){
            temp.push_back(v[idx]);
            bt(idx, v, t - v[idx], temp, res);
            temp.pop_back();
        }
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        vector<int> temp;
        bt(0, candidates, target, temp, res);
        return res;
    }
};
```

## Combination Sum II

### Problem Statement
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations where numbers sum to `target`. Each number may be used once.

### Example
```cpp
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
```

### Solution
```cpp
class Solution {
public:
    void bt(int i, vector<int>& v, int t, vector<int>& temp, vector<vector<int>>& res){
        if(t == 0){
            res.push_back(temp);
            return;
        }
        if(t < 0) return;
        for(int idx = i; idx < v.size() && t - v[idx] >= 0; idx++){
            if(idx > i && v[idx] == v[idx-1]) continue;
            temp.push_back(v[idx]);
            bt(idx+1, v, t - v[idx], temp, res);
            temp.pop_back();
        }
    }
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        vector<int> temp;
        sort(candidates.begin(), candidates.end());
        bt(0, candidates, target, temp, res);
        return res;
    }
};
```

## Combination Sum III

### Problem Statement
Find all valid combinations of `k` numbers that sum up to `n`. Numbers `1-9` can be used only once.

### Example
```cpp
Input: k = 3, n = 7
Output: [[1,2,4]]
```

### Solution
```cpp
class Solution {
public:
    void bt(int i, int k, int n, vector<int>& temp, vector<vector<int>>& res){
        if(n == 0 && temp.size() == k){
            res.push_back(temp);
            return;
        }
        if(n < 0 || temp.size() > k) return;
        for(int idx = i; idx <= 9; idx++){
            temp.push_back(idx);
            bt(idx+1, k, n - idx, temp, res);
            temp.pop_back();
        }
    }
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> res;
        vector<int> temp;
        bt(1, k, n, temp, res);
        return res;
    }
};
```

## Permutations

### Problem Statement
Given an array `nums` of distinct integers, return all possible permutations.

### Example
```cpp
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
```

### Solution
```cpp
class Solution {
public:
    void bt(vector<int>& nums, int start, vector<vector<int>>& res) {
        if(start == nums.size()) {
            res.push_back(nums);
            return;
        }
        for(int i = start; i < nums.size(); i++) {
            swap(nums[start], nums[i]);
            bt(nums, start + 1, res);
            swap(nums[start], nums[i]);
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        bt(nums, 0, res);
        return res;
    }
};
```

## Permutations II

### Problem Statement
Given a collection of numbers, `nums`, that might contain duplicates, return all possible unique permutations in any order.

### Example
```cpp
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
```

### Solution
```cpp
class Solution {
public:
    void bt(int i, vector<int>& v, vector<vector<int>>& res){
        if(i>=v.size()){
            res.push_back(v);
            return;
        }
        for(int idx = i; idx < v.size(); idx++){
            if(idx>i && v[idx]==v[idx-1])continue;
            swap(v[i], v[idx]);
            bt(i+1,v,res);
            swap(v[i],v[idx]);
        }
    }
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> res;
        sort(nums.begin(),nums.end());
        bt(0,nums,res);
        set<vector<int>> st;
        for(auto it:res)st.insert(it);
        res.clear();
        for(auto it:st)res.push_back(it);

        return res;
    }
};
```

## Letter Tile Possibilities

### Problem Statement
You have `n` tiles, where each tile has one letter `tiles[i]` printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

### Example
```cpp
Input: tiles = "AAB"
Output: 8
```

### Solution
```cpp
class Solution {
public:
    int finalRes = 0;
    void bt2(int i, string& s, unordered_set<string>& res){
        if(i>=s.size()){
            res.insert(s);
            return;
        }
        for(int idx = i; idx< s.size();idx++){
            swap(s[idx],s[i]);
            bt2(i+1, s,res);
            swap(s[idx],s[i]);
        }
    }
    void bt(int i, string tiles, string& temp, vector<string>& res){
        res.push_back(temp);
        if(temp.size()!=0){
            unordered_set<string> res2;
            string temp2 = temp;
            bt2(0,temp2,res2);
            finalRes+=res2.size();
        }
        if(i>=tiles.size()){
            return;
        }
        for(int idx = i; idx<tiles.size(); idx++){
            if(idx>i && tiles[idx]==tiles[idx-1])continue;
            temp.push_back(tiles[idx]);
            bt(idx+1, tiles, temp, res);
            temp.pop_back();
        }
    }
    int numTilePossibilities(string tiles) {
        vector<string> res;
        string temp = "";
        sort(tiles.begin(),tiles.end());
        bt(0,tiles,temp,res);
        return finalRes;
    }
};
```

### Another Solution (1)
```cpp
class Solution {
public:
    int numTilePossibilities(string tiles) {
        unordered_set<string> sequences;
        vector<bool> used(tiles.length(), false);

        // Generate all possible sequences including empty string
        generateSequences(tiles, "", used, sequences);

        // Subtract 1 to exclude empty string from count
        return sequences.size() - 1;
    }

private:
    void generateSequences(string& tiles, string current, vector<bool>& used,
                           unordered_set<string>& sequences) {
        // Add current sequence to set
        sequences.insert(current);

        // Try adding each unused character to current sequence
        for (int pos = 0; pos < tiles.length(); ++pos) {
            if (!used[pos]) {
                used[pos] = true;
                generateSequences(tiles, current + tiles[pos], used, sequences);
                used[pos] = false;
            }
        }
    }
};
```

### Another Solution (2)
```cpp
class Solution {
public:
    int numTilePossibilities(string tiles) {
        // Track frequency of each uppercase letter (A-Z)
        int charCount[26] = {0};
        for (char c : tiles) {
            charCount[c - 'A']++;
        }

        // Find all possible sequences using character frequencies
        return findSequences(charCount);
    }

private:
    int findSequences(int charCount[26]) {
        int totalCount = 0;

        // Try using each available character
        for (int pos = 0; pos < 26; pos++) {
            if (charCount[pos] == 0) {
                continue;
            }

            // Add current character and recurse
            totalCount++;
            charCount[pos]--;
            totalCount += findSequences(charCount);
            charCount[pos]++;
        }

        return totalCount;
    }
};
```

### Another Solution (3)
```cpp
class Solution {
public:
    int bt(string tiles, unordered_map<char,int>& mp, unordered_set<char>& st){
        int res = 0;
        for(auto it:st){
            if(mp.find(it)!=mp.end()){
                mp[it]--;
                res++;
                if(mp[it]==0)mp.erase(it);
                res+=bt(tiles,mp,st);
                mp[it]++;
            }
        }
        return res;
    }
    int numTilePossibilities(string tiles) {
        unordered_map<char,int> mp;
        unordered_set<char> st;
        for(auto ch: tiles){
            mp[ch]++;
            st.insert(ch);
        }
        return bt(tiles, mp, st);
    }
};
```

## Palindrome Partitioning

### Problem Statement
Given a string `s`, partition it such that every substring is a palindrome. Return all possible palindrome partitioning of `s`.

### Example
```cpp
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
```

### Solution
```cpp
class Solution {
public:
    bool isPalindrome(string& s, int start, int end) {
        while(start < end) {
            if(s[start++] != s[end--]) return false;
        }
        return true;
    }
    void bt(string& s, int start, vector<string>& temp, vector<vector<string>>& res) {
        if(start == s.size()) {
            res.push_back(temp);
            return;
        }
        for(int end = start; end < s.size(); end++) {
            if(isPalindrome(s, start, end)) {
                temp.push_back(s.substr(start, end - start + 1));
                bt(s, end + 1, temp, res);
                temp.pop_back();
            }
        }
    }
    vector<vector<string>> partition(string s) {
        vector<vector<string>> res;
        vector<string> temp;
        bt(s, 0, temp, res);
        return res;
    }
};
```
