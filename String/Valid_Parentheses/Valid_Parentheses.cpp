class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        st.push(s[0]);
        for(int i=1;i<s.size();i++) {
            if(st.empty()) {
                st.push(s[i]);
                continue;
            }
            if((st.top()== '(' && s[i]== ')')||(st.top()== '[' && s[i]== ']')||(st.top()== '{' && s[i]== '}')) {
                st.pop();
                continue;
            }
            st.push(s[i]);
        }            
        if(st.empty())return true;  
        return false;
    }
};
