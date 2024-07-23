class Solution {
public:
    // Function to return a list of integers denoting the node
    // values of both the BSTs in a sorted order.
    vector<int> merge(Node* root1, Node* root2) {
        vector<int> list1;
        vector<int> list2;
        
        // Perform in-order traversal on both BSTs and store the results in list1 and list2
        inOrderTraversal(root1, list1);
        inOrderTraversal(root2, list2);
        
        // Merge the two sorted lists
        return mergeSortedLists(list1, list2);
    }

private:
    // Helper function to perform in-order traversal and store the result in a list
    void inOrderTraversal(Node* root, vector<int>& result) {
        if (root == nullptr) {
            return;
        }
        inOrderTraversal(root->left, result);
        result.push_back(root->data);
        inOrderTraversal(root->right, result);
    }

    // Helper function to merge two sorted lists
    vector<int> mergeSortedLists(const vector<int>& list1, const vector<int>& list2) {
        vector<int> mergedList;
        int i = 0, j = 0;
        
        while (i < list1.size() && j < list2.size()) {
            if (list1[i] < list2[j]) {
                mergedList.push_back(list1[i]);
                i++;
            } else {
                mergedList.push_back(list2[j]);
                j++;
            }
        }
        
        // Add remaining elements from list1
        while (i < list1.size()) {
            mergedList.push_back(list1[i]);
            i++;
        }
        
        // Add remaining elements from list2
        while (j < list2.size()) {
            mergedList.push_back(list2[j]);
            j++;
        }
        
        return mergedList;
    }
