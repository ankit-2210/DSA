class Solution:
    def isValid(self, s: str) -> bool:
        n=len(s)

        st=[]
        for ch in s:
            if ch in '({[':
                st.append(ch)
            else:
                if not st:
                    return False
                
                if((ch == ')' and st[-1] != '(') or (ch == '}' and st[-1] != '{') or (ch == ']' and st[-1] != '[')):
                    return False

                st.pop()

        return not st