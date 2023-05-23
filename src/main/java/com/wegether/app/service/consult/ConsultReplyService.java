package com.wegether.app.service.consult;

import com.wegether.app.domain.dto.ConsultReplyDTO;
import com.wegether.app.domain.dto.LecturePagination;
import com.wegether.app.domain.dto.ReplyDTO;

import java.util.List;
import java.util.Optional;

public interface
ConsultReplyService {

    // 댓글등록
    public void registerReply(ConsultReplyDTO consultReplyDTO);

    // 대댓글 등록
    public void registerReplyAgain(ConsultReplyDTO consultReplyDTO);

    //일반 댓글 페이징처리 조회
    public List<ConsultReplyDTO> getList(Long consultingId, LecturePagination lecturePagination);

    //일반 댓글 총개수
    public int getTotal(Long consultingId);


    // 대댓글 전체 조회
    public List<ConsultReplyDTO> getListAgain(Long consultingId);


    // 대댓글 전체 개수
    public int getTotalAgain(Long consultingId, Long replyGroup);


    // 중간 테이블 삽입
    public void registerMiddle(Long id, Long memberId, Long consultingId);

    //일반 댓글, 대댓글 삭제
    public void removeReply(Long id);

    //대댓글 전체삭제
    public void removeReplyAgainAll(Long replyGroup);

    //중간 테이블 삭제
    public void removeMiddle(Long id);


    // 원하는 댓글 조회
    public Optional<ConsultReplyDTO> get(Long id);


    //  원하는  대댓글 조회
    public List<ConsultReplyDTO> getAgain(Long replyGroup);


}
