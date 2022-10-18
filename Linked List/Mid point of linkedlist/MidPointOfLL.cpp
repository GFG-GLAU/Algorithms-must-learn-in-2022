
#include <iostream>
using namespace std;

class Node {
public:
	int data;
	Node* next;
};

class NodeOperation {
public:
	
	void pushNode(class Node** head_ref, int data_val)
	{

	
		class Node* new_node = new Node();


		new_node->data = data_val;

		new_node->next = *head_ref;
		*head_ref = new_node;
	}


	void printNode(class Node* head)
	{
		while (head != NULL) {
			cout << head->data << "->";
			head = head->next;
		}
		cout << "NULL" << endl;
	}

	/* Utility Function to find length of linked list */
	int getLen(class Node* head)
	{
		int len = 0;
		class Node* temp = head;
		while (temp) {
			len++;
			temp = temp->next;
		}
		return len;
	}

	void printMiddle(class Node* head)
	{

		if (head) {
			// find length
			int len = getLen(head);
			class Node* temp = head;

			// trvaers till we reached half of length
			int midIdx = len / 2;
			while (midIdx--) {
				temp = temp->next;
			}
			// temp will be storing middle element
			cout << "The middle element is [" << temp->data
				<< "]" << endl;
		}
	}
};

// Driver Code
int main()
{
	class Node* head = NULL;
	class NodeOperation* temp = new NodeOperation();
	for (int i = 5; i > 0; i--) {
		temp->pushNode(&head, i);
		temp->printNode(head);
		temp->printMiddle(head);
	}
	return 0;
}


