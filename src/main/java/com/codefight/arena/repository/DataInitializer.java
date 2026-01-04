package com.codefight.arena.repository;


import com.codefight.arena.model.Difficulty;
import com.codefight.arena.model.Problem;
import com.codefight.arena.model.StarterCode;
import com.codefight.arena.model.TestCase;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    private final ProblemRepository problemRepository;

    public DataInitializer(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    @PostConstruct
    public void initializeProblems() {
        logger.info("Initializing problem repository with seed data...");

        initializeTwoSum();
        initializeValidParentheses();
        initializeReverseLinkedList();

        logger.info("Problem repository initialize with {} problems ", problemRepository.findAll().size());
    }

    // ============================================
    // PROBLEM 1: Two Sum (Easy)
    // ============================================
    private void initializeTwoSum() {
        String description = """
                ## Two Sum
                
                Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.
                
                You may assume that each input would have **exactly one solution**, and you may not use the same element twice.
                
                You can return the answer in any order.
                
                ### Example 1:
```
                Input: nums = [2,7,11,15], target = 9
                Output: [0,1]
                Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
```
                
                ### Example 2:
```
                Input: nums = [3,2,4], target = 6
                Output: [1,2]
```
                
                ### Example 3:
```
                Input: nums = [3,3], target = 6
                Output: [0,1]
```
                
                ### Constraints:
                - 2 <= nums.length <= 10^4
                - -10^9 <= nums[i] <= 10^9
                - -10^9 <= target <= 10^9
                - **Only one valid answer exists.**
                
                ### Follow-up:
                Can you come up with an algorithm that is less than O(n²) time complexity?
                """;

        List<TestCase> testCases = List.of(
                // Visible test cases
                TestCase.builder()
                        .id("tc1")
                        .input("{\"nums\": [2,7,11,15], \"target\": 9}")
                        .expectedOutput("[0,1]")
                        .isHidden(false)
                        .explanation("nums[0] + nums[1] = 2 + 7 = 9")
                        .build(),

                TestCase.builder()
                        .id("tc2")
                        .input("{\"nums\": [3,2,4], \"target\": 6}")
                        .expectedOutput("[1,2]")
                        .isHidden(false)
                        .explanation("nums[1] + nums[2] = 2 + 4 = 6")
                        .build(),

                // Hidden test case (for final submission validation)
                TestCase.builder()
                        .id("tc3")
                        .input("{\"nums\": [1,5,8,3,9,2], \"target\": 11}")
                        .expectedOutput("[2,3]")
                        .isHidden(true)
                        .explanation("nums[2] + nums[3] = 8 + 3 = 11")
                        .build()
        );

        StarterCode starterCode = StarterCode.builder()
                .java("""
                        class Solution {
                            public int[] twoSum(int[] nums, int target) {
                                // Your code here
                                
                            }
                        }
                        """)
                .python("""
                        class Solution:
                            def twoSum(self, nums: List[int], target: int) -> List[int]:
                                # Your code here
                                pass
                        """)
                .javascript("""
                        /**
                         * @param {number[]} nums
                         * @param {number} target
                         * @return {number[]}
                         */
                        var twoSum = function(nums, target) {
                            // Your code here
                            
                        };
                        """)
                .build();

        Problem twoSum = Problem.builder()
                .id("two-sum")
                .title("Two Sum")
                .difficulty(String.valueOf(Difficulty.EASY))
                .description(description)
                .topics(List.of("Array", "Hash Table"))
                .testCases(testCases.toString())
                .starterCode(starterCode)
                .timeLimit(2000)  // 2 seconds
                .memoryLimit(256) // 256 MB
                .build();

        problemRepository.save(twoSum);
        logger.debug("Initialized problem: Two Sum");
    }
    // ============================================
    // PROBLEM 2: Valid Parentheses (Easy)
    // ============================================
    private void initializeValidParentheses() {
        String description = """
                ## Valid Parentheses
                
                Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.
                
                An input string is valid if:
                1. Open brackets must be closed by the same type of brackets.
                2. Open brackets must be closed in the correct order.
                3. Every close bracket has a corresponding open bracket of the same type.
                
                ### Example 1:
```
                Input: s = "()"
                Output: true
```
                
                ### Example 2:
```
                Input: s = "()[]{}"
                Output: true
```
                
                ### Example 3:
```
                Input: s = "(]"
                Output: false
```
                
                ### Example 4:
```
                Input: s = "([])"
                Output: true
```
                
                ### Constraints:
                - 1 <= s.length <= 10^4
                - `s` consists of parentheses only `'()[]{}'`
                """;

        List<TestCase> testCases = List.of(
                TestCase.builder()
                        .id("tc1")
                        .input("{\"s\": \"()\"}")
                        .expectedOutput("true")
                        .isHidden(false)
                        .explanation("Single pair of parentheses is valid")
                        .build(),

                TestCase.builder()
                        .id("tc2")
                        .input("{\"s\": \"()[]{}\"}")
                        .expectedOutput("true")
                        .isHidden(false)
                        .explanation("All brackets properly closed in order")
                        .build(),

                TestCase.builder()
                        .id("tc3")
                        .input("{\"s\": \"({[()]})\"}")
                        .expectedOutput("true")
                        .isHidden(true)
                        .explanation("Nested brackets properly matched")
                        .build()
        );

        StarterCode starterCode = StarterCode.builder()
                .java("""
                        class Solution {
                            public boolean isValid(String s) {
                                // Your code here
                                
                            }
                        }
                        """)
                .python("""
                        class Solution:
                            def isValid(self, s: str) -> bool:
                                # Your code here
                                pass
                        """)
                .javascript("""
                        /**
                         * @param {string} s
                         * @return {boolean}
                         */
                        var isValid = function(s) {
                            // Your code here
                            
                        };
                        """)
                .build();

        Problem validParentheses = Problem.builder()
                .id("valid-parentheses")
                .title("Valid Parentheses")
                .difficulty(String.valueOf(Difficulty.EASY))
                .description(description)
                .topics(List.of("String", "Stack"))
                .testCases(testCases.toString())
                .starterCode(starterCode)
                .timeLimit(2000)
                .memoryLimit(256)
                .build();

        problemRepository.save(validParentheses);
        logger.debug("Initialized problem: Valid Parentheses");
    }

    // ============================================
    // PROBLEM 3: Reverse Linked List (Medium)
    // ============================================
    private void initializeReverseLinkedList() {
        String description = """
                ## Reverse Linked List
                
                Given the `head` of a singly linked list, reverse the list, and return the reversed list.
                
                ### Example 1:
```
                Input: head = [1,2,3,4,5]
                Output: [5,4,3,2,1]
```
```
                1 → 2 → 3 → 4 → 5 → null
                         ↓
                5 → 4 → 3 → 2 → 1 → null
```
                
                ### Example 2:
```
                Input: head = [1,2]
                Output: [2,1]
```
                
                ### Example 3:
```
                Input: head = []
                Output: []
```
                
                ### Constraints:
                - The number of nodes in the list is in the range [0, 5000]
                - -5000 <= Node.val <= 5000
                
                ### Follow-up:
                A linked list can be reversed either iteratively or recursively. Could you implement both?
                """;

        List<TestCase> testCases = List.of(
                TestCase.builder()
                        .id("tc1")
                        .input("{\"head\": [1,2,3,4,5]}")
                        .expectedOutput("[5,4,3,2,1]")
                        .isHidden(false)
                        .explanation("Standard case: reverse a 5-node list")
                        .build(),

                TestCase.builder()
                        .id("tc2")
                        .input("{\"head\": [1,2]}")
                        .expectedOutput("[2,1]")
                        .isHidden(false)
                        .explanation("Two node list reversal")
                        .build(),

                TestCase.builder()
                        .id("tc3")
                        .input("{\"head\": []}")
                        .expectedOutput("[]")
                        .isHidden(false)
                        .explanation("Edge case: empty list")
                        .build(),

                TestCase.builder()
                        .id("tc4")
                        .input("{\"head\": [1,2,3,4,5,6,7,8,9,10]}")
                        .expectedOutput("[10,9,8,7,6,5,4,3,2,1]")
                        .isHidden(true)
                        .explanation("Larger list to test performance")
                        .build()
        );

        StarterCode starterCode = StarterCode.builder()
                .java("""
                        /**
                         * Definition for singly-linked list.
                         * public class ListNode {
                         *     int val;
                         *     ListNode next;
                         *     ListNode() {}
                         *     ListNode(int val) { this.val = val; }
                         *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
                         * }
                         */
                        class Solution {
                            public ListNode reverseList(ListNode head) {
                                // Your code here
                                
                            }
                        }
                        """)
                .python("""
                        # Definition for singly-linked list.
                        # class ListNode:
                        #     def __init__(self, val=0, next=None):
                        #         self.val = val
                        #         self.next = next
                        
                        class Solution:
                            def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
                                # Your code here
                                pass
                        """)
                .javascript("""
                        /**
                         * Definition for singly-linked list.
                         * function ListNode(val, next) {
                         *     this.val = (val===undefined ? 0 : val)
                         *     this.next = (next===undefined ? null : next)
                         * }
                         */
                        /**
                         * @param {ListNode} head
                         * @return {ListNode}
                         */
                        var reverseList = function(head) {
                            // Your code here
                            
                        };
                        """)
                .build();

        Problem reverseLinkedList = Problem.builder()
                .id("reverse-linked-list")
                .title("Reverse Linked List")
                .difficulty(String.valueOf(Difficulty.MEDIUM))
                .description(description)
                .topics(List.of("Linked List", "Recursion"))
                .testCases(testCases.toString())
                .starterCode(starterCode)
                .timeLimit(2000)
                .memoryLimit(256)
                .build();

        problemRepository.save(reverseLinkedList);
        logger.debug("Initialized problem: Reverse Linked List");
    }
}
