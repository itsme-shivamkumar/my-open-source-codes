# Complete Dynamic Programming Roadmap & Cheatsheet

## 🎯 How to Use This Roadmap
1. **Follow the order** - Each level builds on previous concepts
2. **Solve classical problems first** (⭐ marked) - These are templates
3. **Then solve variations** - Apply the same pattern
4. **Code both approaches** - Top-down (recursive) and Bottom-up (iterative)
5. **Time yourself** - Track progress: Easy (15m), Medium (30m), Hard (60m)

---

## **Level 1: Fundamentals (1D DP)**
**Goal**: Understand basic DP concepts, memoization, state transitions

### **1.1 Linear DP - Single Sequence**

#### Pattern: `dp[i]` depends on `dp[i-1]`, `dp[i-2]`, etc.

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| ⭐ | Fibonacci Number | [LC 509](https://leetcode.com/problems/fibonacci-number/) | Easy | Base template | Start here! |
| ⭐ | Climbing Stairs | [LC 70](https://leetcode.com/problems/climbing-stairs/) | Easy | Fibonacci variant | 1 or 2 steps |
| | Min Cost Climbing Stairs | [LC 746](https://leetcode.com/problems/min-cost-climbing-stairs/) | Easy | Cost minimization | Pay cost at each step |
| | N-th Tribonacci | [LC 1137](https://leetcode.com/problems/n-th-tribonacci-number/) | Easy | Triple dependency | `dp[i-3]` |
| ⭐ | House Robber | [LC 198](https://leetcode.com/problems/house-robber/) | Medium | Non-adjacent selection | Can't rob adjacent |
| | House Robber II | [LC 213](https://leetcode.com/problems/house-robber-ii/) | Medium | Circular array | First & last connected |
| | Delete and Earn | [LC 740](https://leetcode.com/problems/delete-and-earn/) | Medium | House Robber variant | Group by value |
| | Decode Ways | [LC 91](https://leetcode.com/problems/decode-ways/) | Medium | String decoding | 1-26 mapping |
| | Decode Ways II | [LC 639](https://leetcode.com/problems/decode-ways-ii/) | Hard | With wildcards | '*' can be 1-9 |
| ⭐ | Jump Game | [LC 55](https://leetcode.com/problems/jump-game/) | Medium | Reachability | Can reach end? |
| | Jump Game II | [LC 45](https://leetcode.com/problems/jump-game-ii/) | Medium | Min jumps | BFS + DP |
| | Dice Combinations | [CSES](https://cses.fi/problemset/task/1633) | Easy | Sum ways | Using 1-6 |
| | Minimizing Coins | [CSES](https://cses.fi/problemset/task/1634) | Easy | Coin change min | Classic problem |
| | Coin Combinations I | [CSES](https://cses.fi/problemset/task/1635) | Easy | **Permutations** | Order matters! |

**Key Concepts**: State definition, base cases, transitions, space optimization

---

### **1.2 DP with Constraints**

#### Pattern: State depends on previous states with additional conditions

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| | Best Time to Buy/Sell Stock | [LC 121](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Easy | Max profit (1 txn) | Track min price |
| | Best Time to Buy/Sell II | [LC 122](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | Medium | Unlimited txns | Buy-sell multiple |
| | Best Time to Buy/Sell III | [LC 123](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/) | Hard | At most 2 txns | State: [day][txn][holding] |
| | Best Time to Buy/Sell IV | [LC 188](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/) | Hard | At most K txns | Generalized version |
| | With Cooldown | [LC 309](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | Medium | Cooldown period | Can't buy next day after sell |
| | With Transaction Fee | [LC 714](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/) | Medium | Pay fee per txn | Subtract fee |
| ⭐ | Maximum Subarray | [LC 53](https://leetcode.com/problems/maximum-subarray/) | Medium | Kadane's Algorithm | Must know! |
| | Maximum Product Subarray | [LC 152](https://leetcode.com/problems/maximum-product-subarray/) | Medium | Track max & min | Negative flips |
| | Longest Turbulent Subarray | [LC 978](https://leetcode.com/problems/longest-turbulent-subarray/) | Medium | Alternating pattern | Up-down sequence |

**Key Concepts**: State machines, tracking multiple states, constraint handling

---

## **Level 2: 2D Grid & Sequences**
**Goal**: Master 2D DP on grids and sequences

### **2.1 Grid Path Problems**

#### Pattern: `dp[i][j]` depends on `dp[i-1][j]` and `dp[i][j-1]`

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| ⭐ | Unique Paths | [LC 62](https://leetcode.com/problems/unique-paths/) | Medium | Grid paths | Right/Down only |
| | Unique Paths II | [LC 63](https://leetcode.com/problems/unique-paths-ii/) | Medium | With obstacles | Skip blocked cells |
| ⭐ | Minimum Path Sum | [LC 64](https://leetcode.com/problems/minimum-path-sum/) | Medium | Min cost path | Sum values |
| | Dungeon Game | [LC 174](https://leetcode.com/problems/dungeon-game/) | Hard | Bottom-up path | Min HP needed |
| | Cherry Pickup | [LC 741](https://leetcode.com/problems/cherry-pickup/) | Hard | Two paths | Go & return |
| | Cherry Pickup II | [LC 1463](https://leetcode.com/problems/cherry-pickup-ii/) | Hard | Two robots | Parallel collection |
| | Minimum Falling Path Sum | [LC 931](https://leetcode.com/problems/minimum-falling-path-sum/) | Medium | Column movement | Can move diagonal |
| | Minimum Falling Path Sum II | [LC 1289](https://leetcode.com/problems/minimum-falling-path-sum-ii/) | Hard | Any column | No restrictions |
| | Triangle | [LC 120](https://leetcode.com/problems/triangle/) | Medium | Triangular grid | Top to bottom |
| | Grid Paths | [CSES](https://cses.fi/problemset/task/1638) | Easy | With obstacles | CSES version |

**Key Concepts**: 2D state transitions, grid traversal, space optimization to O(n)

---

### **2.2 Matrix Chain Multiplication Family**

#### Pattern: `dp[i][j]` = optimal solution for range `[i, j]`

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| ⭐ | Matrix Chain Multiplication | [GFG](https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication) | Hard | Range DP | Classic template |
| | Burst Balloons | [LC 312](https://leetcode.com/problems/burst-balloons/) | Hard | Range partition | Burst last strategy |
| | Minimum Cost to Merge Stones | [LC 1000](https://leetcode.com/problems/minimum-cost-to-merge-stones/) | Hard | K-way merge | Merge into K piles |
| | Remove Boxes | [LC 546](https://leetcode.com/problems/remove-boxes/) | Hard | 3D range DP | Remove consecutive |
| | Minimum Score Triangulation | [LC 1039](https://leetcode.com/problems/minimum-score-triangulation-of-polygon/) | Medium | Polygon partition | Triangulate polygon |
| | Palindrome Partitioning II | [LC 132](https://leetcode.com/problems/palindrome-partitioning-ii/) | Hard | Min cuts | Make all palindromes |
| | Palindrome Partitioning III | [LC 1278](https://leetcode.com/problems/palindrome-partitioning-iii/) | Hard | K palindromes | With changes |

**Key Concepts**: Range DP, interval partitioning, MCM pattern `dp[i][j] = min(dp[i][k] + dp[k+1][j] + cost)`

---

## **Level 3: Knapsack Family**
**Goal**: Master all knapsack variations - the most important DP pattern!

### **3.1 0/1 Knapsack (Use Each Item Once)**

#### Pattern: Iterate items, update DP **backward** to avoid reuse

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| ⭐ | 0/1 Knapsack | [GFG](https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem) | Medium | Base template | Must master! |
| ⭐ | Subset Sum | [GFG](https://practice.geeksforgeeks.org/problems/subset-sum-problem) | Medium | Boolean knapsack | Can make sum? |
| ⭐ | Partition Equal Subset Sum | [LC 416](https://leetcode.com/problems/partition-equal-subset-sum/) | Medium | Subset sum variant | Split into two equal |
| | Partition to K Equal Sum | [LC 698](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/) | Medium | K subsets | More complex |
| ⭐ | Target Sum | [LC 494](https://leetcode.com/problems/target-sum/) | Medium | +/- assignment | Converts to subset sum |
| | Ones and Zeroes | [LC 474](https://leetcode.com/problems/ones-and-zeroes/) | Medium | 2D constraints | m zeros, n ones |
| | Last Stone Weight II | [LC 1049](https://leetcode.com/problems/last-stone-weight-ii/) | Medium | Minimize difference | Partition variant |
| | Tallest Billboard | [LC 956](https://leetcode.com/problems/tallest-billboard/) | Hard | Equal height | Supports equal length |

**Key Code Pattern**:
```cpp
for(int item : items) {
    for(int w = W; w >= weight[item]; w--) {  // BACKWARD!
        dp[w] = max(dp[w], dp[w - weight[item]] + value[item]);
    }
}
```

---

### **3.2 Unbounded Knapsack (Unlimited Use)**

#### Pattern: Iterate items, update DP **forward** to allow reuse

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| ⭐ | Unbounded Knapsack | [GFG](https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items) | Medium | Base template | Infinite supply |
| ⭐ | Coin Change (Min Coins) | [LC 322](https://leetcode.com/problems/coin-change/) | Medium | Min cost variant | Minimize coins |
| ⭐ | Coin Change 2 (Count Ways) | [LC 518](https://leetcode.com/problems/coin-change-2/) | Medium | **Combinations** | Order doesn't matter |
| | Coin Combinations II | [CSES](https://cses.fi/problemset/task/1636) | Easy | Same as LC 518 | CSES version |
| | Perfect Squares | [LC 279](https://leetcode.com/problems/perfect-squares/) | Medium | Coin change variant | Use squares |
| ⭐ | Rod Cutting | [GFG](https://practice.geeksforgeeks.org/problems/rod-cutting) | Medium | Maximize value | Cut into pieces |
| | Integer Break | [LC 343](https://leetcode.com/problems/integer-break/) | Medium | Product maximization | Break into parts |
| | Combination Sum IV | [LC 377](https://leetcode.com/problems/combination-sum-iv/) | Medium | **Permutations** | Order matters! |

**Key Code Pattern**:
```cpp
for(int item : items) {
    for(int w = weight[item]; w <= W; w++) {  // FORWARD!
        dp[w] = max(dp[w], dp[w - weight[item]] + value[item]);
    }
}
```

**Critical Difference**:
- **Combinations** (LC 518): Process items in outer loop → Avoid duplicates
- **Permutations** (LC 377): Process sum in outer loop → Count all orders

---

### **3.3 Bounded Knapsack (Limited Quantity)**

#### Pattern: Each item has a maximum count

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| | Bounded Knapsack | [GFG](https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items) | Hard | With limits | Each item ≤ K times |
| | Coin Change with Limit | Custom | Medium | Limited coins | Max count per coin |
| | Profitable Schemes | [LC 879](https://leetcode.com/problems/profitable-schemes/) | Hard | Multiple constraints | 3D DP |

---

### **3.4 Subset/Partition Problems**

#### Pattern: Split array into groups with constraints

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| | Count Subsets with Sum K | [GFG](https://practice.geeksforgeeks.org/problems/perfect-sum-problem) | Medium | Count ways | Perfect sum |
| | Minimum Subset Sum Difference | [GFG](https://practice.geeksforgeeks.org/problems/minimum-sum-partition) | Medium | Minimize |sum1-sum2| | Partition variant |
| | Count Partitions Given Diff | [GFG](https://practice.geeksforgeeks.org/problems/partitions-with-given-difference) | Medium | |sum1-sum2| = D | Constrained partition |
| | Ways to Sum to N (1,2,3) | Custom | Medium | Fixed numbers | Unbounded variant |
| | Two Sets | [CSES](https://cses.fi/problemset/task/1092) | Easy | Split 1..n equally | Constructive |
| | Two Sets II | [CSES](https://cses.fi/problemset/task/1093) | Medium | Count ways | DP version |

---

## **Level 4: Subsequences & Strings**
**Goal**: Master sequence/string DP patterns

### **4.1 Longest Common Subsequence (LCS) Family**

#### Pattern: Match characters from two sequences

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| ⭐ | Longest Common Subsequence | [LC 1143](https://leetcode.com/problems/longest-common-subsequence/) | Medium | Base LCS | Template problem |
| | Longest Common Substring | [GFG](https://practice.geeksforgeeks.org/problems/longest-common-substring) | Medium | Continuous version | Reset on mismatch |
| | Print LCS | [GFG](https://practice.geeksforgeeks.org/problems/print-all-lcs-sequences) | Medium | Backtracking | Reconstruct solution |
| | Shortest Common Supersequence | [LC 1092](https://leetcode.com/problems/shortest-common-supersequence/) | Hard | Merge sequences | Include both |
| | Minimum Insertions/Deletions | [GFG](https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions) | Medium | To make s1 = s2 | LCS application |
| | Longest Palindromic Subsequence | [LC 516](https://leetcode.com/problems/longest-palindromic-subsequence/) | Medium | LCS(s, reverse(s)) | Palindrome via LCS |
| | Minimum Deletions for Palindrome | [GFG](https://practice.geeksforgeeks.org/problems/minimum-deletitions) | Medium | n - LPS | Make palindrome |
| | Minimum Insertions for Palindrome | [LC 1312](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/) | Hard | Same as deletions | Symmetric problem |
| | Longest Repeating Subsequence | [GFG](https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence) | Medium | LCS with constraint | i ≠ j condition |
| | Distinct Subsequences | [LC 115](https://leetcode.com/problems/distinct-subsequences/) | Hard | Count occurrences | t in s |
| | Edit Distance | [LC 72](https://leetcode.com/problems/edit-distance/) | Medium | Insert/delete/replace | Levenshtein distance |
| | Wildcard Matching | [LC 44](https://leetcode.com/problems/wildcard-matching/) | Hard | * and ? | Pattern matching |
| | Regular Expression Matching | [LC 10](https://leetcode.com/problems/regular-expression-matching/) | Hard | . and * | Regex DP |
| | Interleaving String | [LC 97](https://leetcode.com/problems/interleaving-string/) | Medium | Merge two strings | Check if possible |

**Key Pattern**:
```cpp
if(s1[i] == s2[j])
    dp[i][j] = 1 + dp[i-1][j-1];
else
    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
```

---

### **4.2 Longest Increasing Subsequence (LIS) Family**

#### Pattern: Find increasing/decreasing subsequences

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| ⭐ | Longest Increasing Subsequence | [LC 300](https://leetcode.com/problems/longest-increasing-subsequence/) | Medium | Classic LIS | O(n²) & O(n log n) |
| | Increasing Subsequence | [CSES](https://cses.fi/problemset/task/1145) | Easy | Same as LC 300 | CSES version |
| | Print LIS | [GFG](https://practice.geeksforgeeks.org/problems/printing-longest-increasing-subsequence) | Medium | Backtracking | Reconstruct |
| | Longest Increasing Path in Matrix | [LC 329](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/) | Hard | 2D LIS + DFS | Memoization |
| | Number of LIS | [LC 673](https://leetcode.com/problems/number-of-longest-increasing-subsequence/) | Medium | Count all LIS | Track count |
| | Longest Bitonic Subsequence | [GFG](https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence) | Medium | LIS + LDS | Increase then decrease |
| | Russian Doll Envelopes | [LC 354](https://leetcode.com/problems/russian-doll-envelopes/) | Hard | 2D LIS | Sort + LIS |
| | Maximum Height by Stacking Cuboids | [LC 1691](https://leetcode.com/problems/maximum-height-by-stacking-cuboids/) | Hard | 3D constraint | Complex LIS |
| | Largest Divisible Subset | [LC 368](https://leetcode.com/problems/largest-divisible-subset/) | Medium | LIS variant | Divisibility condition |
| | Longest Arithmetic Subsequence | [LC 1027](https://leetcode.com/problems/longest-arithmetic-subsequence/) | Medium | Fixed difference | Track diff |
| | Longest Arithmetic Subsequence of Given Difference | [LC 1218](https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/) | Medium | Given diff | HashMap + DP |

**O(n log n) LIS using Binary Search**:
```cpp
vector<int> lis;
for(int x : nums) {
    auto it = lower_bound(lis.begin(), lis.end(), x);
    if(it == lis.end()) lis.push_back(x);
    else *it = x;
}
return lis.size();
```

---

### **4.3 Palindrome Problems**

#### Pattern: Expand around center or use ranges

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| ⭐ | Longest Palindromic Substring | [LC 5](https://leetcode.com/problems/longest-palindromic-substring/) | Medium | Expand around center | O(n²) |
| | Longest Palindromic Subsequence | [LC 516](https://leetcode.com/problems/longest-palindromic-subsequence/) | Medium | Range DP | LCS variant |
| | Palindromic Substrings | [LC 647](https://leetcode.com/problems/palindromic-substrings/) | Medium | Count all | Expand method |
| | Palindrome Partitioning II | [LC 132](https://leetcode.com/problems/palindrome-partitioning-ii/) | Hard | Min cuts | Precompute palindromes |
| | Palindrome Partitioning IV | [LC 1745](https://leetcode.com/problems/palindrome-partitioning-iv/) | Hard | Split into 3 | Check feasibility |
| | Count Palindromic Subsequences | [LC 730](https://leetcode.com/problems/count-different-palindromic-subsequences/) | Hard | Count distinct | 3D DP |
| | Valid Palindrome III | [LC 1216](https://leetcode.com/problems/valid-palindrome-iii/) | Hard | K removals allowed | Edit distance variant |

---

## **Level 5: Advanced Patterns**
**Goal**: Handle complex state spaces and optimizations

### **5.1 State Machine DP**

#### Pattern: Explicit state transitions (buy/sell, active/inactive)

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| | Paint House | [LC 256](https://leetcode.com/problems/paint-house/) | Medium | 3 states | RGB coloring |
| | Paint House II | [LC 265](https://leetcode.com/problems/paint-house-ii/) | Hard | K colors | Optimize to O(nk) |
| | Paint Fence | [LC 276](https://leetcode.com/problems/paint-fence/) | Medium | Same/different color | State transitions |
| | Knight Dialer | [LC 935](https://leetcode.com/problems/knight-dialer/) | Medium | Phone keypad | Valid moves |
| | Domino and Tromino Tiling | [LC 790](https://leetcode.com/problems/domino-and-tromino-tiling/) | Medium | 4 states | Tile patterns |
| | Number of Ways to Stay Same Place | [LC 1269](https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/) | Hard | Position tracking | Array walk |

---

### **5.2 DP on Strings - Advanced**

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| | Word Break | [LC 139](https://leetcode.com/problems/word-break/) | Medium | String partition | Dictionary lookup |
| | Word Break II | [LC 140](https://leetcode.com/problems/word-break-ii/) | Hard | Return all solutions | Backtracking + DP |
| | Concatenated Words | [LC 472](https://leetcode.com/problems/concatenated-words/) | Hard | Multiple word breaks | Recursive DP |
| | Scramble String | [LC 87](https://leetcode.com/problems/scramble-string/) | Hard | Binary tree partition | 3D DP |
| | Count Different Palindromic Subsequences | [LC 730](https://leetcode.com/problems/count-different-palindromic-subsequences/) | Hard | Distinct palindromes | Complex counting |

---

### **5.3 DP with Data Structures**

#### Pattern: Combine DP with segment trees, maps, sets

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| | Longest Increasing Subsequence | [LC 300](https://leetcode.com/problems/longest-increasing-subsequence/) | Medium | Binary search + DP | O(n log n) |
| | Russian Doll Envelopes | [LC 354](https://leetcode.com/problems/russian-doll-envelopes/) | Hard | Sort + BIT/Segment | Optimize LIS |
| | Count of Smaller Numbers After Self | [LC 315](https://leetcode.com/problems/count-of-smaller-numbers-after-self/) | Hard | Fenwick tree | Inversion count |
| | Create Sorted Array | [LC 1649](https://leetcode.com/problems/create-sorted-array-through-instructions/) | Hard | BIT/Segment tree | Dynamic queries |

---

## **Level 6: Game Theory & Trees**
**Goal**: Master min-max and tree DP

### **6.1 Game Theory DP (Minimax)**

#### Pattern: Two players, optimal play

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| ⭐ | Stone Game | [LC 877](https://leetcode.com/problems/stone-game/) | Medium | Two-player DP | Alice vs Bob |
| | Stone Game II | [LC 1140](https://leetcode.com/problems/stone-game-ii/) | Medium | Variable M | Complex state |
| | Stone Game III | [LC 1406](https://leetcode.com/problems/stone-game-iii/) | Medium | Take 1/2/3 | Suffix DP |
| | Stone Game IV | [LC 1510](https://leetcode.com/problems/stone-game-iv/) | Hard | Perfect squares | Nim-like |
| | Predict the Winner | [LC 486](https://leetcode.com/problems/predict-the-winner/) | Medium | Range game | 2D DP |
| | Nim Game | [LC 292](https://leetcode.com/problems/nim-game/) | Easy | Game theory | Mathematical pattern |
| | Can I Win | [LC 464](https://leetcode.com/problems/can-i-win/) | Medium | Bitmask + game | State = used numbers |
| | Coin Game Winner | [CSES](https://cses.fi/problemset/task/1744) | Medium | Rectangle game | Losing positions |

---

### **6.2 Tree DP**

#### Pattern: DP on tree structures

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| ⭐ | House Robber III | [LC 337](https://leetcode.com/problems/house-robber-iii/) | Medium | Binary tree DP | Rob or not rob |
| | Binary Tree Cameras | [LC 968](https://leetcode.com/problems/binary-tree-cameras/) | Hard | 3 states | Covered/has camera/none |
| | Longest Path in Tree | [GFG](https://practice.geeksforgeeks.org/problems/longest-path-in-a-directed-acyclic-graph) | Medium | Tree diameter | Two DFS passes |
| | Tree Diameter | [CSES](https://cses.fi/problemset/task/1131) | Easy | Max distance | Classic problem |
| | Tree Distances I | [CSES](https://cses.fi/problemset/task/1132) | Medium | All pairs max | Rerooting technique |
| | Tree Distances II | [CSES](https://cses.fi/problemset/task/1133) | Medium | Sum of distances | Subtree DP |
| | Tree Matching | [CSES](https://cses.fi/problemset/task/1130) | Medium | Max matching | Independent set |
| | Maximum Path Sum in Binary Tree | [LC 124](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | Hard | Any path | Global max tracking |
| | Distribute Coins in Binary Tree | [LC 979](https://leetcode.com/problems/distribute-coins-in-binary-tree/) | Medium | Min moves | Balance coins |

---

## **Level 7: Bitmask & Optimization**
**Goal**: Handle complex states and optimizations

### **7.1 Bitmask DP**

#### Pattern: State represented as bitmask (set of chosen items)

| # | Problem | Platform | Difficulty | Pattern | Notes |
|---|---------|----------|------------|---------|-------|
| ⭐ | Traveling Salesman (TSP) | [GFG](https://practice.geeksforgeeks.org/problems/travelling-salesman-problem) | Hard | Visit all cities | Classic bitmask DP |
| | Shortest Path Visiting All Nodes | [LC 847](https://leetcode.com/problems/shortest-path-visiting-all-nodes/) | Hard | BFS + bitmask | Start from any node |
| | Minimum Cost to Connect Cities | [LC 1135](https://leetcode.com/problems/connecting-cities-with-minimum-cost/) | Medium | MST variant | Union-find better |
| | Find Shortest Path with K Hops | [LC 1928](https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/) | Hard | Time constraint | 3D DP |
| | Partition to K Equal Sum Subsets | [LC 698](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/) | Medium | Subset selection | Backtrack + memo |
| | Maximum Students Taking Exam | [LC 1349](https://leetcode.com/problems/maximum-students-taking-exam/) | Hard | Seating arrangement |
