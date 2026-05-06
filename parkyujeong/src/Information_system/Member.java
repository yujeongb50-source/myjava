package Information_system;

import Information_system.Member;

public class Member {

        private String member_id;
        private String password;
        private String name;
        public String getMember_id() {
            return member_id;
        }
        public String getPassword() {
            return password;
        }
        public String getName() {
            return name;
        }
        public void setMember_id(String member_id) {
            this.member_id = member_id;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Member [member_id=" + member_id + ", password=" + password + ", name=" + name + "]";
        }
        
    }
    
