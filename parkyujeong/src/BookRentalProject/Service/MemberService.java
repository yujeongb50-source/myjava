//규칙 처리




package BookRentalProject.Service;

public class MemberService {

    MemberDAO memberDAO = new MemberDAO();

    // 👤 회원가입
    public void register(String id, String pw, String name, String phone) {

        memberDAO.insertMember(id, pw, name, phone);
    }

    // 👤 로그인
    public boolean login(String id, String pw) {

        return memberDAO.login(id, pw);
    }
}
