package Information_system;

import Information_system.MemberDAO;

public class MemberService {

    MemberDAO memberDAO = new MemberDAO();

    // 👤 회원가입
    public void register(String id, String pw, String name) {

        memberDAO.insertMember(id, pw, name);
    }

    // 👤 로그인
    public boolean login(String id, String pw) {

        return memberDAO.login(id, pw);
    }
}
    

